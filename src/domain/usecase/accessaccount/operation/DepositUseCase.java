package domain.usecase.accessaccount.operation;

import java.math.BigDecimal;

import domain.service.AccountService;
import domain.usecase.Message;
import domain.usecase.UseCase;
import exception.InvalidIncrementAmountException;

public class DepositUseCase extends UseCase {

  private final String accountId;
  private final AccountService accountService;

  public DepositUseCase(String accountId) {
    this.accountId = accountId;
    this.accountService = AccountService.getInstance();
  }

  @Override
  public void execute() {
    outputController.print(Message.REQUEST_DEPOSIT_VALUE);
    try {
      Double value = inputController.nextDouble();
      accountService.deposit(accountId, BigDecimal.valueOf(value));
      outputController.print(Message.DEPOSIT_SUCCESS);
    } catch (NumberFormatException e) {
      outputController.print(Message.ILLEGAL_DEPOSIT_VALUE);
    } catch (InvalidIncrementAmountException e){
      outputController.print(Message.ILLEGAL_DEPOSIT_VALUE);
    }

  }
  
}
