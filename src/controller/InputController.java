package controller;

import java.util.function.Consumer;
import java.util.function.Predicate;

import controller.impl.InputControllerImpl;

public interface InputController {

  String read(Predicate<String> validator, Consumer<String> err);

  Integer readInteger(Runnable beforeExec, Predicate<Integer> validator, Runnable err);

  Double readDouble(Runnable beforeExec, Predicate<Double> validator, Runnable err);

  public static InputController getInstance() {
    return InputControllerImpl.getInstance();
  }

}