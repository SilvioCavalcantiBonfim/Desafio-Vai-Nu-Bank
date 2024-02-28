import domain.service.CurrentAccountProcessService;
import domain.service.SavingsAccountProcessService;
import domain.usecase.UseCase;

public class Application {
    public static void main(String[] args) throws Exception {

        SavingsAccountProcessService.boot();
        CurrentAccountProcessService.boot();

        UseCase.boot();
        
    }
}
