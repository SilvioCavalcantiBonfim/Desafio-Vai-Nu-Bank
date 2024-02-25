package domain.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

import domain.entity.account.Account;
import domain.entity.account.savingsaccount.SavingsDeposit;

class SavingsAccountQueueProcessServiceImpl extends TimerTask implements SavingsAccountQueueProcessService {

  private static SavingsAccountQueueProcessServiceImpl instance = null;
  private static Timer timer = null;

  private final TimeService timeService;
  private final AccountService accountService;

  private Map<String, Deque<SavingsDeposit>> allSavingsAccountQueue = new ConcurrentHashMap<>();

  private SavingsAccountQueueProcessServiceImpl() {
    timeService = TimeService.getInstance();
    accountService = AccountService.getInstance();
  }

  @Override
  public void addSavingsDepositQueue(String accountId, Deque<SavingsDeposit> queue) {
    allSavingsAccountQueue.put(accountId, queue);
  }

  @Override
  public void run() {
    allSavingsAccountQueue.forEach(this::proccessQueue);
  }

  private void proccessQueue(String accountId, Deque<SavingsDeposit> queue) {

    accountService.findById(accountId).ifPresentOrElse((account) -> processAllDeposit(accountId, queue, account),
        removeIfNotPresent(accountId));
  }

  private Runnable removeIfNotPresent(String accountId) {
    return () -> allSavingsAccountQueue.remove(accountId);
  }

  private void processAllDeposit(String accountId, Deque<SavingsDeposit> queue, Account currentAccountProcess) {
    LocalDate currentData = timeService.currentDay();
    List<SavingsDeposit> allDepositProccess = queue.stream().filter((e) -> e.anniversary().isEqual(currentData))
        .toList();
    if (!allDepositProccess.isEmpty()) {
      BigDecimal currentValue = allDepositProccess.stream().map(e -> e.value()).reduce(BigDecimal.ZERO,
          (a, v) -> a.add(v));
      queue.removeIf(allDepositProccess::contains);
      queue.add(new SavingsDeposit(currentValue, currentData.plusMonths(1)));
      if (accountService.findById(accountId).isPresent())
        currentAccountProcess.deposit(currentValue.multiply(BigDecimal.valueOf(0.005)));
    }
  }

  public static SavingsAccountQueueProcessServiceImpl getInstance() {
    if (Objects.isNull(instance)) {
      instance = new SavingsAccountQueueProcessServiceImpl();
    }
    return instance;
  }

  public static void boot() {
    if (Objects.isNull(timer)) {
      timer = new Timer();
      timer.schedule(getInstance(), 0, TimeService.TIME_SCALE);
    }
  }
}
