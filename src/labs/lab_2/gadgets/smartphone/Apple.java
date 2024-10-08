package labs.lab_2.gadgets.smartphone;

public class Apple extends Smartphone {
    private String model;
    private String color;
    private int price;

    public Apple() {
    }

    public Apple(int power) {
        super(power);
    }

    public Apple(int power, String model, String color, int price) {
        super(power);
        this.model = model;
        this.color = color;
        this.price = price;
    }

    @Override
    public void charge() {
        System.out.println( model + " is charging...");
        Thread powerApple = new Thread();
        powerApple.start();
        for (int i = getPower(); i <= 100; i++) {
            try {
                if(super.isOn()) {
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
        System.out.println(model + " is charged!");
    }

    @Override
    public void downloadApp(String ... app) {
        StringBuilder apps = new StringBuilder();
        for (String appN : app) {
            apps.append(appN).append(" ");
        }
        setApps(apps);
        System.out.println(apps.toString() + " is downloaded to " + model);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price + " rub" +
                ", apps=" + getApps() +
                ", power=" + super.getPower() +
                ", on=" + super.isOn() +
                '}';
    }
}
