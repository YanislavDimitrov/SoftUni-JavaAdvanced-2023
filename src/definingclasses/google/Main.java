package definingclasses.google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Map<String, Person> people = new HashMap<>();

        while (!input.equals("End")) {
            String[] inputArgs = input.split("\\s+");
            String name = inputArgs[0];
            String infoType = inputArgs[1];

            Person currentPerson;
            switch (infoType) {
                case "company":
                    String companyName = inputArgs[2];
                    String department = inputArgs[3];
                    double salary = Double.parseDouble(inputArgs[4]);
                    Company currCompany = new Company(companyName, department, salary);
                    if (!people.containsKey(name)) {
                        currentPerson = new Person(name);
                        people.put(name, currentPerson);
                    }
                    people.get(name).setCompany(currCompany);

                    break;
                case "pokemon":
                    String pokemonName = inputArgs[2];
                    String pokemonType = inputArgs[3];
                    Pokemon currPokemon = new Pokemon(pokemonName, pokemonType);
                    if (!people.containsKey(name)) {
                        currentPerson = new Person(name);
                        people.put(name, currentPerson);
                    }
                    people.get(name).addPokemon(currPokemon);
                    break;
                case "parents":
                    String parentName = inputArgs[2];
                    String parentBirthday = inputArgs[3];
                    Parent currParent = new Parent(parentName, parentBirthday);
                    if (!people.containsKey(name)) {
                        currentPerson = new Person(name);
                        people.put(name, currentPerson);
                    }
                    people.get(name).addParent(currParent);
                    break;
                case "children":
                    String childName = inputArgs[2];
                    String childBirthday = inputArgs[3];
                    Child currChild = new Child(childName, childBirthday);
                    if (!people.containsKey(name)) {
                        currentPerson = new Person(name);
                        people.put(name, currentPerson);
                    }
                    people.get(name).addChild(currChild);
                    break;
                case "car":
                    String carModel = inputArgs[2];
                    int carSpeed = Integer.parseInt(inputArgs[3]);
                    Car currCar = new Car(carModel, carSpeed);
                    if (!people.containsKey(name)) {
                        currentPerson = new Person(name);
                        people.put(name, currentPerson);
                    }
                    people.get(name).setCar(currCar);
                    break;
            }
            input = sc.nextLine();
        }

        input = sc.nextLine();

        System.out.print(people.get(input));
    }
}