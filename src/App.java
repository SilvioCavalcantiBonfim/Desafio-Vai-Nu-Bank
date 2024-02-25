import domain.service.SavingsAccountQueueProcessService;
import domain.usecase.UseCase;

public class App {
    public static void main(String[] args) throws Exception {

        SavingsAccountQueueProcessService.boot();
        UseCase.boot();
        
    }
}
