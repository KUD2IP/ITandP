package labs.lab_2.gadgets.watch;

import labs.lab_2.gadgets.Gadgets;

import java.time.LocalDate;
import java.time.LocalTime;

public class SmartWatch extends Gadgets {
    private String date = LocalDate.now().toString() + " " + LocalTime.now().toString();

    public SmartWatch() {
    }

    public SmartWatch(int power) {
        super(power);
    }

    @Override
    public void on() {
        setOn(true);
        System.out.println("Watch is on!");
    }

    @Override
    public void off() {
        setOn(false);
        System.out.println("Watch is off!");
    }

    @Override
    public void charge() {
        System.out.println("Watch is charging...");
        Thread powerWatch = new Thread();
        powerWatch.start();
        for (int i = getPower(); i <= 100; i++) {
            try {
                if(isOn()) {
                    Thread.sleep(300);
                }else{
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i + "%");
            setPower(i);
        }
        System.out.println("Watch is charged!");
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
