package definingclasses.google;

public class Parent {
    private String name;
    private String birthday;

    public Parent(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return this.name;
    }

    public String getBirthday() {
        return this.birthday;
    }
}
