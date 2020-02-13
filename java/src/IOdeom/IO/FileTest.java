package IOdeom.IO;

import org.junit.Test;

import java.io.File;
import java.net.URL;

public class FileTest {
    public static void main(String[] args) {
        File file = new File("C:\\新建文件夹");
        File[] list = file.listFiles();
        for (File child : list) {
            System.out.println(child.getName());
        }
        childName(file);
    }
    private static void childName(File file) {
        if (file.isFile()) {
            return;
        }
        File[] files = file.listFiles();
        for (File x : files) {
            System.out.println(x.getName());
            childName(x);
        }
    }
    @Test
    public void test() {
        URL url = FileTest.class.getClassLoader().getResource("assd");
        System.out.println(url.getPath());
    }
}
