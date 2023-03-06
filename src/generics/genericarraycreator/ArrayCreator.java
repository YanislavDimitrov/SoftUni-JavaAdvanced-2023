package generics.genericarraycreator;

import java.lang.reflect.Array;

public class ArrayCreator<T> {

    public static <T> T[] create(int length, T item) {
        T[] array = (T[]) new Object[length];

        for (int i = 0; i < length; i++) {
            array[i] = item;
        }
        return array;
    }

    public static <T> T[] create(Class<Integer> clazz, int length, T item) {
        T[] array = (T[]) Array.newInstance(clazz, length);

        for (int i = 0; i < length; i++) {
            array[i] = item;
        }
        return array;
    }
}
