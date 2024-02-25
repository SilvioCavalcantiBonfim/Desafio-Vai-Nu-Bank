package domain.usecase.createaccount;

import domain.usecase.Message;
import domain.usecase.UseCase;

class CancelCreateAccountUseCase extends UseCase {

  @Override
  public void execute() {
    outputController.print(Message.CANCEL_CREATE_ACCOUNT_SUCCESS_MESSAGE);
  }

}
