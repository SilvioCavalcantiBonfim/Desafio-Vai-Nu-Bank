package domain.account;

import java.math.BigDecimal;

interface Operator {
  
  void withdraw(BigDecimal value);
  void deposit(BigDecimal value);
  void transfer(String accountId, BigDecimal value);

}
