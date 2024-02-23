package view.menu.action;

import controller.Message;
import domain.account.Account;
import repository.AccountRepository;

public final class AccessAccountAction extends Action{

  private final String REGEX_VALIDATE_ACCOUNTID = "^\\d{10}$";
  private final String REGEX_VALIDATE_CPF = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$";

  private final AccountRepository accountRepository;

  public AccessAccountAction() {
    super();
    accountRepository = AccountRepository.getInstance();
  }

  public void execute() {
    
    String accountId = getData(REGEX_VALIDATE_ACCOUNTID, Message.REQUEST_ACCOUNTID, Message.ILLEGAL_ACCOUNT_ID_FORMAT);
    String cpf = getData(REGEX_VALIDATE_CPF, Message.REQUEST_VALID_CPF, Message.INVALID_CPF_FORMAT);
    
    accountRepository.find(accountId).filter(e -> e.getAccountHolderCPF().equals(cpf)).ifPresentOrElse(this::accountPresent, this::accountNotFound);

  }
  
  private void accountPresent(Account account){
    AccountPresentAction accountPresentAction = new AccountPresentAction(account);
    accountPresentAction.execute();
  }

  private void accountNotFound(){
    getOutputController().print(Message.ACCOUNT_NOT_FOUND);
  }
}
