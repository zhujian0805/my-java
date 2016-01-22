import java.util.Arrays;
import java.util.List;
public class MainClass {
      public static void main(String[] a) {
              String str[] = new String[] { "A", "B", "C", "D" };
              List list = Arrays.asList(str);
                  System.out.println(list.contains("C"));
                    }
}
