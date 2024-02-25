package application.view.ansi;

enum Prefix{
  BASH("\\e"),
  ANSIC("\033"),
  GNU_CPP("\033");

  private final String prefix;

  private Prefix(String prefix) {
    this.prefix = prefix;
  }
    
  public String getPrefix(){
    return prefix;
  }
}