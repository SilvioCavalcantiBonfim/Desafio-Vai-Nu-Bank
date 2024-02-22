import domain.account.savingsaccount.process.SavingsAccountProcess;
import view.input.Menu;
import view.output.Message;
import view.output.Output;

public class App {
    public static void main(String[] args) throws Exception {

        SavingsAccountProcess.boot();

        Output output = new Output(System.out::println);

        output.wellcome();
        output.selectOption();

        Menu mainMenu = new Menu(output);
        mainMenu.addOption(0, Message.OPTION_EXIT, () -> System.exit(0));
        mainMenu.addOption(1, Message.ACCESS_ACCOUNT, () -> {});

        mainMenu.print();

    }
}
