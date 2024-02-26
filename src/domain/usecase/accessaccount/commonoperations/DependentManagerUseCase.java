package domain.usecase.accessaccount.commonoperations;

import application.view.menu.Menu;
import domain.entity.account.Account;
import domain.usecase.Message;
import domain.usecase.UseCase;
import domain.usecase.accessaccount.commonoperations.dependentsoperation.AddDependentUseCase;
import domain.usecase.accessaccount.commonoperations.dependentsoperation.RemoveDependentUseCase;
import domain.usecase.accessaccount.commonoperations.dependentsoperation.ViewDependentUseCase;

public class DependentManagerUseCase extends UseCase{

  private final Menu<Integer> menu;
  private boolean repeatMenu = true;

  public DependentManagerUseCase(Account account) {

    menu = Menu.create();

    UseCase view = new ViewDependentUseCase(account.getAccountId());
    UseCase add = new AddDependentUseCase(account.getAccountId());
    UseCase remove = new RemoveDependentUseCase(account.getAccountId());


    menu.addOptionWithAction(1, Message.ALL_DEPENDENT, view::execute);
    menu.addOptionWithAction(2, Message.DEPENDENT_ADD, add::execute);
    menu.addOptionWithAction(3, Message.DEPENDENT_REMOVE, remove::execute);
    menu.addOptionWithAction(0, Message.BACK, this::stopMenu);
  }
  
  @Override
  public void execute() {
    while (repeatMenu) {
      outputController.print(menu.getMenuString());
      Integer optionSelected = inputController.nextInteger();
      menu.executeAction(optionSelected);
    }
  }

  private void stopMenu(){
    repeatMenu = false;
  }
  
}
