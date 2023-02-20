package stacksandqueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PoisonousPlants {
    public static class Garden {
        private List<Plant> plants;

        public Garden() {
            this.plants = new ArrayList<>();
        }

        public void addPlant(Plant plant) {
            this.plants.add(plant);
        }

        public void clearDeadPlants() {
            this.plants = plants
                    .stream()
                    .filter(p -> p.getPesticideLevel() >= 0)
                    .collect(Collectors.toList());
        }

        public boolean containsDeadPlants() {
            for (Plant plant : this.plants) {
                if (plant.getPesticideLevel() == -1) {
                    return true;
                }
            }
            return false;
        }

        public void killWeakerPlants() {
            for (int i = this.plants.size()-1; i >= 1; i--) {
                Plant left = this.plants.get(i - 1);
                Plant current = this.plants.get(i);

                if (left.getPesticideLevel() < current.getPesticideLevel()) {
                    current.killPlant();
                }
            }
        }
    }
    public static class Plant {
        private int pesticideLevel;

        public Plant(int pesticideLevel) {
            this.pesticideLevel = pesticideLevel;
        }

        public int getPesticideLevel() {
            return this.pesticideLevel;
        }

        public void killPlant() {
            this.pesticideLevel = -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());


        Garden garden = new Garden();
        int[] pesticideLevels = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < n; i++) {
            garden.addPlant(new Plant(pesticideLevels[i]));
        }
        int daysCount = 0;

        while (true) {
            garden.killWeakerPlants();
            if (!garden.containsDeadPlants()) {
                break;
            } else {
                garden.clearDeadPlants();
                daysCount++;
            }
        }
        System.out.println(daysCount);
    }
}
