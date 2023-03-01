import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] inputArgs = sc.nextLine().split("\\s+");

            if (inputArgs.length > 1) {
                cars.add(new Car(inputArgs[0], inputArgs[1], Integer.parseInt(inputArgs[2])));
            } else {
                cars.add(new Car(inputArgs[0]));
            }
        }

        for (Car car : cars) {
            System.out.println(car.carInfo());
        }
    }
}