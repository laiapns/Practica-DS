package baseNoStates;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class Clock {
    private LocalDateTime startTime;
    private LocalDateTime date;
    private Door door;
    private Timer timer;
    private int period;

    public Clock(int period, Door door) {
        this.period = period;
        this.timer = new Timer();
        this.door = door;
    }

    public void start() {
        startTime = LocalDateTime.now();
        TimerTask repeatedTask = new TimerTask() {
            public void run() {
                date = LocalDateTime.now();
                System.out.println("run() executed at " + date);
            }
        };
        timer.scheduleAtFixedRate(repeatedTask, 0, 1000 * period);
    }

    public void stop() {
        timer.cancel();
    }

    public int getPeriod() {
        return period;
    }
    public long getElapsedSeconds() {
        LocalDateTime now = LocalDateTime.now();
        return Duration.between(startTime, now).getSeconds();
    }

}

