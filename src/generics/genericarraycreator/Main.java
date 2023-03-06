package generics.genericarraycreator;

public class Main {
    public static void main(String[] args) {
//        Integer[] arr = ArrayCreator.create(10, 5);
        Integer[] arr1 = ArrayCreator.create(Integer.class, 10, 5);

        System.out.println();
    }
}