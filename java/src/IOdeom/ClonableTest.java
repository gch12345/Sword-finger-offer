package IOdeom;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class ClonableTest {
    public static class Person1 implements Cloneable{
        private String name;
        private Integer age;

        public Person1(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person1{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
    @Test
    public void test() throws CloneNotSupportedException {
        Person1 old = new Person1("张三", 11);
        Person1 clone = (Person1) old.clone();
        old.age = 12;
        old.name = "ab";
        System.out.println(old);
        System.out.println(clone);
    }
}
