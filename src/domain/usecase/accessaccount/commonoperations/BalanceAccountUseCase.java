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
    outputController.print(String.format(Message.ACCOUNT_BALANCE_FORMAT, account.getValue()));
  }
  
}
