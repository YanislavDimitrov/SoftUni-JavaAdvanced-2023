package generics.genericscale;

public class Main {
    public static void main(String[] args) {
        Scale<Integer> scale = new Scale<>(10, 20);
        System.out.println(scale.getHeavier());
    }
}