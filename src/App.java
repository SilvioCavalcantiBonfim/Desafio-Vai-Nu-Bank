import domain.entity.account.Account;
import domain.service.AccountService;
import domain.service.CurrentAccountProcessService;
import domain.service.SavingsAccountProcessService;
import domain.usecase.UseCase;

public class App {
    public static void main(String[] args) throws Exception {

        SavingsAccountProcessService.boot();
        CurrentAccountProcessService.boot();

        Account account = AccountService.getInstance().createSavingsAccount("teste teste", "123.123.123-12");
        AccountService.getInstance().createDependent(account.getAccountId(), "dependente 1", "000.000.000-00");
        AccountService.getInstance().createDependent(account.getAccountId(), "dependente 2", "000.000.000-01");
        
        Account account1 = AccountService.getInstance().createCurrentAccount("teste teste", "123.123.123-12");
        AccountService.getInstance().createDependent(account1.getAccountId(), "dependente", "000.000.000-00");

        UseCase.boot();
        
    }
}
