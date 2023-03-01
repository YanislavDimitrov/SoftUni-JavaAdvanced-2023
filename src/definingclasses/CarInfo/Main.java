import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Car car = new Car();
            String[] inputArgs = sc.nextLine().split("\\s+");
            car.setBrand(inputArgs[0]);
            car.setModel(inputArgs[1]);
            car.setHorsePower(Integer.parseInt(inputArgs[2]));

            cars.add(car);
        }

        for (Car car : cars) {
            System.out.println(car.carInfo());
        }
    }
}