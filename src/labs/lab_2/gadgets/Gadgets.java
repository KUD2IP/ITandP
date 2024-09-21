package labs.lab_2.gadgets;

public abstract class Gadgets {
    private int power;
    private boolean on = false;

    public Gadgets() {
    }

    public Gadgets(int power) {
        this.power = power;
    }

    public abstract void on();
    public abstract void off();
    public abstract void charge();

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
