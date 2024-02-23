import domain.account.savingsaccount.process.SavingsAccountProcess;
import controller.Message;
import controller.OutputController;
import controller.impl.OutputControllerImpl;
import view.menu.Menu;
import view.menu.action.AccessAccountAction;
import view.menu.action.CreateAccountAction;
import view.menu.action.ExitAction;
import view.menu.action.FindAllAction;

public class App {
    public static void main(String[] args) throws Exception {

        SavingsAccountProcess.boot();

        OutputController output = OutputControllerImpl.getInstance();
        ExitAction exitAction = new ExitAction();
        CreateAccountAction createAccountAction = new CreateAccountAction();
        FindAllAction findAllAction = new FindAllAction();
        AccessAccountAction accessAccountAction = new AccessAccountAction();
        
        output.print(Message.WELCOME);
        
        Menu mainMenu = new Menu(output);
        mainMenu.addOption(0, Message.OPTION_EXIT, exitAction::execute);
        mainMenu.addOption(1, Message.ALL_ACCOUNT, findAllAction::execute);
        mainMenu.addOption(2, Message.ACCESS_ACCOUNT, accessAccountAction::execute);
        mainMenu.addOption(3, Message.CREATE_ACCOUNT, createAccountAction::execute);
        
        mainMenu.execute();
        
    }
}
