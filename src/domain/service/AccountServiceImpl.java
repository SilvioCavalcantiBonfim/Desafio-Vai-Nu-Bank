package domain.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import domain.entity.account.Account;
import domain.entity.account.Person;
import domain.entity.account.currentaccount.CurrentAccount;
import domain.entity.account.savingsaccount.SavingsAccount;
import domain.repository.AccountRepository;
import exception.AccountNotFoundException;
import exception.AlreadyDependentException;

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
    
    String accountId = generateAccountId();

    Account newAccount = new SavingsAccount("00"+accountId, accountHolderName, accountHolderCPF,
        BigDecimal.valueOf(10));

    accountRepository.save(newAccount);
    
    return newAccount;
  }

  private String generateAccountId() {
    return IntStream.range(0, 8).mapToObj(d -> Integer.toString(rng.nextInt(10)))
        .collect(Collectors.joining(""));
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

  @Override
  public List<Person> findAllDependents(String accountId) {
    return findById(accountId).map(Account::getAllDependents).orElse(List.of());
  }

  @Override
  public void createDependent(String accountId, String fullname, String cpf) {
    Account account = findById(accountId).orElseThrow(AccountNotFoundException::new);
    if(account.getAllDependents().stream().anyMatch((dependent) -> dependent.cpf().equals(cpf))){
      throw new AlreadyDependentException();
    }
    account.addDependent(fullname, cpf);
  }

  @Override
  public void removeDependent(String accountId, String cpf) throws AccountNotFoundException {
    Account account = findById(accountId).orElseThrow(AccountNotFoundException::new);
    List<Person> currentDependents = account.getAllDependents().stream().filter(dependent -> !dependent.cpf().equals(cpf)).toList();
    account.removeAllDependent();
    currentDependents.forEach(dependent -> account.addDependent(dependent.name(), dependent.cpf()));

  }

  @Override
  public Account createCurrentAccount(String accountHolderName, String accountHolderCPF) {
    String accountId = generateAccountId();
    Account account = new CurrentAccount("10"+accountId, accountHolderName, accountHolderCPF, BigDecimal.valueOf(10));

    accountRepository.save(account);
    return account;
  }

  @Override
  public BigDecimal getBalanceAccount(String accountId) {
    Account account = findById(accountId).orElseThrow(AccountNotFoundException::new);
    return account.getValue();
  }

  @Override
  public void deposit(String accountId, BigDecimal value) {
    Account account = findById(accountId).orElseThrow(AccountNotFoundException::new);
    account.deposit(value);
  }

  @Override
  public void withdraw(String accountId, BigDecimal value) {
    Account account = findById(accountId).orElseThrow(AccountNotFoundException::new);
    account.withdraw(value);
  }
  
}
