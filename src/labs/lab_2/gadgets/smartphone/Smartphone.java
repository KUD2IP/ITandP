package labs.lab_2.gadgets.smartphone;

import labs.lab_2.gadgets.Gadgets;

public abstract class Smartphone extends Gadgets {
    private int power;
    private boolean on = false;

    public Smartphone() {
    }

    public Smartphone(int power) {
        this.power = power;

    }

    @Override
    public void on() {
        this.on = true;
        System.out.println("Smartphone is on!");
    }

    @Override
    public void off() {
        this.on = false;
        System.out.println("Smartphone is off!");
    }

    @Override
    public void charge(){
        System.out.println("Smartphone is charging...");
        Thread powerSmartphone = new Thread();
        powerSmartphone.start();
        for (int i = this.power; i <= 100; i++) {
            try {
                if(on) {
                    Thread.sleep(600);
                }else{
                    Thread.sleep(300);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i + "%");
            power = i;
        }
        System.out.println("Smartphone is charged!");
    }

    public void downloadApp(String ... app) {
        System.out.println("The app cannot be installed without the phone model!");
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
}
