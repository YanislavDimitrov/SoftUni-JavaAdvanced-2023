package definingclasses.catlady;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Cat> cats = new ArrayList<>();

        String input = sc.nextLine();

        while (!input.equals("End")) {
            String[] inputArgs = input.split("\\s+");
            String breed = inputArgs[0];
            String name = inputArgs[1];

            if (breed.equals("Cymric")) {
                double furLength = Double.parseDouble(inputArgs[2]);
                cats.add(new Cymric(name, furLength));
            } else if (breed.equals("Siamese")) {
                double earSize = Double.parseDouble(inputArgs[2]);
                cats.add(new Siamese(name, earSize));
            } else {
                double decibels = Double.parseDouble(inputArgs[2]);
                cats.add(new StreetExtraordinaire(name, decibels));
            }
            input = sc.nextLine();
        }

        input = sc.nextLine();
        String finalInput = input;
        cats.stream().filter(cat -> cat.getName().equals(finalInput)).forEach(cat -> System.out.println(cat));
    }
}