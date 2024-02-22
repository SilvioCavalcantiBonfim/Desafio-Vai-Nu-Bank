package view.menu;

import controller.OutputController;

class Option implements Comparable<Option> {

  private final OutputController output;
  private final int id;
  private final String text;
  private final Runnable action;

  public Option(OutputController output, int id, String text, Runnable action) {
    this.output = output;
    this.id = id;
    this.text = text;
    this.action = action;
  }

  public void print() {
    this.output.print(String.format("[%d] %s.\n", id, text));
  }

  public void active() {
    action.run();
  }

  public int getId() {
    return id;
  }

  @Override
  public int compareTo(Option o) {
    if (this.id == 0) {
      return 1;
    } else if (o.getId() == 0) {
      return -1;
    } else {
      return Integer.compare(id, o.getId());
    }
  }

}