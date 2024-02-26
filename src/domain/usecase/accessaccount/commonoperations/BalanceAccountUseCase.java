package domain.usecase.accessaccount.commonoperations;

import domain.entity.account.Account;
import domain.usecase.Message;
import domain.usecase.UseCase;

public class BalanceAccountUseCase extends UseCase{

  private final Account account;

  public BalanceAccountUseCase(Account account) {
    this.account = account;
  }
  
  @Override
  public void execute() {
    String accountBalanceFormat = account.getValue().signum() == -1? Message.ACCOUNT_NEGATIVE_BALANCE_FORMAT : Message.ACCOUNT_BALANCE_FORMAT;
    outputController.print(String.format(accountBalanceFormat, account.getValue()));
  }
  
}
