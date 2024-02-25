package application.controller;

public interface OutputController {

  void print(String txt);

  public static OutputController getInstance() {
    return ConsoleOutputController.getInstance();
  }
}