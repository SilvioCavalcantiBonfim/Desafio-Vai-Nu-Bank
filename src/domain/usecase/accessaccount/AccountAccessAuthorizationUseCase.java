package domain.usecase.accessaccount;

import application.view.RegexPatterns;
import domain.entity.account.Account;
import domain.service.AccountService;
import domain.usecase.Message;
import domain.usecase.UseCase;

public class AccountAccessAuthorizationUseCase extends UseCase {

  private final AccountService accountService;

  public AccountAccessAuthorizationUseCase(){
    accountService = AccountService.getInstance();
  }

  @Override
  public void execute() {
    String accountId = getData(RegexPatterns.ACCOUNT_ID_REGEX, Message.REQUEST_ACCOUNTID, Message.ILLEGAL_ACCOUNT_ID_FORMAT);
    String cpf = getData(RegexPatterns.CPF_REGEX, Message.REQUEST_VALID_CPF, Message.INVALID_CPF_FORMAT);

    UseCase accountNotFoundUseCase = new AccountNotFoundUseCase();

    accountService.findById(accountId).filter(e -> e.getAccountHolderCPF().equals(cpf)).ifPresentOrElse(this::accountPresent, accountNotFoundUseCase::execute);
  }
  
  private void accountPresent(Account account){
    UseCase bankingOperationsSavingsAccountMenuUseCase = new BankingOperationsAccountMenuUseCase(account.getAccountId());
    bankingOperationsSavingsAccountMenuUseCase.execute();
  }
}
