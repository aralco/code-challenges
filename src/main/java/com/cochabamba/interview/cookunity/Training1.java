import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Training1 {
    static int numberST = 10;
    public static void main(String[] args) {
        final int number = 12;
        System.out.println(number);
        numberST = numberST+1;
        System.out.println(numberST);
        List<Integer> list = Arrays.asList(4, 6, 2, 9, 1);
        System.out.println(list);
        Collections.sort(list, (o1, o2) -> {
            return o1.compareTo(o2);
        });
        System.out.println(list);
    }
}
