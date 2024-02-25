package domain.usecase.accessaccount.savingaccountoperations;

import application.view.menu.Menu;
import domain.entity.account.Account;
import domain.usecase.Message;
import domain.usecase.UseCase;
import domain.usecase.accessaccount.commonoperations.BalanceAccountUseCase;
import domain.usecase.accessaccount.commonoperations.DeleteAccountUseCase;
import domain.usecase.accessaccount.commonoperations.DepositUseCase;
import domain.usecase.accessaccount.commonoperations.TransferUseCase;
import domain.usecase.accessaccount.commonoperations.WithdrawUseCase;

public class BankingOperationsSavingsAccountMenuUseCase extends UseCase {

  private final Menu<Integer> menu = Menu.create();
  private boolean loginState = true;

  public BankingOperationsSavingsAccountMenuUseCase(Account account) {

    UseCase balance = new BalanceAccountUseCase(account);
    UseCase deposit = new DepositUseCase(account);
    UseCase withdraw = new WithdrawUseCase(account);
    UseCase transfer = new TransferUseCase(account);


    
    menu.addOptionWithAction(1, Message.BALANCE, balance::execute);
    menu.addOptionWithAction(2, Message.DEPOSIT, deposit::execute);
    menu.addOptionWithAction(3, Message.WITHDRAW, withdraw::execute);
    menu.addOptionWithAction(4, Message.TRANSFER, transfer::execute);
    menu.addOptionWithAction(5, Message.DELETE_ACCOUNT, this.delete(account.getAccountId()));
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
    outputController.print(Message.WELCOME);
    while (loginState) {
      outputController.print(menu.getMenuString());
      Integer optionSelected = inputController.nextInteger();
      menu.executeAction(optionSelected);
    }
  }

}
