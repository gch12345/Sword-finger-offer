package CollectionDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Demo {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        System.out.println(list.isEmpty());
        list.add("a");
        list.add("a");
        list.add("a");
        System.out.println(list.isEmpty());
        list.remove("a");
        System.out.println(list.size());
        Object[] arr = list.toArray();
        System.out.println(Arrays.toString(arr));
        list.clear();
        System.out.println(list);
    }
}
