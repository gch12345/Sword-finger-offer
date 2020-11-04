package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main3 {
    public static void main(String[] args) {
//        1）指出下列输出true or false
////        a）String x = "string"; String y = "string"; String z = new String("string");
////<a>System.out.println</a>(x==y); // true
////<a>System.out.println</a>(x==z);  // false
////<a>System.out.println</a>(<a>x.equals</a>(y));  // true
////<a>System.out.println</a>(<a>x.equals</a>(z));  // true
////        b）class Cat{public Cat(String name){<a>this.name</a> = name;}private String name;}
////        Cat c1 = new Cat("王磊"); Cat c2 = new Cat("王磊");
////<a>System.out.println</a>(<a>c1.equals</a>(c2)); //false
////        c）String s1 = new String("老王"); String s2 = new String("老王");
////<a>System.out.println</a>(<a>s1.equals</a>(s2)); // true
        solution(100, 20);
    }

    public static void solution(double money, int num) {
        List<Double> list = new ArrayList<>();
        double count = 0;
        for (int i = 0; i < num; i++) {
            if (money - count == (num - i) * 0.01) {
                list.add(0.01);
                continue;
            }
            int ran = random(money);
            double cur = 0.01 * ran;
            while (cur > money - count - (num - i) * 0.01) {
                cur = 0.01 * random(money);
            }
            count += cur;
            list.add(cur);
        }
        for (double x : list) {
            System.out.println(x + " ");
        }
    }

    private static int random(double money) {
        Random random = new Random(System.currentTimeMillis());
        int ran = random.nextInt((int)money * 100);
        while (ran <= 0) {
            ran = random.nextInt();
        }
        return ran;
    }

    /**
     * 每个排队的客户都有2个属性，分别是a和b，类型(取值范围)是int32。
     * 假设有n（int32）个客户过来排队，每个排队客户的当前位置为i，单客户的满意度值为：a*i+b*(n-i)
     */
    public static void solution0(int[][] arr, int n) {
        for (int i = 1; i < n; i++) {
            int a = arr[i][0];
            int b = arr[i][1];
            int cur = a * i + b * (n - i);
            int j = i - 1;
            for (; j >= 0; j--) {
                int A = arr[j][0];
                int B = arr[j][1];
                int Cur = A * j + B * (n - j);
                if (Cur + (A * (j + 1) + B * (n - j - 1)) < cur + a * (i - 1) + b * (n - i + 1)) {
                    arr[j + 1][0] = A;
                    arr[j + 1][1] = B;
                }
            }
            arr[j + 1][0] = a;
            arr[j + 1][1] = b;
        }
    }

    /**
     * 2）	设计一组数据库表（一张或多张表），结合场景考虑合理性，并给出设计思路的文字解释。背景信息如下：
     * A网站有一个用户系统，用户注册要求必填手机号（不可重复），选填邮箱、年龄、性别、姓名，同时由于业务特殊性，手机号支持注册后更换。
     * 系统中，每个用户存在一种身份标识，系统创建初期标识分为：普通用户、初级会员、高级会员、版主、系统管理员、特邀嘉宾，后续标识会做扩展。每个用户可能存在多种标识身份。
     * 网站预估上线半年后，用户日活和月活量级分别是50w和700w，注册用户2000w。
     */
    /**
     * 用户表 {
     *     手机号（唯一）
     *     id （主键）
     *     邮箱
     *     年龄
     *     性别
     *     姓名
     * }
     *
     * 身份标识表 {
     *     普通用户
     *     初级会员
     *     。。。。
     * }
     *
     * 用户身份表 {
     *     id（外键）
     *     用户身份
     * }
     */
}
