package domain.entity.account.savingsaccount;

import java.math.BigDecimal;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

import domain.service.SavingsAccountProcessService;
import domain.service.TimeService;

class SavingsAccountQueue {

  private Deque<SavingsDeposit> queue;
  
  private final TimeService timeService;

  private static final int NEGATIVE_SIGNUM = -1;

  public SavingsAccountQueue(String accountId) {
    queue = new ConcurrentLinkedDeque<>();
    SavingsAccountProcessService.getInstance().addSavingsDepositQueue(accountId, queue);
    timeService = TimeService.getInstance();
  }

  public void addDeposit(BigDecimal depositAmount) {
    SavingsDeposit newDeposit = new SavingsDeposit(depositAmount, timeService.currentDay().plusMonths(1));
    queue.offerLast(newDeposit);
  }

  public void withdrawAmount(BigDecimal withdrawalAmount) {
    BigDecimal remainingWithdrawalAmount = withdrawalAmount;
    while (!queue.isEmpty() && remainingWithdrawalAmount.signum() == 1) {
      SavingsDeposit currentDeposit = queue.pollFirst();
      BigDecimal remainingAmountAfterWithdrawal = remainingWithdrawalAmount.subtract(currentDeposit.value());
      if (remainingAmountAfterWithdrawal.signum() == NEGATIVE_SIGNUM) {
        remainingAmountAfterWithdrawal = requeueSavingsDeposit(currentDeposit, remainingAmountAfterWithdrawal);
      }
      remainingWithdrawalAmount = remainingAmountAfterWithdrawal;
    }
  }

  private BigDecimal requeueSavingsDeposit(SavingsDeposit currentDeposit, BigDecimal remainingAmountAfterWithdrawal) {
    SavingsDeposit updateDeposit = new SavingsDeposit(remainingAmountAfterWithdrawal.abs(),
        currentDeposit.anniversary().plusMonths(1));
    queue.offerLast(updateDeposit);
    remainingAmountAfterWithdrawal = BigDecimal.ZERO;
    return remainingAmountAfterWithdrawal;
  }
}
