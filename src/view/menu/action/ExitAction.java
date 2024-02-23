package view.menu.action;

import controller.Message;

public final class ExitAction extends Action{

  public void execute() {
    try {
      getOutputController().print(Message.EXIT_MESSAGE);
      System.exit(0);
    } catch (Exception e) {}
  }
}
