package baseNoStates;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

public class Clock extends Observable {
    private static Clock instance = null;
    private LocalDateTime date;
    private Timer timer;
    private int period = 1;

    private Clock() {
        this.timer = new Timer();
    }

    public static Clock getInstance() {
        if (instance == null) {
            instance = new Clock();
        }
        return instance;
    }

    public void setPeriod(int period){
        this.period = period;
    }

    public void start() {
        TimerTask repeatedTask = new TimerTask() {
            public void run() {
                date = LocalDateTime.now();
                System.out.println("run() executed at " + date);
                setChanged();
                notifyObservers();
            }
        };
        timer.scheduleAtFixedRate(repeatedTask, 0, 1000L * period);
    }

    public void stop() {
        timer.cancel();
    }

    public int getPeriod() {
        return period;
    }
    public long getElapsedSecondsFrom(LocalDateTime fromTime) {
        LocalDateTime now = LocalDateTime.now();
        return Duration.between(fromTime, now).getSeconds();
    }
}

