package domain.entity.account;

import java.math.BigDecimal;

import exception.InvalidDecrementAmountException;
import exception.InvalidIncrementAmountException;

public abstract class Account implements Operator {

  private final String accountId;
  private final String accountHolderName;
  private final String accountHolderCPF;
  private BigDecimal value;

  public Account(String accountId, String accountHolderName, String accountHolderCPF, BigDecimal value) {
    this.accountId = accountId;
    this.accountHolderName = accountHolderName;
    this.accountHolderCPF = accountHolderCPF;
    this.value = value;
  }

  public String getAccountId() {
    return accountId;
  }

  public String getAccountHolderName() {
    return accountHolderName;
  }

  public String getAccountHolderCPF() {
    return accountHolderCPF;
  }

  public BigDecimal getValue() {
    return value;
  }

  protected void incrementValue(BigDecimal incrementAmount) {
    AccountValidator.validateAmount(incrementAmount, InvalidIncrementAmountException::new);
    value = incrementAmount.add(value);
  }

  protected void decrementValue(BigDecimal decrementAmount) {
    AccountValidator.validateAmount(decrementAmount, InvalidDecrementAmountException::new);
    BigDecimal decrementResultValue = value.subtract(decrementAmount);
    AccountValidator.validateDecrement(decrementResultValue, InvalidDecrementAmountException::new);
    value = decrementResultValue;
  } 

}
