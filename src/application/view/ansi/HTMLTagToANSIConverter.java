package application.view.ansi;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class HTMLTagToANSIConverter {

  public static String convert(String htmlString) {
    String processedString = htmlString.replaceAll("</([A-Z]+-)?[A-Z]+>", ANSIFormatter.create().format());

    Pattern pattern = Pattern.compile("<([A-Z]+-)?[A-Z]+>");
    Matcher matcher = pattern.matcher(processedString);

    List<String> tags = matcher.results().map(MatchResult::group).toList();
    
    for (String tag : tags) {
      String[] parameters = tag.substring(1, tag.length() - 1).split("-");
      ANSIFormatter formatter = ANSIFormatter.create();
      if (parameters.length >= 1) {
        formatter.withColor(Color.valueOf(parameters[0].toUpperCase()));
      }
      if (parameters.length >= 2) {
        formatter.withStyle(Style.valueOf(parameters[1].toUpperCase()));
      }
      processedString = processedString.replaceAll(tag, formatter.format());
    }
    return processedString;
  }
}
