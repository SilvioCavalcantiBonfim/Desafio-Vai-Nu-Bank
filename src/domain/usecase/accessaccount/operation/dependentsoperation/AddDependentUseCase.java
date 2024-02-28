package domain.usecase.accessaccount.operation.dependentsoperation;

import application.view.RegexPatterns;
import domain.service.AccountService;
import domain.usecase.Message;
import domain.usecase.UseCase;

public class AddDependentUseCase extends UseCase {

  private final String accountId;
  private final AccountService accountService;

  public AddDependentUseCase(String accountId) {
    this.accountId = accountId;
    this.accountService = AccountService.getInstance();

  }

  @Override
  public void execute() {
    String fullName = getData(RegexPatterns.FULLNAME_REGEX, Message.REQUEST_DEPENDENT_FULL_NAME, Message.ILLEGAL_FULL_NAME);
    String cpf = getData(RegexPatterns.CPF_REGEX, Message.REQUEST_VALID_CPF, Message.INVALID_CPF_FORMAT);
    try {
      accountService.createDependent(accountId, fullName, cpf);
      outputController.printf(Message.DEPENDENT_ADD_SUCCESS, fullName);      
    } catch (Exception e) {
      outputController.printf(Message.DEPENDENT_ALREADY, cpf);      
    }

  }

}
