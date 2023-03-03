package definingclasses.pokemontrainer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Trainer> trainers = new LinkedHashMap<>();
        String input = sc.nextLine();

        while (!input.equals("Tournament")) {
            String[] inputArgs = input.split("\\s+");

            String trainerName = inputArgs[0];
            String pokemonName = inputArgs[2];
            String pokemonElement = inputArgs[2];
            int pokemonHealth = Integer.parseInt(inputArgs[3]);

            Pokemon currentPokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            if (!trainers.containsKey(trainerName)) {
                trainers.put(trainerName, new Trainer(trainerName));
            }
            trainers.get(trainerName).addToCollection(currentPokemon);

            input = sc.nextLine();
        }
        input = sc.nextLine();
        while (!input.equals("End")) {

            manipulatePokemons(input, trainers);

            input = sc.nextLine();
        }
        trainers
                .entrySet()
                .stream()
                .sorted((trainer1, trainer2) -> trainer2.getValue().getNumberOfBadges() - trainer1.getValue().getNumberOfBadges())
                .forEach(trainer -> System.out.println(trainer.getValue()));
    }

    private static void manipulatePokemons(String input, Map<String, Trainer> trainers) {
        for (Trainer trainer : trainers.values()) {
            boolean hasAtLeastOne = false;
            for (Pokemon pokemon : trainer.getCollection()) {
                if (pokemon.getElement().equals(input)) {
                    hasAtLeastOne = true;
                }
            }
            if (hasAtLeastOne) {
                trainer.increaseBadgeCount();
            } else {
                decreaseHealthOfAllPokemons(trainer);
                removeDeadPokemons(trainer);
            }
        }

    }

    private static void removeDeadPokemons(Trainer trainer) {
        for (int i = 0; i < trainer.getCollection().size(); i++) {
            if (trainer.getCollection().get(i).getHealth() <= 0) {
                trainer.getCollection().remove(i);
                i--;
            }
        }
    }

    private static void decreaseHealthOfAllPokemons(Trainer trainer) {
        for (Pokemon pokemon : trainer.getCollection()) {
            pokemon.decreaseHealth();
        }
    }
}