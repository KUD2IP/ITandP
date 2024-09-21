package labs.lab_2.gadgets.smartphone;

import labs.lab_2.gadgets.Gadgets;

public abstract class Smartphone extends Gadgets {
    private StringBuilder apps;

    public Smartphone() {
    }

    public Smartphone(int power) {
        super(power);
    }

    @Override
    public void on() {
        setOn(true);
        System.out.println("Smartphone is on!");
    }

    @Override
    public void off() {
        setOn(false);
        System.out.println("Smartphone is off!");
    }

    @Override
    public void charge(){
        System.out.println("Smartphone is charging...");
        Thread powerSmartphone = new Thread();
        powerSmartphone.start();
        for (int i = getPower(); i <= 100; i++) {
            try {
                if(isOn()) {
                    Thread.sleep(600);
                }else{
                    Thread.sleep(300);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i + "%");
            setPower(i);
        }
        System.out.println("Smartphone is charged!");
    }

    public void downloadApp(String ... app) {
        System.out.println("The app cannot be installed without the phone model!");
    }

    public StringBuilder getApps() {
        return apps;
    }

    public void setApps(StringBuilder apps) {
        this.apps = apps;
    }
}
