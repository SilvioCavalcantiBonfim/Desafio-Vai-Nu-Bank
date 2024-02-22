// import domain.account.savingsaccount.process.SavingsAccountProcess;
import controller.OutputController;
import controller.impl.OutputControllerImpl;
import view.menu.MainMenuAction;
import view.menu.Menu;
import view.output.Message;

public class App {
    public static void main(String[] args) throws Exception {

        // SavingsAccountProcess.boot();

        OutputController output = OutputControllerImpl.getInstance();
        MainMenuAction mainActions = new MainMenuAction();
        
        output.print(Message.WELLCOME);
        
        Menu mainMenu = new Menu(output);
        mainMenu.addOption(0, Message.OPTION_EXIT, mainActions::exitApplication);
        mainMenu.addOption(1, Message.ALL_ACCOUNT, mainActions::findAllAccount);
        mainMenu.addOption(2, Message.ACCESS_ACCOUNT, mainActions::accessAccount);
        mainMenu.addOption(3, Message.CREATE_ACCOUNT, mainActions::createAccount);
        
        mainMenu.execute();
        
    }
}
