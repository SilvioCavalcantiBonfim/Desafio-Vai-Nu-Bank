package view.ansi;

public enum Color{
  DEFAULT(0),
  BLACK(30),
  RED(31),
  GREEN(32),
  YELLOW(33),
  MAGENTA(34),
  PURPLE(35),
  CYAN(36),
  WHITE(37),
  GRAY(38);

  private final int code;

  private Color(int codeColor) {
    this.code = codeColor;
  }
    
  public int color(){
    return code;
  }

  public int highIntensty(){
    return code + 60;
  }

  public int background(){
    return code + 10;
  }
  
  public int highIntenstyBackground(){
    return code + 70;
  }
}