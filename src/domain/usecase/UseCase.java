package domain.usecase;

import java.util.regex.Pattern;

import application.controller.InputController;
import application.controller.OutputController;

public abstract class UseCase {

  protected final OutputController outputController;
  protected final InputController inputController;

  public UseCase() {
    outputController = OutputController.getInstance();
    inputController = InputController.getInstance();
  }

  public abstract void execute();

  public static void boot() {
    UseCase mainMenu = new MainMenuUseCase();
    mainMenu.execute();
  }

  protected String getData(final String regex, final String startMsg, final String invalidMsg) {
    outputController.print(startMsg);
    String data = inputController.next();
    while (!Pattern.matches(regex, data)) {
      outputController.print(invalidMsg);
      data = inputController.next();
    }
    return data;
  }
}
