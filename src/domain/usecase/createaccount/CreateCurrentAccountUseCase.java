package domain.usecase.createaccount;

import domain.entity.account.Account;
import domain.service.AccountService;
import domain.usecase.Message;
import domain.usecase.UseCase;

class CreateCurrentAccountUseCase extends UseCase {

  private final String fullname;
  private final String cpf;
  private final AccountService accountService;

  public CreateCurrentAccountUseCase(String fullname, String cpf) {
    this.fullname = fullname;
    this.cpf = cpf;
    accountService = AccountService.getInstance();
  }

  @Override
  public void execute() {
    Account newAccount = accountService.createCurrentAccount(fullname, cpf);
    outputController.print(String.format(Message.ACCOUNT_CREATED_SUCCESSFULLY, newAccount.getAccountId(),
          newAccount.getAccountHolderName(), newAccount.getAccountHolderCPF(), newAccount.getValue().doubleValue()));
    outputController.print("<WHITE-BOLD>Limite de credito</WHITE-BOLD>: <GREEN-BOLD>VnW¢</GREEN-BOLD> <WHITE-BOLD>1000.00</WHITE-BOLD>\n");
  }

}
