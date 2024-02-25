package domain.usecase;

import domain.service.AccountService;

public final class FindAllUseCase extends UseCase {

  private final AccountService accountService;

  public FindAllUseCase() {
    accountService = AccountService.getInstance();
  }

  public void execute() {
    outputController.print(Message.DIVISION);
    outputController.print(Message.TABLE_TITLE);
    accountService.findAll().stream().forEach(account -> {
      outputController
          .print(String.format(Message.LEFT_ALIGN_FORMAT, account.getAccountId(), account.getAccountHolderName()));
    });
    outputController.print(Message.DIVISION);
  }
}
