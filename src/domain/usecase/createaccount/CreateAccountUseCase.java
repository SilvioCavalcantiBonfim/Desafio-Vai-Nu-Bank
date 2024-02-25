package domain.usecase.createaccount;

import application.view.RegexPatterns;
import application.view.menu.Menu;
import domain.usecase.Message;
import domain.usecase.UseCase;

public class CreateAccountUseCase extends UseCase {

  private final Menu<Integer> createAccountMenu;

  public CreateAccountUseCase() {
    createAccountMenu = Menu.create(Message.CHOOSE_ACCOUNT_TYPE_PROMPT);
  }

  @Override
  public void execute() {
    String fullName = getData(RegexPatterns.FULLNAME_REGEX, Message.REQUEST_FULL_NAME, Message.ILLEGAL_FULL_NAME);
    String cpf = getData(RegexPatterns.CPF_REGEX, Message.REQUEST_VALID_CPF, Message.INVALID_CPF_FORMAT);

    UseCase createSavingsAccountUseCase = new CreateSavingsAccountUseCase(fullName, cpf);
    UseCase cancelCreateAccountUseCase = new CancelCreateAccountUseCase();

    createAccountMenu.addOptionWithAction(1, Message.SAVINGS_ACCOUNT,createSavingsAccountUseCase::execute);
    createAccountMenu.addOptionWithAction(0, Message.CANCEL_CREATE_ACCOUNT_OPTION, cancelCreateAccountUseCase::execute);

    Integer optionSelected;

    do {
      outputController.print(createAccountMenu.getMenuString());
      optionSelected = inputController.nextInteger();
    } while (!createAccountMenu.executeAction(optionSelected));
  }

}
