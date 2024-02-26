package domain.repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import domain.entity.account.Account;

class AccountRepositoryImpl implements AccountRepository {

  private static AccountRepository instance = null;

  private Map<String, Account> allAccount = new ConcurrentHashMap<>();

  private AccountRepositoryImpl() { }

  public static AccountRepository getInstance() {
    if (Objects.isNull(instance)) {
      instance = new AccountRepositoryImpl();
    }
    return instance;
  }

  @Override
  public Optional<Account> find(String accountId) {
    return Optional.ofNullable(allAccount.get(accountId));
  }

  @Override
  public List<Account> findAll() {
    return allAccount.values().stream().toList();
  }

  @Override
  public void delete(String accountId) {
    allAccount.remove(accountId);
  }

  @Override
  public void save(Account account) {
    allAccount.put(account.getAccountId(), account);
  }

}
