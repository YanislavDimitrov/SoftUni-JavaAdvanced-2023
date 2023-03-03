package definingclasses.carsalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Engine> engines = new HashMap<>();
        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());

        //Populate map with Engines
        for (int i = 0; i < n; i++) {
            String[] inputArgs = sc.nextLine().split("\\s+");
            String model = inputArgs[0];
            int power = Integer.parseInt(inputArgs[1]);
            Engine currentEngine;

            if (inputArgs.length == 2) {
                currentEngine = new Engine(model, power);
            } else if (inputArgs.length == 3) {
                if (Character.isLetter(inputArgs[2].charAt(0))) {
                    String efficiency = inputArgs[2];
                    currentEngine = new Engine(model, power, efficiency);
                } else {
                    int displacement = Integer.parseInt(inputArgs[2]);
                    currentEngine = new Engine(model, power, displacement);
                }
            } else {
                int displacement = Integer.parseInt(inputArgs[2]);
                String efficiency = inputArgs[3];
                currentEngine = new Engine(model, power, displacement, efficiency);
            }

            engines.put(currentEngine.getModel(), currentEngine);
        }

        n = Integer.parseInt(sc.nextLine());

        //Populate map with Cars
        for (int i = 0; i < n; i++) {
            String[] inputArgs = sc.nextLine().split("\\s+");
            String model = inputArgs[0];
            Engine engine = engines.get(inputArgs[1]);

            Car currentCar;

            if (inputArgs.length == 2) {
                currentCar = new Car(model, engine);
            } else if (inputArgs.length == 3) {
                if (Character.isLetter(inputArgs[2].charAt(0))) {
                    String color = inputArgs[2];
                    currentCar = new Car(model, engine, color);
                } else {
                    int weight = Integer.parseInt(inputArgs[2]);
                    currentCar = new Car(model, engine, weight);
                }
            } else {
                int weight = Integer.parseInt(inputArgs[2]);
                String color = inputArgs[3];
                currentCar = new Car(model, engine, weight, color);
            }
            cars.add(currentCar);
        }

        StringBuilder builder = new StringBuilder();
        for (Car car : cars) {
            builder.append(car.getModel()).append(":").append(System.lineSeparator());
            builder.append(car).append(System.lineSeparator());

        }
        System.out.println(builder);
    }
}