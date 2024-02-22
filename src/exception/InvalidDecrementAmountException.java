package exception;

public class InvalidDecrementAmountException extends RuntimeException {
  public InvalidDecrementAmountException() {
    super("O valor do decremento deve ser maior que zero e não deve exceder o saldo atual da conta.");
  }
}