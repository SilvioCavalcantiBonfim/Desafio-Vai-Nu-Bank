package domain.entity.account;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import exception.InvalidDecrementAmountException;
import exception.InvalidIncrementAmountException;

public abstract class Account implements Operator {

  private final String accountId;
  private final Person owner;
  private final List<Person> dependent;
  private BigDecimal value;

  public Account(String accountId, String accountHolderName, String accountHolderCPF, BigDecimal value) {
    this.accountId = accountId;
    this.owner = new Person(accountHolderName, accountHolderCPF);
    this.value = value;
    dependent = new LinkedList<>();
  }

  public String getAccountId() {
    return accountId;
  }

  public String getAccountHolderName() {
    return owner.name();
  }

  public String getAccountHolderCPF() {
    return owner.cpf();
  }

  public BigDecimal getValue() {
    return value;
  }

  public boolean addDependent(String dependentName, String dependentCPF){
    return dependent.add(new Person(dependentName, dependentCPF));
  }

  public List<Person> getAllDependents(){
    return Collections.unmodifiableList(dependent);
  }

  public void removeAllDependent(){
    dependent.clear();
  }

  protected void incrementValue(BigDecimal incrementAmount) {
    AccountValidator.validateAmount(incrementAmount, InvalidIncrementAmountException::new);
    value = incrementAmount.add(value);
  }

  protected void decrementValue(BigDecimal decrementAmount) {
    AccountValidator.validateAmount(decrementAmount, InvalidDecrementAmountException::new);
    BigDecimal decrementResultValue = value.subtract(decrementAmount);
    AccountValidator.validateDecrement(decrementResultValue, InvalidDecrementAmountException::new);
    value = decrementResultValue;
  } 

}
