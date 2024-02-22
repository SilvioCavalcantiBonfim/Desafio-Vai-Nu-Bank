package view.output;

import java.util.function.Consumer;

import view.TagProcessor;

public class Output {

  private final Consumer<Object> output;

  public Output(Consumer<Object> output) {
    this.output = output;
  }

  public void wellcome(){
   print(Message.WELLCOME);
  }
 
  public void selectOption(){
    print(Message.SELECT_OPTION);
  }

  public void print(String txt){
    output.accept(TagProcessor.apply(txt));
  }
  
}
