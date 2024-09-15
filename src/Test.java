import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list = List.of(List.of(), List.of(), List.of(1, 2, 3));
        list.forEach(System.out::println);
        String str = "";
        str.isBlank();
        Integer[] intArray = new Integer[10];
        intArray[1] = 10;
    }
}
