package view.input;

import view.output.Output;

class Option implements Comparable<Option>{
  
  private final Output output;
  private final int id;
  private final String text;
  private final Runnable action;

  public Option(Output output, int id, String text, Runnable action) {
    this.output = output;
    this.id = id;
    this.text = text;
    this.action = action;
  }

  public void print(){
    this.output.print(String.format("%d. %s.", id, text));
  }

  public void active(){
    action.run();
  }

  public int getId() {
    return id;
  }

  @Override
  public int compareTo(Option o) {
    return Integer.compare(id, o.getId());
  }
 
}