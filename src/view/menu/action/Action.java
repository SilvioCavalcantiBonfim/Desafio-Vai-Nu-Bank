package view.menu.action;

import java.util.regex.Pattern;

import controller.InputController;
import controller.OutputController;

public abstract sealed class Action permits AccessAccountAction, CreateAccountAction, ExitAction, FindAllAction, AccountPresentAction{

  private final OutputController outputController;
  private final InputController inputController;

  public Action() {
    outputController = OutputController.getInstance();
    inputController = InputController.getInstance();
  }

  public abstract void execute();

  protected OutputController getOutputController() {
    return outputController;
  }

  protected InputController getInputController() {
    return inputController;
  }

  protected String getData(final String regex, final String startMsg, final String invalidMsg) {
    outputController.print(startMsg);
    String data = inputController.read(Pattern.compile(regex).asMatchPredicate(),
        (txt) -> outputController.print(invalidMsg));
    return data;
  }
  
}
