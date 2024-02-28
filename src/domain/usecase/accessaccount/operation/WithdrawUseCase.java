package domain.usecase.accessaccount.operation;

import java.math.BigDecimal;

import domain.service.AccountService;
import domain.usecase.Message;
import domain.usecase.UseCase;
import exception.InvalidDecrementAmountException;

public class WithdrawUseCase extends UseCase {

  private final String accountId;
  private final AccountService accountService;

  public WithdrawUseCase(String accountId) {
    this.accountId = accountId;
    this.accountService = AccountService.getInstance();
  }

  @Override
  public void execute() {
    outputController.print(Message.REQUEST_WITHDRAW_VALUE);
    try {
      Double value = inputController.nextDouble();
      accountService.withdraw(accountId, BigDecimal.valueOf(value));
      outputController.print(Message.WITHDRAW_SUCCESS);
    } catch (NumberFormatException e) {
      outputController.print(Message.ILLEGAL_WITHDRAW_VALUE);
    } catch (InvalidDecrementAmountException e){
      outputController.print(Message.ILLEGAL_WITHDRAW_VALUE);
    }

  }
  
}
