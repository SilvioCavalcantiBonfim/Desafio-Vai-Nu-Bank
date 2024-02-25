package application.controller;

import java.util.Objects;
import java.util.Scanner;
import java.util.function.Function;

class ConsoleInputController extends InputController {

  private Scanner scannerInstance = null;
  private static InputController instance = null;

  private ConsoleInputController() {
    scannerInstance = new Scanner(System.in);
  }

  @Override
  protected <T> T readInput(Function<String, T> castingFunction) {
    T data = castingFunction.apply(scannerInstance.nextLine());
    return data;
  }

  public static InputController getInstance() {
    if (Objects.isNull(instance)) {
      instance = new ConsoleInputController();
    }
    return instance;
  }
}
