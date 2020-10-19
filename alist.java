import java.util.ArrayList;
import java.util.List;

public class alist {
    public static void main(String[] args) {
        List<Object> aList = new ArrayList<>();
        aList.add(0, 1);
        aList.add(1, 2.4);
        aList.add(2, 'A');
        aList.add(3, "Hello");

        for (Object i : aList) {
            System.out.println(i);
        }
    }
}
