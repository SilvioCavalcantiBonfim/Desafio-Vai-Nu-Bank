package domain.usecase;

import domain.entity.account.Account;
import domain.service.AccountService;

public final class FindAllUseCase extends UseCase {

  private final AccountService accountService;

  public FindAllUseCase() {
    accountService = AccountService.getInstance();
  }

  public void execute() {
    outputController.print(Message.DIVISION);
    outputController.print(Message.TABLE_TITLE);
    accountService.findAll().stream().forEach(this::printAccount);
    outputController.print(Message.DIVISION);
  }

  private void printAccount(Account account) {
    outputController.print(Message.DIVISION);
    outputController
        .printf(Message.LEFT_ALIGN_FORMAT, account.getAccountId(), account.getAccountHolderName());
    accountService.findAllDependents(account.getAccountId()).stream().forEach(person -> {
      outputController
        .printf(Message.LEFT_ALIGN_FORMAT, "", person.name());
    });
  }
}
