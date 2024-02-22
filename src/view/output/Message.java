package view.output;

public class Message {
  public static final String WELLCOME = " __     __      _   _   _          ____                 _    \r\n" +
      " \\ \\   / /__ _ (_) | \\ | | _   _  | __ )   __ _  _ __  | | __\r\n" +
      "  \\ \\ / // _` || | |  \\| || | | | |  _ \\  / _` || '_ \\ | |/ /\r\n" +
      "   \\ V /| (_| || | | |\\  || |_| | | |_) || (_| || | | ||   < \r\n" +
      "    \\_/  \\__,_||_| |_| \\_| \\__,_| |____/  \\__,_||_| |_||_|\\_\\\r\n" +
      "                                                   <GRAY-DIM>Vai Na Web</GRAY-DIM>\r\n\n"+//
      "<WHITE-BOLD>Bem-vindo</WHITE-BOLD> ao nosso serviço bancário!\r\n";

  public static final String SELECT_OPTION = "Por favor, selecione uma opção do menu abaixo:\r\n\n";

  public static final String ALL_ACCOUNT = "<YELLOW-BOLD>Visualizar</YELLOW-BOLD> Todas as Contas";

  public static final String ACCESS_ACCOUNT = "<GREEN-BOLD>Acessar</GREEN-BOLD> Conta Existente";

  public static final String CREATE_ACCOUNT = "<WHITE-BOLD>Criar</WHITE-BOLD> Nova Conta";

  public static final String INSTRUCTION_CHOICE = "\nDigite o número correspondente à sua escolha e pressione [<GREEN-BOLD>Enter</GREEN-BOLD>]: ";

  public static final String EXIT_MESSAGE = "\n<WHITE-BOLD>Obrigado por usar nosso serviço bancário. Até a próxima!<WHITE-BOLD>\n\n";

  public static final String OPTION_EXIT = "<RED-BOLD>Sair</RED-BOLD> do Aplicativo";

  public static final String INVALID_OPTION_MESSAGE = "\n<RED-BOLD>Opção inválida</RED-BOLD>. Por favor, selecione uma das opções disponíveis.\r\n";
  
  public static final String DIVISION = "\n+-----------------+--------------------------------+\n";

  public static final String LEFT_ALIGN_FORMAT = DIVISION+"| <MAGENTA>%-15s</MAGENTA> | %-30s |";
  
  public static final String TABLE_TITLE = "| <WHITE-BOLD>ID da Conta</WHITE-BOLD>     | <WHITE-BOLD>Nome do Titular</WHITE-BOLD>                |";

  public static final String REQUEST_FULL_NAME_MESSAGE = "\nPor favor, insira seu nome completo: ";

  public static final String REQUEST_VALID_CPF_MESSAGE = "\nPor favor, insira um CPF válido. O formato deve ser 000.000.000-00: ";

  public static final String BACK = "<YELLOW-BOLD>Retornar</YELLOW-BOLD> ao menu anterior";

  public static final String SAVINGSACCOUNT = "<PURPLE-BOLD>Conta Poupança</PURPLE-BOLD>";

  public static final String CURRENTACCOUNT = "<PURPLE-BOLD>Conta Corrente</PURPLE-BOLD>";

  public static final String INVALID_NAME_MESSAGE = "<RED-BOLD>Nome inválido</RED-BOLD>. Por favor, insira seu nome completo (<WHITE-BOLD>primeiro nome</WHITE-BOLD> e <WHITE-BOLD>sobrenome</WHITE-BOLD>): ";

  public static final String INVALID_CPF_FORMAT_MESSAGE = "<RED-BOLD>Formato de CPF inválido</RED-BOLD>. Por favor, insira um CPF no formato <WHITE-BOLD>000.000.000-00</WHITE-BOLD>: ";

  public static final String ACCOUNT_CREATED_SUCCESSFULLY = "\n<GREEN-BOLD>Conta criada com sucesso!</GREEN-BOLD>\n\n" +
                                                          "<WHITE-BOLD>Número da Conta</WHITE-BOLD>: <MAGENTA>%s</MAGENTA>\n" +
                                                          "<WHITE-BOLD>Nome           </WHITE-BOLD>: <WHITE>%s</WHITE>\n" +
                                                          "<WHITE-BOLD>CPF            </WHITE-BOLD>: <WHITE>%s</WHITE>\n" +
                                                          "<WHITE-BOLD>Saldo Inicial  </WHITE-BOLD>: <WHITE>VnW¢ %.2f</WHITE>\n\n";








}
