package domain.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import domain.entity.account.Account;
import domain.entity.account.savingsaccount.SavingsAccount;
import domain.repository.AccountRepository;
import exception.AccountNotFoundException;

class AccountServiceImpl implements AccountService{

  private static AccountService instance = null;

  private final AccountRepository accountRepository;

  private final Random rng;

  private AccountServiceImpl() {
    this.accountRepository = AccountRepository.getInstance();
    this.rng = new Random();
  }

  @Override
  public Account createSavingsAccount(String accountHolderName, String accountHolderCPF) {
    
    String accountId = IntStream.range(0, 10).mapToObj(d -> Integer.toString(rng.nextInt(10)))
        .collect(Collectors.joining(""));

    Account newAccount = new SavingsAccount(accountId, accountHolderName, accountHolderCPF,
        BigDecimal.valueOf(10));

    accountRepository.save(newAccount);
    
    return newAccount;
  }
  
  @Override
  public Optional<Account> findById(String accountId) {
    return accountRepository.find(accountId);
  }

  @Override
  public void transfer(String sendAccountId, String receiveAccountId, BigDecimal value) {
    Account sendAccount = accountRepository.find(sendAccountId).orElseThrow(AccountNotFoundException::new);
    Account receiveAccount = accountRepository.find(receiveAccountId).orElseThrow(AccountNotFoundException::new);
    sendAccount.withdraw(value);
    receiveAccount.deposit(value);
  }

  public static AccountService getInstance(){
    if (Objects.isNull(instance)) {
      instance = new AccountServiceImpl();
    }
    return instance;
  }

  @Override
  public List<Account> findAll() {
    return accountRepository.findAll();
  }

  @Override
  public void delete(String accountId) {
    accountRepository.delete(accountId);
  }
  
}
