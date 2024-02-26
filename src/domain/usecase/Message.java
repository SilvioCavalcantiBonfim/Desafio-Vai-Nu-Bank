package domain.usecase;

public class Message {
        public static final String WELCOME = " __     __      _   _   _          ____                 _    \r\n" +
                        " \\ \\   / /__ _ (_) | \\ | | _   _  | __ )   __ _  _ __  | | __\r\n" +
                        "  \\ \\ / // _` || | |  \\| || | | | |  _ \\  / _` || '_ \\ | |/ /\r\n" +
                        "   \\ V /| (_| || | | |\\  || |_| | | |_) || (_| || | | ||   < \r\n" +
                        "    \\_/  \\__,_||_| |_| \\_| \\__,_| |____/  \\__,_||_| |_||_|\\_\\\r\n" +
                        "                                                   <GRAY-DIM>Vai Na Web</GRAY-DIM>\r\n\n" +
                        "<WHITE-BOLD>Bem-vindo</WHITE-BOLD> ao nosso serviço bancário!\r\n";

        public static final String ALL_ACCOUNT = "<YELLOW-BOLD>Visualizar</YELLOW-BOLD> Todas as Contas";

        public static final String ACCESS_ACCOUNT = "<GREEN-BOLD>Acessar</GREEN-BOLD> Conta Existente";

        public static final String CREATE_ACCOUNT = "<WHITE-BOLD>Criar</WHITE-BOLD> Nova Conta";

        public static final String EXIT_MESSAGE = "\n<WHITE-BOLD>Obrigado por usar nosso serviço bancário. Até a próxima!<WHITE-BOLD>\n\n";

        public static final String OPTION_EXIT = "<RED-BOLD>Sair</RED-BOLD> do Aplicativo";

        public static final String DIVISION = "\n+-----------------+--------------------------------+";

        public static final String LEFT_ALIGN_FORMAT = "\n| <MAGENTA>%-15s</MAGENTA> | <WHITE-BOLD>%-30s</WHITE-BOLD> |";

        public static final String TABLE_TITLE = "\n| <WHITE-BOLD>ID da Conta</WHITE-BOLD>     | <WHITE-BOLD>Nome do Titular</WHITE-BOLD>                |";

        
        public static final String REQUEST_ACCOUNTID = "\nPor favor, insira o número da conta: ";
        
        public static final String REQUEST_VALID_CPF = "\nPor favor, insira um CPF válido: ";
        
        public static final String BACK = "<YELLOW-BOLD>Retornar</YELLOW-BOLD> ao menu anterior";
        
        public static final String SAVINGS_ACCOUNT = "<PURPLE-BOLD>Conta Poupança</PURPLE-BOLD>";
        
        public static final String CURRENT_ACCOUNT = "<PURPLE-BOLD>Conta Corrente</PURPLE-BOLD>";
        
        public static final String INVALID_CPF_FORMAT = "\n<RED-BOLD>Formato de CPF inválido</RED-BOLD>. Por favor, insira um CPF no formato <WHITE-BOLD>000.000.000-00</WHITE-BOLD>: ";
        
        public static final String ILLEGAL_ACCOUNT_ID_FORMAT = "\n<RED-BOLD>Número da conta inválido</RED-BOLD>. Por favor, insira o número da conta (<WHITE-BOLD>0000000000</WHITE-BOLD>): ";
        
        public static final String ACCOUNT_NOT_FOUND = "\n<WHITE-BOLD>Conta</WHITE-BOLD> destino <RED-BOLD>não encontrada.</RED-BOLD>\n\n";
        
        public static final String BALANCE = "<CYAN-BOLD>Consultar</CYAN-BOLD> Saldo";
        
        public static final String DEPOSIT = "Realizar <GREEN-BOLD>Deposito</GREEN-BOLD>";
        
        public static final String WITHDRAW = "Realizar <MAGENTA-BOLD>Saque</MAGENTA-BOLD>";
        
        public static final String TRANSFER = "<PURPLE-BOLD>Transferir</PURPLE-BOLD> valor";
        
        public static final String DELETE_ACCOUNT = "<RED-BOLD>Excluir</RED-BOLD> Conta";
        
        public static final String ILLEGAL_DEPOSIT_VALUE = "\n<RED-BOLD>Valor de depósito inválido</RED-BOLD>. Operação cancelada.\n";
        
        public static final String REQUEST_DEPOSIT_VALUE = "\nPor favor, insira o valor que deseja depositar: ";
        
        public static final String ACCOUNT_BALANCE_FORMAT = "\nO saldo da sua conta é: <GREEN-BOLD>VnW¢</GREEN-BOLD> <WHITE-BOLD>%.2f</WHITE-BOLD>\n";
        
        public static final String REQUEST_WITHDRAW_VALUE = "\nPor favor, insira o valor que deseja sacar: ";
        
