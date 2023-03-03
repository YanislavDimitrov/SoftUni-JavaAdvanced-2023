package definingclasses.carsalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = -1;
        this.color = "n/a";
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
    }

    public Car(String model, Engine engine, int weight, String color) {
        this(model, engine);
        this.weight = weight;
        this.color = color;
    }

    public String getModel() {
        return this.model;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(this.engine.getModel()).append(":").append(System.lineSeparator());
        builder.append("Power: ").append(this.engine.getPower()).append(System.lineSeparator());
        builder.append("Displacement: ");
        if (this.engine.getDisplacement() == -1) {
            builder.append("n/a").append(System.lineSeparator());
        } else {
            builder.append(this.engine.getDisplacement()).append(System.lineSeparator());
        }
        builder.append("Efficiency: ").append(this.engine.getEfficiency()).append(System.lineSeparator());
        builder.append("Weight: ");
        if (this.weight == -1) {
            builder.append("n/a").append(System.lineSeparator());
        } else {
            builder.append(this.weight).append(System.lineSeparator());
        }
        builder.append("Color: ").append(this.color);
        return builder.toString();
    }
}
