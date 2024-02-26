package domain.usecase.accessaccount.commonoperations.dependentsoperation;

import domain.service.AccountService;
import domain.usecase.Message;
import domain.usecase.UseCase;

public class ViewDependentUseCase extends UseCase {

  private final String accountId;
  private final AccountService accountService;

  public ViewDependentUseCase(String accountId) {
    this.accountId = accountId;
    this.accountService = AccountService.getInstance();
  }

  @Override
  public void execute() {
    outputController.print(Message.DIVISION);
    outputController.print(Message.TABLE_TITLE_DEPENDENT);
    accountService.findAllDependents(accountId).forEach(dependent -> outputController.printf(Message.LEFT_ALIGN_FORMAT+Message.DIVISION, dependent.name(), dependent.cpf()));
  }

}
