package Holiday;

import org.junit.Test;

public class TEST {
    @Test
    public void test1() {
        int x = 20;
        int y = 5;
        System.out.println(x + y + "" + x + y + y);
    }
//    public static void main(String[] args) {//2
//        System.out.println("value="+switchit(4));//3
//    }//4
    @Test
    public void test2() {
        int num = 10;
        System.out.println(test(num));
    }
    public static int test(int b){
        try {
            b += 10;
            return b;
        }catch(RuntimeException e){
        }catch(Exception e2){
        } finally{
            b += 10;
            return b;
        }
    }
    public static int switchit(int x) {
        int j=1;
        switch (x) {
            case 1:j++;
            case 2:j++;
            case 3:j++;
            case 4:j++;
            case 5:j++;
            default:j++;
        }
        return j+x;
    }

    String str=new String("hello");
    char[]ch={'a','b'};
    public static void main(String args[]){
        TEST ex=new TEST();
        ex.change(ex.str,ex.ch);
        System.out.print(ex.str+" and ");
        System.out.print(ex.ch);
    }
    public void change(String str,char ch[]){
        str="test ok";
        ch[0]='c';
    }
}
