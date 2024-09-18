package labs.lab_2.gadgets.laptop;

import labs.lab_2.gadgets.Gadgets;

public class Laptop extends Gadgets {
    private int power;
    private boolean on = false;
    private String operatingSystem = null;

    public Laptop() {
    }

    public Laptop(int power) {
        this.power = power;
    }

    @Override
    public void on() {
        on = true;
        System.out.println("Laptop is on!");
    }

    @Override
    public void off() {
        on = false;
        System.out.println("Laptop is off!");
    }

    @Override
    public void charge(){
        System.out.println("Laptop is charging...");
        Thread powerLaptop = new Thread();
        powerLaptop.start();
        for (int i = this.power; i <= 100; i++) {
            try {
                if(on) {
                    Thread.sleep(1000);
                }else{
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i + "%");
            power = i;
        }
        System.out.println("Laptop is charged!");
    }

    public void downloadOperatingSystem(String os) {
        System.out.println("The operating system to cannot be installed without the laptop model!");
    }

    public void keyboard(String language) {
        System.out.println("The language of the keyboard is " + language + "!");
    }

    public void keyboard(String language1, String language2) {
        System.out.println("The language of the keyboard is " + language1 + " and " + language2 + "!");
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

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
}