        public static final String ILLEGAL_WITHDRAW_VALUE = "\n<RED-BOLD>Valor de saque inválido</RED-BOLD>. Operação cancelada.\n";
        
        public static final String REQUEST_TRANSFER_VALUE = "\nPor favor, insira o valor que deseja transferir: ";
        
        public static final String ILLEGAL_TRANSFER_VALUE_FORMAT = "\n<RED-BOLD>Valor de transferência inválido</RED-BOLD>.";
        
        public static final String ILLEGAL_TRANSFER_VALUE = "\n<RED-BOLD>Valor de transferência inválido</RED-BOLD>. Cancelando operação.";
        
        public static final String CHOOSE_ACCOUNT_TYPE_PROMPT = "\nEscolha o tipo de <WHITE-BOLD>conta</WHITE-BOLD>:\n\n";
        
        public static final String REQUEST_FULL_NAME = "\nPor favor, insira <WHITE-BOLD>seu nome completo</WHITE-BOLD>: ";
        
        public static final String ILLEGAL_FULL_NAME = "\n<RED-BOLD>Nome inválido</RED-BOLD>. Por favor, insira seu nome completo (<WHITE-BOLD>primeiro nome</WHITE-BOLD> e <WHITE-BOLD>sobrenome</WHITE-BOLD>): ";

        public static final String CANCEL_CREATE_ACCOUNT_OPTION = "<RED-BOLD>Cancelar</RED-BOLD> a criação da conta";
        
        public static final String CANCEL_CREATE_ACCOUNT_SUCCESS_MESSAGE = "\nA criação da conta foi <RED-BOLD>cancelada</RED-BOLD>.\n";
        
        public static final String ACCOUNT_CREATED_SUCCESSFULLY = "\n<GREEN-BOLD>Conta criada com sucesso!</GREEN-BOLD>\n\n" +
        "<WHITE-BOLD>Número da Conta</WHITE-BOLD>: <MAGENTA>%s</MAGENTA>\n" +
        "<WHITE-BOLD>Nome           </WHITE-BOLD>: <WHITE>%s</WHITE>\n" +
        "<WHITE-BOLD>CPF            </WHITE-BOLD>: <WHITE>%s</WHITE>\n" +
        "<WHITE-BOLD>Saldo Inicial  </WHITE-BOLD>: <GREEN-BOLD>VnW¢</GREEN-BOLD> <WHITE-BOLD>%.2f</WHITE-BOLD>\n";

        public static final String INVALID_OPTION = "\n<RED-BOLD>Opção inválida</RED-BOLD>. Por favor, selecione uma das opções disponíveis.\r\n";

        public static final String DEPOSIT_SUCCESS = "\nValor <WHITE-BOLD>depositado</WHITE-BOLD> com <GREEN-BOLD>sucesso</GREEN-BOLD>.\r\n";

        public static final String WITHDRAW_SUCCESS = "\n<WHITE-BOLD>Saque</WHITE-BOLD> realizado com <GREEN-BOLD>sucesso</GREEN-BOLD>.\r\n";

        public static final String TRANSFER_SUCCESS = "\n<WHITE-BOLD>Transferência</WHITE-BOLD> realizado com <GREEN-BOLD>sucesso</GREEN-BOLD>.\r\n";

        public static final String DEPENDENT_ADD = "<GREEN-BOLD>Adicionar</GREEN-BOLD> novo dependente";

        public static final String DEPENDENT_REMOVE = "<RED-BOLD>Remover</RED-BOLD> dependente";

        public static final String DEPENDENT_MANAGER = "Gerenciar <WHITE-BOLD>dependentes</WHITE-BOLD>";

        public static final String REQUEST_DEPENDENT_FULL_NAME = "\nPor favor, insira o <WHITE-BOLD>nome completo</WHITE-BOLD> do dependente: ";

        public static final String DEPENDENT_ADD_SUCCESS = "<WHITE-BOLD>%s</WHITE-BOLD> foi adicionado com <GREEN-BOLD>sucesso</GREEN-BOLD> como seu dependente.";

        public static final String ALL_DEPENDENT = "<YELLOW-BOLD>Visualizar</YELLOW-BOLD> todos os dependentes";

        public static final String TABLE_TITLE_DEPENDENT = "\n| <WHITE-BOLD>Nome</WHITE-BOLD>            | <WHITE-BOLD>CPF</WHITE-BOLD>                            |"+DIVISION;

        public static final String DEPENDENT_REMOVE_OPTION = "<WHITE-BOLD>%s</WHITE-BOLD>";

        public static final String DEPENDENT_NOT_FOUNT = "\n<RED-BOLD>Você não possui dependentes cadastrados.</RED-BOLD>\n\n";

        public static final String DEPENDENT_ALREADY = "\nVocê já possui um dependente com o CPF <YELLOW-BOLD>%s</YELLOW-BOLD> cadastrado.\n\n";
        
}
