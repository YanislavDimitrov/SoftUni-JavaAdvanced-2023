package definingclasses.google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Child> children;
    private List<Parent> parents;
    private List<Pokemon> pokemons;

    public Person(String name) {
        this.name = name;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }


    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void addParent(Parent parent) {
        this.parents.add(parent);
    }

    public void addChild(Child child) {
        this.children.add(child);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return this.company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Child> getChildren() {
        return this.children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public List<Parent> getParents() {
        return this.parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.name).append(System.lineSeparator());
        builder.append("Company:").append(System.lineSeparator());
        if (this.company != null) {
            builder.append(String.format("%s %s %.2f", this.company.getName(), this.company.getDepartment(), this.company.getSalary())).append(System.lineSeparator());
        }
        builder.append("Car:").append(System.lineSeparator());
        if (this.car != null) {
            builder.append(String.format("%s %d", this.car.getModel(), this.car.getSpeed())).append(System.lineSeparator());
        }
        builder.append("Pokemon:").append(System.lineSeparator());
        if (this.pokemons.size() > 0) {
            for (Pokemon pokemon : this.pokemons) {
                builder.append(String.format("%s %s", pokemon.getName(), pokemon.getType())).append(System.lineSeparator());
            }
        }
        builder.append("Parents:").append(System.lineSeparator());
        if (this.parents.size() > 0) {
            for (Parent parent : this.parents) {
                builder.append(String.format("%s %s", parent.getName(), parent.getBirthday())).append(System.lineSeparator());
            }
        }
        builder.append("Children:").append(System.lineSeparator());
        if (this.children.size() > 0) {
            for (Child child : this.children) {
                builder.append(String.format("%s %s", child.getName(), child.getBirthday())).append(System.lineSeparator());
            }
        }
        return builder.toString();
    }
}
