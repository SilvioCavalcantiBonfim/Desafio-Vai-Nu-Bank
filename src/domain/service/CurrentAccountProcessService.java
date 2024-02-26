package domain.service;

public interface CurrentAccountProcessService {

  void addAccountToNextProcess(String accountId);
  void removeAccountToNextProcess(String accountId);

  public static void boot(){
    CurrentAccountProcessServiceImpl.boot();
  }

  public static CurrentAccountProcessService getInstance(){
    return CurrentAccountProcessServiceImpl.getInstance();
  }
}
