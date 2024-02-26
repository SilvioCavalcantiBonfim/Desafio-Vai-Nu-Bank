package domain.entity.account.currentaccount;

import java.math.BigDecimal;

import domain.entity.account.Account;
import domain.entity.account.AccountValidator;
import domain.service.CurrentAccountProcessService;
import exception.InvalidDecrementAmountException;
import exception.InvalidIncrementAmountException;

public class CurrentAccount extends Account {

  private final BigDecimal OVERDRAFT_DAILY_RATE = BigDecimal.valueOf(1.0025);

  private BigDecimal overdraftBalance;
  private final CurrentAccountProcessService currentAccountProcessService;

  public CurrentAccount(String accountId, String accountHolderName, String accountHolderCPF,
      BigDecimal value) {
    super(accountId, accountHolderName, accountHolderCPF, value);
    overdraftBalance = BigDecimal.ZERO;
    currentAccountProcessService = CurrentAccountProcessService.getInstance();
  }

  @Override
  public void withdraw(BigDecimal value) {
    AccountValidator.validateAmount(value, InvalidIncrementAmountException::new);
    AccountValidator.validateDecrement(BigDecimal.valueOf(1000).subtract(overdraftBalance),
        InvalidDecrementAmountException::new);
    BigDecimal realWithdrawValue = getValue().subtract(value);
    switch (realWithdrawValue.signum()) {
      case -1:
        this.decrementValue(getValue());
        overdraftBalance = overdraftBalance.add(realWithdrawValue.abs());
        currentAccountProcessService.addAccountToNextProcess(getAccountId());
        break;
      case 0:
        this.decrementValue(getValue());
        break;
      case 1:
        this.decrementValue(value);
        break;
      default:
        break;
    }
  }

  @Override
  public void deposit(BigDecimal value) {
    AccountValidator.validateAmount(value, InvalidIncrementAmountException::new);

    BigDecimal realDepositValue = value.subtract(overdraftBalance);
    switch (realDepositValue.signum()) {
      case -1:
        overdraftBalance = realDepositValue;
        break;
      case 0:
        overdraftBalance = realDepositValue;
        currentAccountProcessService.removeAccountToNextProcess(getAccountId());
        break;
      case 1:
        overdraftBalance = BigDecimal.ZERO;
        currentAccountProcessService.removeAccountToNextProcess(getAccountId());
        this.incrementValue(realDepositValue);
        break;
      default:
        break;
    }
  }

  @Override
  public BigDecimal getValue() {
    return super.getValue().subtract(overdraftBalance);
  }

  public void processOverdraftBalance() {
    overdraftBalance = overdraftBalance.multiply(OVERDRAFT_DAILY_RATE);
  }

}
