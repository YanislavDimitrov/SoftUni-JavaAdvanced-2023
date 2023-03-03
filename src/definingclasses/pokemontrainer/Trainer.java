package definingclasses.pokemontrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> collection;

    public Trainer(String name) {
        this.name = name;
        this.numberOfBadges = 0;
        this.collection = new ArrayList<>();
    }

    public void addToCollection(Pokemon pokemon) {
        this.collection.add(pokemon);
    }

    public List<Pokemon> getCollection() {
        return this.collection;
    }

    public void increaseBadgeCount() {
        this.numberOfBadges++;
    }

    public int getNumberOfBadges() {
        return this.numberOfBadges;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.numberOfBadges, this.collection.size());
    }
}
