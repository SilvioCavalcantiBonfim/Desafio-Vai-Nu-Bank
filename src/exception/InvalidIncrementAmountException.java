package exception;

public class InvalidIncrementAmountException extends RuntimeException {
  public InvalidIncrementAmountException() {
    super("O valor do incremento deve ser maior que zero.");
  }
}
