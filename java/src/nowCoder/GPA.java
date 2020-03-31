package nowCoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GPA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            List<Integer> credits = new ArrayList<>();
            List<Integer> grades = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                credits.add(sc.nextInt());
            }
            for (int i = 0; i < n; i++) {
                grades.add(sc.nextInt());
            }
            double credit = 0;
            double grade = 0;
            for (int i = 0; i < n; i++) {
                double Credit = credits.get(i);
                double Grade = grades.get(i);
                credit += Credit;
                if (Grade >= 60 && Grade <= 63) {
                    grade = grade + 1 * Credit;
                } else if (Grade >= 64 && Grade <= 67) {
                    grade = grade + 1.5 * Credit;
                } else if (Grade >= 68 && Grade <= 71) {
                    grade = grade + 2 * Credit;
                } else if (Grade >= 72 && Grade <= 74) {
                    grade = grade + 2.3 * Credit;
                } else if (Grade >= 75 && Grade <= 77) {
                    grade = grade + 2.7 * Credit;
                } else if (Grade >= 78 && Grade <= 81) {
                    grade = grade + 3 * Credit;
                } else if (Grade >= 82 && Grade <= 84) {
                    grade = grade + 3.3 * Credit;
                } else if (Grade >= 85 && Grade <= 89) {
                    grade = grade + 3.7 * Credit;
                } else if (Grade >= 90 && Grade <= 100) {
                    grade = grade + 4 * Credit;
                }
            }
            double GPA = grade / credit;
            System.out.printf("%.2f", GPA);
        }
    }

}
