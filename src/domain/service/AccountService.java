package domain.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import domain.entity.account.Account;
import domain.entity.account.Person;
import exception.AccountNotFoundException;
import exception.AlreadyDependentException;

public interface AccountService {
  
  Account createSavingsAccount(String accountHolderName, String accountHolderCPF);
  
  Account createCurrentAccount(String accountHolderName, String accountHolderCPF);

  void transfer(String sendAccountId, String receiveAccountId, BigDecimal value);

  Optional<Account> findById(String accountId);

  List<Account> findAll();

  List<Person> findAllDependents(String accountId) throws AccountNotFoundException;

  void createDependent(String accountId, String fullname, String cpf) throws AccountNotFoundException, AlreadyDependentException;

  void removeDependent(String accountId, String cpf) throws AccountNotFoundException;
  
  void delete(String accountId);

  BigDecimal getBalanceAccount(String accountId);

  void deposit(String accountId, BigDecimal value);
  
  void withdraw(String accountId, BigDecimal value);

  public static AccountService getInstance() {
    return AccountServiceImpl.getInstance();
  }

}
