package domain.service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import domain.entity.account.currentaccount.CurrentAccount;

class CurrentAccountProcessServiceImpl extends TimerTask implements CurrentAccountProcessService {

  private static CurrentAccountProcessServiceImpl instance = null;
  private static Timer timer = null;

  private final AccountService accountService;

  private final Set<String> allAccountProcess = new HashSet<>();

  private CurrentAccountProcessServiceImpl() {
    accountService = AccountService.getInstance();
  }

  public CurrentAccountProcessServiceImpl(AccountService accountService) {
    this.accountService = accountService;
  }

  public static void boot() {
    if (Objects.isNull(timer)) {
      timer = new Timer();
      timer.schedule(getInstance(), 0, TimeService.TIME_SCALE);
    }
  }

  public static CurrentAccountProcessServiceImpl getInstance() {
    if (Objects.isNull(instance)) {
      instance = new CurrentAccountProcessServiceImpl();
    }
    return instance;
  }

  @Override
  public void run() {
    final Set<String> nextSetProcess = new HashSet<>();
    allAccountProcess.stream().forEach(accountId -> {
      accountService.findById(accountId).ifPresent((account) -> {
        CurrentAccount currentAccount = (CurrentAccount) account;
        currentAccount.processOverdraftBalance();
        nextSetProcess.add(accountId);
      });
    });
    allAccountProcess.clear();
    allAccountProcess.addAll(nextSetProcess);
  }

  @Override
  public void addAccountToNextProcess(String accountId) {
    allAccountProcess.add(accountId);
  }

  @Override
  public void removeAccountToNextProcess(String accountId) {
    allAccountProcess.remove(accountId);
  }
}
