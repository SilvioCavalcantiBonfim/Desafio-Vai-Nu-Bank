package domain.account;

import java.math.BigDecimal;
import java.util.function.Supplier;

class AccountValidator {

  private AccountValidator(){}

  public static void validateAmount(BigDecimal amount, Supplier<? extends RuntimeException> exception) {
    if (amount.signum() != 1) {
      throw exception.get();
    }
  }
  
  public static void validateDecrement(BigDecimal result, Supplier<? extends RuntimeException> exception) {
    if (result.signum() == -1) {
      throw exception.get();
    }
  }
}
