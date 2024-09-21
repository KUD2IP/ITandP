package labs.lab_2.gadgets.laptop;

import labs.lab_2.gadgets.Gadgets;

public class Laptop extends Gadgets {
    private String operatingSystem;
    private String keyboardLanguage;

    public Laptop() {
        operatingSystem = null;
        keyboardLanguage = null;
    }

    public Laptop(int power) {
        super(power);
        operatingSystem = null;
        keyboardLanguage = null;
    }

    @Override
    public void on() {
        setOn(true);
        System.out.println("Laptop is on!");
    }

    @Override
    public void off() {
        setOn(false);
        System.out.println("Laptop is off!");
    }

    @Override
    public void charge(){
        System.out.println("Laptop is charging...");
        Thread powerLaptop = new Thread();
        powerLaptop.start();
        for (int i = getPower(); i <= 100; i++) {
            try {
                if(isOn()) {
                    Thread.sleep(1000);
                }else{
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i + "%");
            setPower(i);
        }
        System.out.println("Laptop is charged!");
    }

    public void downloadOperatingSystem(String os) {
        System.out.println("The operating system to cannot be installed without the laptop model!");
    }

    public void keyboard(String language) {
        keyboardLanguage = language;
        System.out.println("The language of the keyboard is " + language + "!");
    }

    public void keyboard(String language1, String language2) {
        keyboardLanguage = language1 + " and " + language2;
        System.out.println("The language of the keyboard is " + language1 + " and " + language2 + "!");
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }
    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getKeyboardLanguage() {
        return keyboardLanguage;
    }

    public void setKeyboardLanguage(String keyboardLanguage) {
        this.keyboardLanguage = keyboardLanguage;
    }
}
