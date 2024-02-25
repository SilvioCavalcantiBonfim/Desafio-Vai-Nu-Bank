package domain.repository;

import java.util.List;
import java.util.Optional;

import domain.entity.account.Account;

public interface AccountRepository {

  Optional<Account> find(String accountId);

  List<Account> findAll();

  void delete(String accountId);

  void save(Account account);

  static AccountRepository getInstance() {
    return AccountRepositoryImpl.getInstance();
  }

}