package definingclasses.Constructors;

public class Car {
    private String brand;
    private String model;
    private int horsePower;

    public String getBrand() {
        return brand;
    }

    public Car() {
        this.brand = "unknown";
        this.model = "unknown";
        this.horsePower = -1;
    }

    public Car(String brand) {
        this();
        this.brand = brand;
    }

    public Car(String brand, String model) {
        this(brand);
        this.model = model;
    }

    public Car(String brand, String model, int horsePower) {
        this(brand, model);
        this.horsePower = horsePower;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String carInfo() {
        return String.format("The car is: %s %s - %d HP.", this.getBrand(), this.getModel(), this.getHorsePower());
    }
}
