package repository.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import domain.account.Account;
import domain.account.savingsaccount.SavingsAccount;
import repository.AccountRepository;

public class AccountRepositoryImpl implements AccountRepository {

  private static AccountRepository instance = null;

  private Map<String, Account> allAccount = new HashMap<>();

  private AccountRepositoryImpl() {
  }

  public static AccountRepository getInstance() {
    if (Objects.isNull(instance)) {
      instance = new AccountRepositoryImpl();
    }
    return instance;
  }

  @Override
  public Account createSavingsAccount(String accountHolderName, String accountHolderCPF) {
    Random rng = new Random();

    String accountId = IntStream.range(0, 10).mapToObj(d -> Integer.toString(rng.nextInt(10)))
        .collect(Collectors.joining(""));

    Account newAccount = new SavingsAccount(accountId, accountHolderName, accountHolderCPF,
        BigDecimal.valueOf(10));

    allAccount.put(accountId, newAccount);

    return newAccount;
  }

  @Override
  public Optional<Account> find(String accountId) {
    return Optional.ofNullable(allAccount.get(accountId));
  }

}
