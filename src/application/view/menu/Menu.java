package application.view.menu;

public interface Menu<T> {

  public void addOptionWithAction(T id, String text, Runnable action);

  public void addOption(T id, String text);

  public String getMenuString();

  public boolean executeAction(T id);

  public static <T> Menu<T> create(){
    return new ConsoleMenu<T>(MenuTextsStorage.SELECT_OPTION, MenuTextsStorage.INSTRUCTION_CHOICE, () -> {});
  }

  public static <T> Menu<T> create(Runnable invalidOption){
    return new ConsoleMenu<T>(MenuTextsStorage.SELECT_OPTION, MenuTextsStorage.INSTRUCTION_CHOICE, invalidOption);
  }

  public static <T> Menu<T> create(String selectOption, String instructionChoice, Runnable invalidOption){
    return new ConsoleMenu<T>(selectOption, instructionChoice, invalidOption);
  }

  public static <T> Menu<T> create(String selectOption){
    return new ConsoleMenu<T>(selectOption, MenuTextsStorage.INSTRUCTION_CHOICE, () -> {});
  }

  public static <T> Menu<T> create(String selectOption, Runnable invalidOption){
    return new ConsoleMenu<T>(selectOption, MenuTextsStorage.INSTRUCTION_CHOICE, invalidOption);
  }
}
