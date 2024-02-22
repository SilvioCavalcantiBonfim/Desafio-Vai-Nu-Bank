package domain.account.savingsaccount;

import java.math.BigDecimal;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

import domain.account.savingsaccount.process.SavingsAccountProcess;
import logger.Logger;
import service.TimeService;

class SavingsAccountQueue {

  private Deque<SavingsDeposit> queue;
  private final TimeService timeService;

  private static final int NEGATIVE_SIGNUM = -1;

  private Logger logger = new Logger(getClass());

  public SavingsAccountQueue(String accountId) {
    queue = new ConcurrentLinkedDeque<>();
    SavingsAccountProcess.getInstance().addSavingsDepositQueue(accountId, queue);
    timeService = TimeService.getInstance();
  }

  public void addDeposit(BigDecimal depositAmount) {
    SavingsDeposit newDeposit = new SavingsDeposit(depositAmount, timeService.currentDay().plusMonths(1));
    queue.offerLast(newDeposit);
    logger.debug(queue);
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
    logger.debug(queue);
  }

  private BigDecimal requeueSavingsDeposit(SavingsDeposit currentDeposit, BigDecimal remainingAmountAfterWithdrawal) {
    SavingsDeposit updateDeposit = new SavingsDeposit(remainingAmountAfterWithdrawal.abs(),
        currentDeposit.anniversary().plusMonths(1));
    queue.offerLast(updateDeposit);
    remainingAmountAfterWithdrawal = BigDecimal.ZERO;
    return remainingAmountAfterWithdrawal;
  }
}
