package domain.usecase;

import application.view.menu.Menu;
import domain.usecase.accessaccount.AccountAccessAuthorizationUseCase;
import domain.usecase.createaccount.CreateAccountUseCase;

public final class MainMenuUseCase extends UseCase {

  private final Menu<Integer> mainMenu;

  public MainMenuUseCase() {

    UseCase findAll = new FindAllUseCase();
    UseCase accessAccount = new AccountAccessAuthorizationUseCase();
    UseCase createAccount = new CreateAccountUseCase();
    UseCase exit = new ExitUseCase();

    mainMenu = Menu.create(() -> outputController.print(Message.INVALID_OPTION));

    mainMenu.addOptionWithAction(1, Message.ALL_ACCOUNT, findAll::execute);
    mainMenu.addOptionWithAction(2, Message.ACCESS_ACCOUNT, accessAccount::execute);
    mainMenu.addOptionWithAction(3, Message.CREATE_ACCOUNT, createAccount::execute);
    mainMenu.addOptionWithAction(0, Message.OPTION_EXIT, exit::execute);

  }

  @Override
  public void execute() {
    outputController.print(Message.WELCOME);
    while (true) {
      try {
        outputController.print(mainMenu.getMenuString());
        Integer optionSelected = inputController.nextInteger();
        mainMenu.executeAction(optionSelected);
      } catch (NumberFormatException e) {
        outputController.print(Message.INVALID_OPTION);
      }
    }
  }

}
