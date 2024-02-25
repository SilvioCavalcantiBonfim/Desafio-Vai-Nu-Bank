package domain.service;

import java.time.LocalDate;

public interface TimeService {
  
  public static final int TIME_SCALE = 1000;

  LocalDate currentDay();

  public static TimeService getInstance(){
    return TimeServiceImpl.getInstance();
  }
}
