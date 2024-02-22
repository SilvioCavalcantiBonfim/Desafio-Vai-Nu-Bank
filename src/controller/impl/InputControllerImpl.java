package controller.impl;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

import controller.InputController;

public class InputControllerImpl implements InputController {

  private Scanner scannerInstance = null;
  private static InputController instance = null;

  private InputControllerImpl() {
    scannerInstance = new Scanner(System.in);
  }

  @Override
  public String read(Predicate<String> validator, Consumer<String> err) {
    String data;
    while (true) {
      data = scannerInstance.nextLine();
      System.out.println(data);
      if (validator.test(data)) {
        break;
      } else {
        err.accept(data);
      }
    }
    return data;
  }

  @Override
  public Integer readInteger(Runnable beforeExec, Predicate<Integer> validator, Runnable err) {
    Integer data;
    while (true) {
      try {
        beforeExec.run();
        data = scannerInstance.nextInt();
        if (validator.test(data)) {
          break;
        } else {
          err.run();
        }
      } catch (IllegalArgumentException e) {
        err.run();
      } catch (InputMismatchException e) {
        scannerInstance.nextLine();
        err.run();
      }
    }
    scannerInstance.nextLine();
    return data;
  }

  public static InputController getInstance() {
    if (Objects.isNull(instance)) {
      instance = new InputControllerImpl();
    }
    return instance;
  }

}
