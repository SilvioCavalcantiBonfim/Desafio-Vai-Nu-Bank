package domain.usecase.accessaccount.commonoperations;

import java.math.BigDecimal;

import domain.entity.account.Account;
import domain.usecase.Message;
import domain.usecase.UseCase;
import exception.InvalidDecrementAmountException;

public class WithdrawUseCase extends UseCase {

  private final Account account;

  public WithdrawUseCase(Account account) {
    this.account = account;
  }

  @Override
  public void execute() {
    outputController.print(Message.REQUEST_WITHDRAW_VALUE);
    try {
      Double value = inputController.nextDouble();
      account.withdraw(BigDecimal.valueOf(value));
      outputController.print(Message.WITHDRAW_SUCCESS);
    } catch (NumberFormatException e) {
      outputController.print(Message.ILLEGAL_WITHDRAW_VALUE);
    } catch (InvalidDecrementAmountException e){
      outputController.print(Message.ILLEGAL_WITHDRAW_VALUE);
    }

  }
  
}
