package view.menu;

import java.util.regex.Pattern;

import controller.InputController;
import controller.OutputController;
import controller.impl.OutputControllerImpl;
import domain.account.Account;
import repository.AccountRepository;
import view.output.Message;

public class MainMenuAction {

  private final String REGEX_VALIDATE_CPF = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$";
  private final String REGEX_VALIDATE_FULLNAME = "^[a-zA-Z]+(\s[a-zA-Z]+)+$";

  private final OutputController output;
  private final AccountRepository accountRepository;
  private final InputController inputController;

  public MainMenuAction() {
    output = OutputControllerImpl.getInstance();
    accountRepository = AccountRepository.getInstance();
    inputController = InputController.getInstance();

  }

  public void exitApplication() {
    try {
      output.print(Message.EXIT_MESSAGE);
      Thread.sleep(3000);
      System.exit(0);
    } catch (Exception e) {
    }
  }

  public void findAllAccount() {
    output.print(Message.DIVISION);
    output.print(Message.TABLE_TITLE);
    accountRepository.findAll().stream().forEach(account -> {
      output.print(String.format(Message.LEFT_ALIGN_FORMAT, account.getAccountId(), account.getAccountHolderName()));
    });
    output.print(Message.DIVISION);
  }

  public void accessAccount() {
  }

  public void createAccount() {

    String fullName = getData(REGEX_VALIDATE_FULLNAME, Message.REQUEST_FULL_NAME_MESSAGE, Message.INVALID_NAME_MESSAGE);

    String cpf = getData(REGEX_VALIDATE_CPF, Message.REQUEST_VALID_CPF_MESSAGE, Message.INVALID_CPF_FORMAT_MESSAGE);

    Menu createAccountMenu = new Menu(output, false);
    createAccountMenu.addOption(1, Message.SAVINGSACCOUNT, savingsAccountCreate(fullName, cpf));
    // createAccountMenu.addOption(2, Message.CURRENTACCOUNT);
    createAccountMenu.addOption(0, Message.BACK);
    createAccountMenu.execute();
  }

  private String getData(final String regex, final String startMsg, final String invalidMsg) {
    output.print(startMsg);
    String data = inputController.read(Pattern.compile(regex).asMatchPredicate(),
        (txt) -> output.print(invalidMsg));
    return data;
  }

  private Runnable savingsAccountCreate(final String fullname, final String cpf) {
    return () -> {
      Account newAccount = accountRepository.createSavingsAccount(fullname, cpf);
      output.print(String.format(Message.ACCOUNT_CREATED_SUCCESSFULLY, newAccount.getAccountId(),
          newAccount.getAccountHolderName(), newAccount.getAccountHolderCPF(), newAccount.getValue().doubleValue()));
    };
  }
}
