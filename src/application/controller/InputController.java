package application.controller;

import java.util.function.Function;

public abstract class InputController {

  protected abstract <T> T readInput(Function<String, T> castingFunction);

  public String next() {
    return readInput(Function.identity());
  }

  public Integer nextInteger() throws NumberFormatException {
    return readInput(Integer::parseInt);
  }

  public Double nextDouble() throws NumberFormatException {
    return readInput(Double::parseDouble);
  }

  public static InputController getInstance() {
    return ConsoleInputController.getInstance();
  }

}