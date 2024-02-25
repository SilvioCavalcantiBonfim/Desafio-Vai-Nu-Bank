package domain.usecase;

public final class ExitUseCase extends UseCase{

  public void execute() {
    try {
      outputController.print(Message.EXIT_MESSAGE);
      System.exit(0);
    } catch (Exception e) {}
  }
}
