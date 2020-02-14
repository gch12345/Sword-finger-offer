package IOdeom;

import org.junit.Test;

import java.io.*;

/**
 * 1.IO流操作，使用完毕需要关闭资源
 * 2.任何流，读取完的地方不能再次读取
 * 3.使用Buffered缓冲流， 需要刷新
 */

public class FileIOTest {
    @Test
    public void test0() throws IOException {
        File file = new File("D:\\Sword-finger-offer\\java\\out\\production\\java\\assd");
        FileInputStream f = new FileInputStream(file);
        InputStreamReader i = new InputStreamReader(f, "UTF-8");
        BufferedReader b = new BufferedReader(i);
//        System.out.println(b.readLine());
//        System.out.println(b.readLine());
        String line;
        while ((line = b.readLine()) != null) {
            System.out.println(line);
        }
    }

    @Test
    public void test1() throws IOException{
        File file = new File("D:\\Sword-finger-offer\\java\\out\\production\\java\\assd");
        FileInputStream f = new FileInputStream(file);
        InputStreamReader i = new InputStreamReader(f, "UTF-8");
        BufferedReader b = new BufferedReader(i);
        char[] chars = new char[2];
        int index;
        // 读取到数据， —1 表示读完了
        while ((index = b.read(chars)) != -1) {
            System.out.println(new String(chars, 0 ,index));
        }
    }

    @Test
    public void Test2() throws IOException {
        File file = new File("D:\\Sword-finger-offer\\java\\out\\production\\java\\assd");
        FileInputStream f = new FileInputStream(file);
        byte[] bytes = new byte[1024];
        int index;
        while ((index = f.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0 ,index));
        }
    }

    @Test
    public void Test3() throws IOException {
        File file = new File("D:\\Sword-finger-offer\\java\\out\\production\\java\\assd");
        FileOutputStream f = new FileOutputStream(file);
        OutputStreamWriter o = new OutputStreamWriter(f, "UTF-8");
        BufferedWriter w = new BufferedWriter(o);
        w.write("Hello");
        System.out.println();
        w.write("开发");
        w.flush();
    }


}
