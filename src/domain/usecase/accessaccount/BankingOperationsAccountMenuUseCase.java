package domain.usecase.accessaccount;

import application.view.menu.Menu;
import domain.usecase.Message;
import domain.usecase.UseCase;
import domain.usecase.accessaccount.operation.BalanceAccountUseCase;
import domain.usecase.accessaccount.operation.DeleteAccountUseCase;
import domain.usecase.accessaccount.operation.DependentManagerUseCase;
import domain.usecase.accessaccount.operation.DepositUseCase;
import domain.usecase.accessaccount.operation.TransferUseCase;
import domain.usecase.accessaccount.operation.WithdrawUseCase;

public class BankingOperationsAccountMenuUseCase extends UseCase {

  private final Menu<Integer> menu = Menu.create();
  private boolean loginState = true;

  public BankingOperationsAccountMenuUseCase(String accountId) {

    UseCase balance = new BalanceAccountUseCase(accountId);
    UseCase deposit = new DepositUseCase(accountId);
    UseCase withdraw = new WithdrawUseCase(accountId);
    UseCase transfer = new TransferUseCase(accountId);
    UseCase dependentManager = new DependentManagerUseCase(accountId);


    
    menu.addOptionWithAction(1, Message.BALANCE, balance::execute);
    menu.addOptionWithAction(2, Message.DEPOSIT, deposit::execute);
    menu.addOptionWithAction(3, Message.WITHDRAW, withdraw::execute);
    menu.addOptionWithAction(4, Message.TRANSFER, transfer::execute);
    menu.addOptionWithAction(5, Message.DEPENDENT_MANAGER, dependentManager::execute);
    menu.addOptionWithAction(6, Message.DELETE_ACCOUNT, this.delete(accountId));
    menu.addOptionWithAction(0, Message.BACK, this::stopMenu);
  }

  private void stopMenu(){
    loginState = false;
  }

  private Runnable delete(String accountId){
    return () -> {
      UseCase deleteAccount = new DeleteAccountUseCase(accountId);
      deleteAccount.execute();
      this.stopMenu();
    };
  }

  @Override
  public void execute() {
    while (loginState) {
      outputController.print(menu.getMenuString());
      Integer optionSelected = inputController.nextInteger();
      menu.executeAction(optionSelected);
    }
  }

}
