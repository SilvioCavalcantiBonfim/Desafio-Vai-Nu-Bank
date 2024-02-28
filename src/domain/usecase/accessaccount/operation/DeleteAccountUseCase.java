package domain.usecase.accessaccount.operation;

import domain.service.AccountService;
import domain.usecase.UseCase;

public class DeleteAccountUseCase extends UseCase{

  private final AccountService accountService;
  private final String accountId;

  public DeleteAccountUseCase(String accountId) {
    this.accountId = accountId;
    accountService = AccountService.getInstance();
  }

  @Override
  public void execute() {
    accountService.delete(accountId);
  }
  
}
