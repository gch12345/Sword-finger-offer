package MapDemo;

import java.util.HashMap;
import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        System.out.println(map.size());
        System.out.println(map.get("1"));
        System.out.println(map.getOrDefault("1", "11"));
        map.put("1", "11");
        map.put("1", "111");
        map.put("11", "111");
        System.out.println(map.containsKey("2"));
        System.out.println(map.containsValue("111"));
        System.out.println(map.size());
        System.out.println(map.entrySet());
        for (Map.Entry<String, String> e: map.entrySet()) {
            System.out.println("Key = " + e.getKey() + " Value = " + e.getValue());
        }
        System.out.println(map);
    }
}
