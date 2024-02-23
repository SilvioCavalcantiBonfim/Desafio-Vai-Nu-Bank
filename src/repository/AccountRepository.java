package repository;

import java.util.List;
import java.util.Optional;

import domain.account.Account;
import repository.impl.AccountRepositoryImpl;

public interface AccountRepository {

  Account createSavingsAccount(String accountHolderName, String accountHolderCPF);

  Optional<Account> find(String accountId);

  static AccountRepository getInstance() {
    return AccountRepositoryImpl.getInstance();
  }

  List<Account> findAll();

  void delete(String accountId);
}