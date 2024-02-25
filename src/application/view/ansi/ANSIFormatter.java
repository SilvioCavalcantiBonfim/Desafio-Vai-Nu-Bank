package application.view.ansi;

import java.util.Objects;

class ANSIFormatter {

  private static Prefix prefix = Prefix.ANSIC;

  public static void setting(Prefix prefixArg) {
    prefix = prefixArg;
  }

  public static ANSIFormatter create() {
    return new ANSIFormatter();
  }

  private Color color = Color.DEFAULT;
  private Style style = Style.DEFUALT;

  private ANSIFormatter() {}

  public ANSIFormatter withColor(Color color) {
    this.color = color;
    return this;
  }

  public ANSIFormatter withStyle(Style style) {
    this.style = style;
    return this;
  }

  public String format() {
    StringBuilder strColor = new StringBuilder(prefix.getPrefix());
    strColor.append("[");
    strColor.append(style.ordinal());
    if (Objects.nonNull(color)) {
      strColor.append(";");
      strColor.append(color.code());
    }
    strColor.append("m");

    return strColor.toString();
  }
}
