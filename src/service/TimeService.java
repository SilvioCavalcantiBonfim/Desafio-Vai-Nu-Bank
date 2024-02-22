package service;

import java.time.LocalDate;

import service.impl.TimeServiceImpl;

public interface TimeService {
  
  public static final int TIME_SCALE = 1000;

  LocalDate currentDay();

  public static TimeService getInstance(){
    return TimeServiceImpl.getInstance();
  }
}
