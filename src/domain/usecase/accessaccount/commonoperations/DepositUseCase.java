package domain.usecase.accessaccount.commonoperations;

import java.math.BigDecimal;

import domain.entity.account.Account;
import domain.usecase.Message;
import domain.usecase.UseCase;
import exception.InvalidIncrementAmountException;

public class DepositUseCase extends UseCase {

  private final Account account;

  public DepositUseCase(Account account) {
    this.account = account;
  }

  @Override
  public void execute() {
    outputController.print(Message.REQUEST_DEPOSIT_VALUE);
    try {
      Double value = inputController.nextDouble();
      account.deposit(BigDecimal.valueOf(value));
      outputController.print(Message.DEPOSIT_SUCCESS);
    } catch (NumberFormatException e) {
      outputController.print(Message.ILLEGAL_DEPOSIT_VALUE);
    } catch (InvalidIncrementAmountException e){
      outputController.print(Message.ILLEGAL_DEPOSIT_VALUE);
    }

  }
  
}
