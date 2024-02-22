package domain.account.savingsaccount;

import java.math.BigDecimal;

import domain.account.Account;

public class SavingsAccount extends Account {

  private SavingsAccountQueue queue;

  public SavingsAccount(String accountId, String accountHolderName, String accountHolderCPF, BigDecimal value) {
    super(accountId, accountHolderName, accountHolderCPF, BigDecimal.ZERO);
    queue = new SavingsAccountQueue(accountId);
    this.deposit(value);
  }

  @Override
  public void withdraw(BigDecimal value) {
    BigDecimal amountWithdraw = value.multiply(BigDecimal.valueOf(1.02));
    this.decrementValue(amountWithdraw);
    queue.withdrawAmount(amountWithdraw);

  }

  @Override
  public void deposit(BigDecimal value) {
    this.incrementValue(value);
    queue.addDeposit(value);
  }

}
