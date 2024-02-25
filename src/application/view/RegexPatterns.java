package application.view;

public final class RegexPatterns {

  public static final String ACCOUNT_ID_REGEX = "^\\d{10}$";
  public static final String CPF_REGEX = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$";
  public static final String FULLNAME_REGEX = "^[a-zA-Z]{3,}(\s[a-zA-Z]{3,})+$";

  private RegexPatterns(){}
}
