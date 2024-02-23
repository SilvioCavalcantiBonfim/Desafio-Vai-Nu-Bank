package view.menu.action;

import controller.Message;
import domain.account.Account;
import repository.AccountRepository;
import view.menu.Menu;

public final class CreateAccountAction extends Action{

  private final String REGEX_VALIDATE_CPF = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$";
  private final String REGEX_VALIDATE_FULLNAME = "^[a-zA-Z]+(\s[a-zA-Z]+)+$";

  private final AccountRepository accountRepository;

  public CreateAccountAction() {
    super();
    accountRepository = AccountRepository.getInstance();
  }

  public void execute() {

    String fullName = getData(REGEX_VALIDATE_FULLNAME, Message.REQUEST_FULL_NAME, Message.ILLEGAL_FULL_NAME);

    String cpf = getData(REGEX_VALIDATE_CPF, Message.REQUEST_VALID_CPF, Message.INVALID_CPF_FORMAT);
    
    Menu createAccountMenu = new Menu(getOutputController(), false);
    createAccountMenu.addOption(1, Message.SAVINGS_ACCOUNT, savingsAccountCreate(fullName, cpf));
    // createAccountMenu.addOption(2, Message.CURRENTACCOUNT);
    createAccountMenu.addOption(0, Message.BACK);
    createAccountMenu.execute();
  }

  private Runnable savingsAccountCreate(final String fullname, final String cpf) {
    return () -> {
      Account newAccount = accountRepository.createSavingsAccount(fullname, cpf);
      getOutputController().print(String.format(Message.ACCOUNT_CREATED_SUCCESSFULLY, newAccount.getAccountId(),
          newAccount.getAccountHolderName(), newAccount.getAccountHolderCPF(), newAccount.getValue().doubleValue()));
    };
  }
}
