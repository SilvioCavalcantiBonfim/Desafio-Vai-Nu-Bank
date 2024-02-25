package domain.entity.account;

import java.math.BigDecimal;

import exception.InvalidDecrementAmountException;
import exception.InvalidIncrementAmountException;

interface Operator {
  
  void withdraw(BigDecimal value) throws InvalidDecrementAmountException;
  void deposit(BigDecimal value) throws InvalidIncrementAmountException;

}
