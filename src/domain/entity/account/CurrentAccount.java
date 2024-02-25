package domain.entity.account;

import java.math.BigDecimal;

public class CurrentAccount extends Account {

  @SuppressWarnings("unused")
  private final BigDecimal creditLimit;

  public CurrentAccount(String accountId, String accountHolderName, String accountHolderCPF,
      BigDecimal value, BigDecimal creditLimit) {
    super(accountId, accountHolderName, accountHolderCPF, value);
    this.creditLimit = creditLimit;
  }

  @Override
  public void withdraw(BigDecimal value) {
    this.decrementValue(value);
  }
  
  @Override
  public void deposit(BigDecimal value) {
    this.incrementValue(value);
  }
  
}
