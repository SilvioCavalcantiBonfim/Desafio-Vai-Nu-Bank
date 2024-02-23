package view.menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import controller.InputController;
import controller.Message;
import controller.OutputController;

public class Menu {

  private final OutputController outputController;
  private final InputController inputController;
  private boolean infinityMenuEnabled = true;
  private final Map<Integer, Option> options = new HashMap<>();

  public Menu(OutputController output) {
    this.outputController = output;
    this.inputController = InputController.getInstance();
  }

  public Menu(OutputController output, boolean infinityMenu) {
    this.outputController = output;
    this.infinityMenuEnabled = infinityMenu;
    this.inputController = InputController.getInstance();
  }

  public void addOption(int id, String text, Runnable action) {
    options.put(id, new Option(outputController, id, text, action));
  }

  public void addOption(int id, String text) {
    options.put(id, new Option(outputController, id, text, () -> {
    }));
  }

  public void drawnMenu() {
    outputController.print(Message.SELECT_OPTION);
    options.values().stream().sorted().forEach(Option::print);
    outputController.print(Message.INSTRUCTION_CHOICE);
  }

  public void execute() {
    do {
      Integer option = inputController.readInteger(
          () -> drawnMenu(),
          (value) -> Objects.nonNull(options.get(value)),
          () -> outputController.print(Message.INVALID_OPTION));
      if (Objects.nonNull(option)) {
        options.get(option).active();
        option = null;
      }
    } while (infinityMenuEnabled);
  }

  public void stopMenu(){
    infinityMenuEnabled = false;
  }
}
