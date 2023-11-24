package basenostates.secondmilestone;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;
import org.slf4j.Logger;

/**
 * The 'Clock' class represents a simple clock with observable capabilities.
 * It allows observing entities to be notified at regular intervals.
 */
public final class Clock extends Observable {
  private static Clock instance = null;
  private LocalDateTime date;
  private final Timer timer;
  private int clockPeriod = 1;
  private static final Logger LOGGER =
      org.slf4j.LoggerFactory.getLogger(Clock.class);

  /**
   * Private constructor to ensure the singleton pattern.
   */
  private Clock() {
    this.timer = new Timer();
  }

  /**
   * Retrieves the instance of the Clock, ensuring it
   * follows the singleton pattern.
   *
   * @return The singleton instance of the Clock.
   */
  public static Clock getInstance() {
    if (instance == null) {
      instance = new Clock();
    }
    return instance;
  }

  public void setPeriod(final int period) {
    this.clockPeriod = period;
  }

  /**
   * Starts the clock, scheduling repeated tasks to notify
   * observers at regular intervals.
   */
  public void start() {
    TimerTask repeatedTask = new TimerTask() {
      public void run() {
          date = LocalDateTime.now();
          LOGGER.debug("executed at {}", date);
          setChanged();
          notifyObservers();
      }
    };
    timer.scheduleAtFixedRate(repeatedTask, 0, 1000L * clockPeriod);
  }

  public void stop() {
    timer.cancel();
  }

  public int getPeriod() {
    return clockPeriod;
  }

  /**
   * Calculates and retrieves the elapsed seconds from a specified time.
   *
   * @param fromTime The starting time.
   * @return The elapsed seconds from the specified time until now.
   */
  public long getElapsedSecondsFrom(final LocalDateTime fromTime) {
    LocalDateTime now = LocalDateTime.now();
    return Duration.between(fromTime, now).getSeconds();
  }
}

