package application.controller;

public interface OutputController {

  void print(String txt);
  void printf(String txt, Object ...arg);

  public static OutputController getInstance() {
    return ConsoleOutputController.getInstance();
  }
}