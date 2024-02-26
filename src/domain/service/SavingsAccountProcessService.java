package domain.service;

import java.util.Deque;

import domain.entity.account.savingsaccount.SavingsDeposit;

public interface SavingsAccountProcessService {
  void addSavingsDepositQueue(String accountId, Deque<SavingsDeposit> queue);

  public static void boot(){
    SavingsAccountProcessServiceImpl.boot();
  }

  public static SavingsAccountProcessService getInstance() {
    return SavingsAccountProcessServiceImpl.getInstance();
  }
}