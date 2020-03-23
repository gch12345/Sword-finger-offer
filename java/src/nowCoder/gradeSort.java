package nowCoder;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

class student {
    String name;
    int grade;
}

public class gradeSort{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int bool = sc.nextInt();
            LinkedList<student> link = new LinkedList<>();
            for (int i = 0; i < num; i++) {
                String name = sc.next();
                int grade = sc.nextInt();
                student stu = new student();
                stu.name = name;
                stu.grade = grade;
                if (link.size() == 0) {
                    link.add(stu);
                } else if (link.get(link.size() - 1).grade < stu.grade) {
                    link.add(stu);
                } else {
                    for (int j = 0; j < link.size(); j++) {
                        if (link.get(j).grade >= stu.grade) {
                            link.add(j, stu);
                            break;
                        }
                    }
                }
            }
            if (bool == 0) {
                for (int i = link.size() - 1; i >= 0; i--) {
                    student stu = link.get(i);
                    System.out.println(stu.name + " " + stu.grade);
                }
            } else {
                for (student stu : link) {
                    System.out.println(stu.name + " " + stu.grade);
                }
            }
        }
    }
}
