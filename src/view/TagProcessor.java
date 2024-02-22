package view;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import view.ansi.ANSI;
import view.ansi.Color;
import view.ansi.Style;
import view.ansi.ANSI.Builder;

public class TagProcessor {

  public static String apply(String str) {
    String strProcessed = str.replaceAll("</([A-Z]+-)?[A-Z]+>", ANSI.builder().build());

    Pattern pattern = Pattern.compile("<([A-Z]+-)?[A-Z]+>");
    Matcher matcher = pattern.matcher(strProcessed);

    List<String> tags = matcher.results().map(MatchResult::group).toList();
    
    for (String tag : tags) {
      String[] param = tag.substring(1, tag.length() - 1).split("-");
      Builder style = ANSI.builder();
      if (param.length >= 1) {
        style.setColor(Color.valueOf(param[0].toUpperCase()));
      }
      if (param.length >= 2) {
        style.setStyle(Style.valueOf(param[1].toUpperCase()));
      }
      strProcessed = strProcessed.replaceAll(tag, style.build());
    }
    return strProcessed;
  }
}
