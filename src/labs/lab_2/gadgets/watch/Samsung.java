package labs.lab_2.gadgets.watch;

public class Samsung extends SmartWatch {
    private String model;
    private int price;

    public Samsung(int power) {
        super(power);
    }

    public Samsung(String model, int price) {
        this.model = model;
        this.price = price;
    }

    public Samsung(int power, int price, String model) {
        super(power);
        this.price = price;
        this.model = model;
    }

    @Override
    public void charge() {
        System.out.println(model + " is charging...");
        Thread powerWatch = new Thread();
        powerWatch.start();
        for (int i = super.getPower(); i <= 100; i++) {
            try {
                if(super.isOn()) {
                    Thread.sleep(300);
                }else{
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i + "%");
            super.setPower(i);
        }
        System.out.println(model + " is charged!");
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
        return "Samsung{" +
                "model='" + model + '\'' +
                ", price=" + price + " rub" +
                ", power=" + super.getPower() +
                ", date=" + super.getDate() +
                '}';
    }
}
