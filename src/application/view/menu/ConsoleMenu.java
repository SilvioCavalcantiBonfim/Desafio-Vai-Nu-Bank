package application.view.menu;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class ConsoleMenu<T> implements Menu<T> {

  private final Map<T, Option<T>> options;
  private final String selectOption;
  private final String instructionChoice;
  private final Runnable invalidOption;

  public ConsoleMenu(String selectOption, String instructionChoice, Runnable invalidOption) {
    this.options = new LinkedHashMap<>();
    this.selectOption = selectOption;
    this.instructionChoice = instructionChoice;
    this.invalidOption = invalidOption;
  }

  @Override
  public void addOptionWithAction(T id, String text, Runnable action) {
    options.put(id, new Option<T>(id, text, action));
  }

  @Override
  public void addOption(T id, String text) {
    options.put(id, new Option<T>(id, text, () -> {
    }));
  }

  @Override
  public String getMenuString() {
    StringBuilder menuString = new StringBuilder();
    menuString.append(selectOption);
    menuString.append(options.values().stream().map(Option::toString).collect(Collectors.joining("")));
    menuString.append(instructionChoice);
    return menuString.toString();
  }

  @Override
  public boolean executeAction(T id) {
    Optional<Option<T>> optionSelected = Optional.ofNullable(options.get(id));
    optionSelected.ifPresentOrElse(Option::active, invalidOption);
    return optionSelected.isPresent();
  }
}
