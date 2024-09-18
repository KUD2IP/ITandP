package labs.lab_2.gadgets.laptop;

public class Apple extends Laptop {
    private String model;
    private int price;

    public Apple(int power) {
        super(power);
    }

    public Apple(String model, int price) {
        this.model = model;
        this.price = price;
    }

    public Apple(int power, String model, int price) {
        super(power);
        this.model = model;
        this.price = price;
    }

    @Override
    public void charge() {
        Thread powerAppleLaptop = new Thread();
        powerAppleLaptop.start();
        for (int i = super.getPower(); i <= 100; i++) {
            try {
                if(super.isOn()) {
                    Thread.sleep(800);
                }else{
                    Thread.sleep(400);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i + "%");
            super.setPower(i);
        }
        System.out.println(model + " is charged!");
    }

    @Override
    public void downloadOperatingSystem(String os) {

        if(os.equalsIgnoreCase("Windows") || os.equalsIgnoreCase("Linux")) {
            System.out.println(model + " does not have an operating system!");
        }else if(os.equalsIgnoreCase("MacOS")) {
            System.out.println("The OS on " + model + " is " + os + "!");
            super.setOperatingSystem(os);
        }else{
            System.out.println(os + " is not an operating system!");
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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
                ", price=" + price + " rub" +
                ", power=" + super.getPower() +
                ", operatingSystem='" + super.getOperatingSystem() + '\'' +
                ", on=" + super.isOn() +
                '}';
    }
}
