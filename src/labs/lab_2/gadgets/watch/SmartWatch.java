package labs.lab_2.gadgets.watch;

import labs.lab_2.gadgets.Gadgets;

import java.time.LocalDate;
import java.time.LocalTime;

public class SmartWatch extends Gadgets {
    private int power;
    private boolean on;
    private LocalDate localDate = LocalDate.now();
    private LocalTime localTime = LocalTime.now();
    private String date = localDate.toString() + " " + localTime.toString();

    public SmartWatch() {
    }

    public SmartWatch(int power) {
        this.power = power;
    }

    @Override
    public void on() {
        on = true;
        System.out.println("Watch is on!");
    }

    @Override
    public void off() {
        on = false;
        System.out.println("Watch is off!");
    }

    @Override
    public void charge() {
        System.out.println("Watch is charging...");
        Thread powerWatch = new Thread();
        powerWatch.start();
        for (int i = this.power; i <= 100; i++) {
            try {
                if(on) {
                    Thread.sleep(300);
                }else{
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i + "%");
        }
        System.out.println("Watch is charged!");
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
