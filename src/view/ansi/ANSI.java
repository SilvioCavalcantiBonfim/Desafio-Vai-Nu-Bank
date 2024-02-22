package view.ansi;

import java.util.Objects;

public class ANSI {

  private static String prefix = "\033";

  public static void setting(String prefixArg) {
    prefix = prefixArg;
  }

  public static class Builder {

    private Color color = null;
    private Style style = Style.DEFUALT;
    private Color background = null;

    public Builder setColor(Color color) {
      this.color = color;
      return this;
    }

    public Builder setStyle(Style style) {
      this.style = style;
      return this;
    }

    public Builder setBackground(Color background) {
      this.background = background;
      return this;
    }

    public String build() {
      StringBuilder strColor = new StringBuilder(prefix);
      strColor.append("[");
      strColor.append(style.ordinal());
      if (Objects.nonNull(color)) {
        strColor.append(";");
        strColor.append(color.color());
      }
      if (Objects.nonNull(background)) {
        strColor.append(";");
        strColor.append(color.background());
      }
      strColor.append("m");

      return strColor.toString();
    }
  }

  public static Builder builder() {
    return new Builder();
  }
}
