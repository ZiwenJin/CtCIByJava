package Q79CircularArray;

/**
 * Created by ziwen on 14/11/2016.
 */
public class Test79 {
    public static void main(String[] args) {
        int size = 10;
        CircularArray<String> array = new CircularArray<>(size);
        for (int i=0; i<size; i++) {
            array.set(i, String.valueOf(i));
        }

        array.rotate(3);
        for (int i=0; i<size; i++) {
            System.out.print(array.get(i) + ", ");
        }
        System.out.println();

        array.rotate(2);
        for (String s: array) {
            System.out.print(s + ", ");
        }
    }
}
