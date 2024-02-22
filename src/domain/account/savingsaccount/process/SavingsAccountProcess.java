package domain.account.savingsaccount.process;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import domain.account.Account;
import domain.account.savingsaccount.SavingsDeposit;
import repository.AccountRepository;
import service.TimeService;

public class SavingsAccountProcess extends TimerTask {

  private static SavingsAccountProcess instance = null;
  private static Timer timer = null;

  private final TimeService timeService;
  private final AccountRepository accountRepository;

  private Map<String, Deque<SavingsDeposit>> allSavingsAccountQueue = new HashMap<>();

  private SavingsAccountProcess() {
    timeService = TimeService.getInstance();
    accountRepository = AccountRepository.getInstance();
  }


  public void addSavingsDepositQueue(String accountId, Deque<SavingsDeposit> queue) {
    allSavingsAccountQueue.put(accountId, queue);
  }

  @Override
  public void run() {
    allSavingsAccountQueue.forEach(this::proccessQueue);
  }
  
  private void proccessQueue(String accountId, Deque<SavingsDeposit> queue) {
    
    Account currentAccountProcess = accountRepository.find(accountId).get();
    LocalDate currentData = timeService.currentDay();
    
    List<SavingsDeposit> allDepositProccess = queue.stream().filter((e) -> e.anniversary().isEqual(currentData)).toList();
    if (!allDepositProccess.isEmpty()) {
      BigDecimal currentValue = allDepositProccess.stream().map(e -> e.value()).reduce(BigDecimal.ZERO, (a, v) -> a.add(v));
      queue.removeIf(allDepositProccess::contains);
      queue.add(new SavingsDeposit(currentValue, currentData.plusMonths(1)));
      currentAccountProcess.deposit(currentValue.multiply(BigDecimal.valueOf(0.005)));
    }
  }

  public static SavingsAccountProcess getInstance() {
    if (Objects.isNull(instance)) {
      instance = new SavingsAccountProcess();
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
