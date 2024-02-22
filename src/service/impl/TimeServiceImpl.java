package service.impl;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicLong;

import service.TimeService;

public class TimeServiceImpl extends TimerTask implements TimeService {

  private static TimeServiceImpl instance = null;
  private static Timer timer = null;

  private LocalDate ref = LocalDate.now();
  private AtomicLong skip = new AtomicLong();

  @Override
  public LocalDate currentDay() {
    return ref.plusDays(skip.get());
  }

  @Override
  public void run() {
    skip.incrementAndGet();    
  }

  public static TimeServiceImpl getInstance() {
    if (Objects.isNull(instance)) {
      instance = new TimeServiceImpl();
      timer = new Timer();
      timer.schedule(instance, 0, TimeService.TIME_SCALE);
    }
    return instance;
  }

}
