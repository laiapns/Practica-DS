package baseNoStates;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;
import org.slf4j.Logger;

public final class Clock extends Observable {
    private static Clock instance = null;
    private LocalDateTime date;
    private Timer timer;
    private int clockPeriod = 1;
    private static final Logger LOGGER =
        org.slf4j.LoggerFactory.getLogger(Clock.class);

    private Clock() {
        this.timer = new Timer();
    }

    public static Clock getInstance() {
        if (instance == null) {
            instance = new Clock();
        }
        return instance;
    }

    public void setPeriod(final int period) {
        this.clockPeriod = period;
    }

    public void start() {
        TimerTask repeatedTask = new TimerTask() {
            public void run() {
                date = LocalDateTime.now();
                //LOGGER.debug("executed at {}" , date);
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

    public long getElapsedSecondsFrom(final LocalDateTime fromTime) {
        LocalDateTime now = LocalDateTime.now();
        return Duration.between(fromTime, now).getSeconds();
    }
}

