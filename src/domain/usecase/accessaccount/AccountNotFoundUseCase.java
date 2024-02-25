package domain.usecase.accessaccount;

import domain.usecase.Message;
import domain.usecase.UseCase;

public class AccountNotFoundUseCase extends UseCase {

  @Override
  public void execute() {
    outputController.print(Message.ACCOUNT_NOT_FOUND);
  }
  
}
