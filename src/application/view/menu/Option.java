package application.view.menu;

class Option<T> {

  private final T id;
  private final String text;
  private final Runnable action;

  public Option(T id, String text, Runnable action) {
    this.id = id;
    this.text = text;
    this.action = action;
  }

  public Option(T id, String text) {
    this(id, text, () -> {});
  }

  public void active() {
    action.run();
  }

  public T getId() {
    return id;
  }

  @Override
  public String toString() {
    return String.format("[%d] %s.\n", id, text);
  }

  
}