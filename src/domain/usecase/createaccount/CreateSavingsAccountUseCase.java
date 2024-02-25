package domain.usecase.createaccount;

import domain.entity.account.Account;
import domain.service.AccountService;
import domain.usecase.Message;
import domain.usecase.UseCase;

class CreateSavingsAccountUseCase extends UseCase {

  private final String fullname;
  private final String cpf;
  private final AccountService accountService;

  public CreateSavingsAccountUseCase(String fullname, String cpf) {
    this.fullname = fullname;
    this.cpf = cpf;
    accountService = AccountService.getInstance();
  }

  @Override
  public void execute() {
    Account newAccount = accountService.createSavingsAccount(fullname, cpf);
    outputController.print(String.format(Message.ACCOUNT_CREATED_SUCCESSFULLY, newAccount.getAccountId(),
          newAccount.getAccountHolderName(), newAccount.getAccountHolderCPF(), newAccount.getValue().doubleValue()));
  }

}
