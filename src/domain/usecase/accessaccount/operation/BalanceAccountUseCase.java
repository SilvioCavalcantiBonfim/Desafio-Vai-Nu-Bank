package domain.usecase.accessaccount.operation;

import java.math.BigDecimal;

import domain.service.AccountService;
import domain.usecase.Message;
import domain.usecase.UseCase;

public class BalanceAccountUseCase extends UseCase{

  private final String accountId;
  private final AccountService accountService;

  public BalanceAccountUseCase(String accountId) {
    this.accountId = accountId;
    this.accountService = AccountService.getInstance();
  }
  
  @Override
  public void execute() {
    BigDecimal balance = accountService.getBalanceAccount(accountId);
    String accountBalanceFormat = balance.signum() == -1? Message.ACCOUNT_NEGATIVE_BALANCE_FORMAT : Message.ACCOUNT_BALANCE_FORMAT;
    outputController.print(String.format(accountBalanceFormat, balance));
  }
  
}
