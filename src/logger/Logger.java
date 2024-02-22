package logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

  private final Class<?> clazz;

  public Logger(Class<?> clazz) {
    this.clazz = clazz;
  }

  public void debug(Object value){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    System.out.println(String.format("\033[32m[%s]\033[0m \033[34m[%s]\033[0m \033[33m[%s]\033[0m: %s", clazz.getSimpleName(),Thread.currentThread().getName(), LocalDateTime.now().format(formatter), value));
  }
}
