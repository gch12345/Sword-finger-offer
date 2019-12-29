package operatingSystem.MemoryAllocation;

import java.util.LinkedList;
import java.util.Scanner;

public class Build {
    public LinkedList BuildBlank() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入空白区, 以#结束");
        while (!sc.hasNext("#")) {
            linkedList.add(sc.nextInt());
        }
        return linkedList;
    }

    public LinkedList BuildProcess() {
        return null;
    }
}
