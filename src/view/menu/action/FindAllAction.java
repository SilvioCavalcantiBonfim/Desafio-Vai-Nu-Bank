package view.menu.action;

import controller.Message;
import repository.AccountRepository;

public final class FindAllAction extends Action {

  private final AccountRepository accountRepository;

  public FindAllAction() {
    super();
    accountRepository = AccountRepository.getInstance();
  }

  public void execute() {
    getOutputController().print(Message.DIVISION);
    getOutputController().print(Message.TABLE_TITLE);
    accountRepository.findAll().stream().forEach(account -> {
      getOutputController()
          .print(String.format(Message.LEFT_ALIGN_FORMAT, account.getAccountId(), account.getAccountHolderName()));
    });
    getOutputController().print(Message.DIVISION);
  }
}
