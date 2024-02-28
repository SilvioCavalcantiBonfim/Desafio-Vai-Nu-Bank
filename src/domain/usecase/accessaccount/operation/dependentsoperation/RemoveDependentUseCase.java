package domain.usecase.accessaccount.operation.dependentsoperation;

import java.util.List;

import application.view.menu.Menu;
import domain.entity.account.Person;
import domain.service.AccountService;
import domain.usecase.Message;
import domain.usecase.UseCase;

public class RemoveDependentUseCase extends UseCase {

  private final String accountId;
  private final AccountService accountService;
  private final Menu<Integer> menu;

  public RemoveDependentUseCase(String accountId) {
    this.accountId = accountId;
    this.accountService = AccountService.getInstance();
    menu = Menu.create();
  }

  private void renderOptionsMenu(List<Person> dependents) {

    for (int i = 0; i < dependents.size(); i++) {
      Person dependent = dependents.get(i);
      menu.addOptionWithAction(i + 1, String.format(Message.DEPENDENT_REMOVE_OPTION, dependent.name()), removeCurrentDependent(dependent.cpf()));
    }
  }

  private Runnable removeCurrentDependent(String cpf){
    return () -> accountService.removeDependent(accountId, cpf);
  }

  @Override
  public void execute() {
    List<Person> dependents = accountService.findAllDependents(accountId);
    if (dependents.isEmpty()) {
      outputController.print(Message.DEPENDENT_NOT_FOUNT);
    }else{
      renderOptionsMenu(dependents);
      outputController.print(menu.getMenuString());
      Integer optionSelected = inputController.nextInteger();
      menu.executeAction(optionSelected);
    }
  }

}
