package definingclasses.rawdata;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<Car> cars = new ArrayList<>();

        //Processing inputs and filling cars list
        for (int i = 0; i < n; i++) {
            String[] inputArgs = sc.nextLine().split("\\s+");
            String model = inputArgs[0];
            int engineSpeed = Integer.parseInt(inputArgs[1]);
            int enginePower = Integer.parseInt(inputArgs[2]);
            int cargoWeight = Integer.parseInt(inputArgs[3]);
            String cargoType = inputArgs[4];

            double tire1Pressure = Double.parseDouble(inputArgs[5]);
            int tire1age = Integer.parseInt(inputArgs[6]);
            double tire2Pressure = Double.parseDouble(inputArgs[7]);
            int tire2age = Integer.parseInt(inputArgs[8]);
            double tire3Pressure = Double.parseDouble(inputArgs[9]);
            int tire3age = Integer.parseInt(inputArgs[10]);
            double tire4Pressure = Double.parseDouble(inputArgs[11]);
            int tire4age = Integer.parseInt(inputArgs[12]);

            Engine currentEngine = new Engine(engineSpeed, enginePower);
            Cargo currentCargo = new Cargo(cargoWeight, cargoType);
            Tire[] tires = new Tire[]{
                    new Tire(tire1Pressure, tire1age),
                    new Tire(tire2Pressure, tire2age),
                    new Tire(tire3Pressure, tire3age),
                    new Tire(tire4Pressure, tire4age)
            };

            cars.add(new Car(model, currentEngine, currentCargo, tires));
        }

        String cargoType = sc.nextLine();

        if (cargoType.equals("fragile")) {
            printFragile(cars);
        } else {
            printFlamable(cars);
        }
    }

    private static void printFlamable(List<Car> cars) {
        cars
                .stream()
                .filter(car -> car.getCargo().getCargoType().equals("flamable"))
                .filter(car -> car.getEngine().getEnginePower()>250)
                .forEach(car -> System.out.println(car.getModel()));
    }

    private static void printFragile(List<Car> cars) {
        cars
                .stream()
                .filter(car -> car.getCargo().getCargoType().equals("fragile"))
                .filter(car -> {
                    for (Tire tire : car.getTires()) {
                        if (tire.getTirePressure() < 1) {
                            return true;
                        }
                    }
                    return false;
                })
                .forEach(car -> System.out.println(car.getModel()));
    }
}