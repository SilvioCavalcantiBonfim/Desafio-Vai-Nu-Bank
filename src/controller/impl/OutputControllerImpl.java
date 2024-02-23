package controller.impl;

import java.util.Objects;
import java.util.function.Consumer;

import controller.OutputController;
import controller.TagProcessor;

public class OutputControllerImpl implements OutputController {

  private static OutputControllerImpl instance = null;

  private final Consumer<Object> output;

  private OutputControllerImpl(Consumer<Object> output) {
    this.output = output;
  }

  @Override
  public void print(String txt){
    output.accept(TagProcessor.apply(txt));
  }

  public static OutputControllerImpl getInstance(){
    if(Objects.isNull(instance)){
      instance = new OutputControllerImpl(System.out::print);
    }
    return instance;
  }
  
}
