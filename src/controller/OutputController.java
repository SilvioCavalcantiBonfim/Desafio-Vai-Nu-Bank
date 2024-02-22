package controller;

import controller.impl.OutputControllerImpl;

public interface OutputController {

  void print(String txt);

  public static OutputController getInstance() {
    return OutputControllerImpl.getInstance();
  }
}