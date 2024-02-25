package domain.service;

import java.util.Deque;

import domain.entity.account.savingsaccount.SavingsDeposit;

public interface SavingsAccountQueueProcessService {
  void addSavingsDepositQueue(String accountId, Deque<SavingsDeposit> queue);

  public static void boot(){
    SavingsAccountQueueProcessServiceImpl.boot();
  }

  public static SavingsAccountQueueProcessService getInstance() {
    return SavingsAccountQueueProcessServiceImpl.getInstance();
  }
}