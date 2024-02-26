package application.controller;

import java.util.Objects;
import java.util.function.Consumer;

import application.view.ansi.HTMLTagToANSIConverter;

class ConsoleOutputController implements OutputController {

  private static ConsoleOutputController instance = null;

  private final Consumer<Object> output;

  private ConsoleOutputController(Consumer<Object> output) {
    this.output = output;
  }

  @Override
  public void print(String txt){
    output.accept(HTMLTagToANSIConverter.convert(txt));
  }

  @Override
  public void printf(String txt, Object ...args){
    output.accept(String.format(HTMLTagToANSIConverter.convert(txt), args));
  }

  public static OutputController getInstance(){
    if(Objects.isNull(instance)){
      instance = new ConsoleOutputController(System.out::print);
    }
    return instance;
  }
  
}
