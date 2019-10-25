package libraryManage.user;

import libraryManage.operation.*;

import java.util.Scanner;


public class Admin extends User{
    public Admin(String name) {
        super(name);
        // 在这里构造 operation 数组
        // 我们让数组中 operation 对象的顺序和菜单中的序号相匹配
        operations = new IOperation[]{
                new ExitOperation(),
                new FindOperation(),
                new AddOperation(),
                new DelectOperation(),
                new PrintfAllOperation(),
        };
    }

    @Override
    public int menu() {
        System.out.println("============");
        System.out.println("hello " + name);
        System.out.println("1. 查找书籍");
        System.out.println("2. 增加书籍");
        System.out.println("3. 删除书籍");
        System.out.println("4. 打印所有信息");
        System.out.println("0. 退出");
        System.out.println("============");
        System.out.println("请输入您的选择: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        // close 本质上是在关闭 System.in
        // 由于后面还需要用到 System.in, 此处不能盲目关闭.
        // scanner.close();
        return choice;
    }
}
