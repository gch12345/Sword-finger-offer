import java.lang.reflect.Field;

public class reflec {
    public static void main(String[] args) {
        String str = "hehe";

        try {
            // 1. 获取到 value 这个字段对应的对象.
            Field valueField = String.class.getDeclaredField("value");
            // 2. 让 value 对应的对象可以被访问到, 强行破坏封装
            valueField.setAccessible(true);
            // 3. 根据 valueField 对象和 str 对象, 找到 str 中的 value 数组
            char[] value = (char[])valueField.get(str);
            // 4. 修改 value
            value[0] = 'a';

            System.out.println(str);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
