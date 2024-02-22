package view.input;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import view.output.Output;

public class Menu {

  private final Output output;
  private final Map<Integer, Option> options = new HashMap<>();

  public Menu(Output output){
    this.output = output;
  }

  public void addOption(int id, String text, Runnable action){
    options.put(id, new Option(output, id, text, action));
  }

  public void print(){
    options.values().stream().sorted().forEach(Option::print);
  }
}
