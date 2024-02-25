package domain.usecase.accessaccount.commonoperations;

import java.math.BigDecimal;

import application.view.RegexPatterns;
import domain.entity.account.Account;
import domain.service.AccountService;
import domain.usecase.Message;
import domain.usecase.UseCase;
import exception.AccountNotFoundException;
import exception.InvalidDecrementAmountException;
import exception.InvalidIncrementAmountException;

public class TransferUseCase extends UseCase {

  private final Account account;
  private final AccountService accountService;

  public TransferUseCase(Account account) {
    this.account = account;
    this.accountService = AccountService.getInstance();
  }

  @Override
  public void execute() {
    String accountId = getData(RegexPatterns.ACCOUNT_ID_REGEX, Message.REQUEST_ACCOUNTID, Message.ILLEGAL_ACCOUNT_ID_FORMAT);
    try {
      outputController.print(Message.REQUEST_TRANSFER_VALUE);
      Double value = inputController.nextDouble();
      accountService.transfer(account.getAccountId(), accountId, BigDecimal.valueOf(value));
      outputController.print(Message.TRANSFER_SUCCESS);
    } catch (NumberFormatException e) {
      outputController.print(Message.ILLEGAL_TRANSFER_VALUE);
    } catch (InvalidIncrementAmountException | InvalidDecrementAmountException e) {
      outputController.print(Message.ILLEGAL_TRANSFER_VALUE);
    } catch (AccountNotFoundException e) {
      outputController.print(Message.ACCOUNT_NOT_FOUND);
    }

  }

}
