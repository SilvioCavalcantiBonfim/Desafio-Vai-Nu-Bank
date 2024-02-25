package domain.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import domain.entity.account.Account;

public interface AccountService {
  Account createSavingsAccount(String accountHolderName, String accountHolderCPF);

  void transfer(String sendAccountId, String receiveAccountId, BigDecimal value);

  Optional<Account> findById(String accountId);

  List<Account> findAll();
  
  void delete(String accountId);

  public static AccountService getInstance() {
    return AccountServiceImpl.getInstance();
  }

}
