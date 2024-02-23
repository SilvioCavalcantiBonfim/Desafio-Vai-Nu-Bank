package view.menu.action;

import java.math.BigDecimal;

import controller.Message;
import domain.account.Account;
import exception.AccountNotFoundException;
import exception.InvalidDecrementAmountException;
import exception.InvalidIncrementAmountException;
import repository.AccountRepository;
import view.menu.Menu;

public final class AccountPresentAction extends Action {

  private final String REGEX_VALIDATE_ACCOUNTID = "^\\d{10}$";
  private final Account account;
  private final Menu accountPresentMenu = new Menu(getOutputController());
  private final AccountRepository accountRepository;

  public AccountPresentAction(Account account) {
    super();
    this.account = account;
    this.accountRepository = AccountRepository.getInstance();
    accountPresentMenu.addOption(0, Message.BACK, () -> accountPresentMenu.stopMenu());
    accountPresentMenu.addOption(1, Message.BALANCE, this::balanceAction);
    accountPresentMenu.addOption(2, Message.DEPOSIT, this::depositAction);
    accountPresentMenu.addOption(3, Message.WITHDRAW, this::withdrawAction);
    accountPresentMenu.addOption(4, Message.TRANSFER, this::transferAction);
    accountPresentMenu.addOption(5, Message.EXCLUDE_ACCOUNT, this::excludeAccountAction);
  }

  @Override
  public void execute() {
    accountPresentMenu.execute();
  }

  private void transferAction() {
    String accountId = getData(REGEX_VALIDATE_ACCOUNTID, Message.REQUEST_ACCOUNTID,
        Message.ILLEGAL_ACCOUNT_ID_FORMAT);
    Double value = getInputController().readDouble(
        () -> getOutputController().print(Message.REQUEST_TRANSFER_VALUE),
        (v) -> true,
        () -> getOutputController().print(Message.ILLEGAL_TRANSFER_VALUE_FORMAT));
    try {
      account.transfer(accountId, BigDecimal.valueOf(value));
    } catch (InvalidIncrementAmountException | InvalidDecrementAmountException e) {
      getOutputController().print(Message.ILLEGAL_TRANSFER_VALUE);
    } catch (AccountNotFoundException e) {
      getOutputController().print(Message.ACCOUNT_NOT_FOUND);
    }
  }

  private void excludeAccountAction() {
    accountRepository.delete(account.getAccountId());
    accountPresentMenu.stopMenu();
  }

  private void withdrawAction() {
    Double value = getInputController().readDouble(
        () -> getOutputController().print(Message.REQUEST_WITHDRAW_VALUE),
        (v) -> true,
        () -> getOutputController().print(Message.ILLEGAL_WITHDRAW_VALUE_FORMAT));
    try {
      account.withdraw(BigDecimal.valueOf(value));
    } catch (Exception e) {
      getOutputController().print(Message.ILLEGAL_WITHDRAW_VALUE);
    }
  }

  private void balanceAction() {
    getOutputController().print(String.format(Message.ACCOUNT_BALANCE_FORMAT, account.getValue()));
  }

  private void depositAction() {
    Double value = getInputController().readDouble(
        () -> getOutputController().print(Message.REQUEST_DEPOSIT_VALUE),
        (v) -> true,
        () -> getOutputController().print(Message.ILLEGAL_DEPOSIT_VALUE_FORMAT));
    try {
      account.deposit(BigDecimal.valueOf(value));
    } catch (Exception e) {
      getOutputController().print(Message.ILLEGAL_DEPOSIT_VALUE);
    }
  }

}
