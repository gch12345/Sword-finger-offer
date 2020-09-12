package wangyi._2020_09_12;

import java.util.Scanner;

class node{
    int leftIndex = -1;
    int rightIndex = - 1;
    int num;
}

public class Main0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // a b c x y z
        while (sc.hasNext()) {
            String s = sc.next();
            helper(s);
            System.out.println(max);
        }
    }
    static int max = 0;
    public static void helper(String s) {
        if (s.length() == 0) {
            return;
        }
        node nodeA = new node();
        node nodeB = new node();
        node nodeC = new node();
        node nodeX = new node();
        node nodeY = new node();
        node nodeZ = new node();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                if (nodeA.leftIndex == -1) {
                    nodeA.leftIndex = i;
                    nodeA.rightIndex = i;
                } else {
                    nodeA.rightIndex = i;
                }
                nodeA.num++;
            } else if (ch == 'b') {
                if (nodeB.leftIndex == -1) {
                    nodeB.leftIndex = i;
                    nodeB.rightIndex = i;
                } else {
                    nodeB.rightIndex = i;
                }
                nodeB.num++;
            } else if (ch == 'c') {
                if (nodeC.leftIndex == -1) {
                    nodeC.leftIndex = i;
                    nodeC.rightIndex = i;
                } else {
                    nodeC.rightIndex = i;
                }
                nodeC.num++;
            } else if (ch == 'x') {
                if (nodeX.leftIndex == -1) {
                    nodeX.leftIndex = i;
                    nodeX.rightIndex = i;
                } else {
                    nodeX.rightIndex = i;
                }
                nodeX.num++;
            } else if (ch == 'y') {
                if (nodeY.leftIndex == -1) {
                    nodeY.leftIndex = i;
                    nodeY.rightIndex = i;
                } else {
                    nodeY.rightIndex = i;
                }
                nodeY.num++;
            } else if (ch == 'z') {
                if (nodeZ.leftIndex == -1) {
                    nodeZ.leftIndex = i;
                    nodeZ.rightIndex = i;
                } else {
                    nodeZ.rightIndex = i;
                }
                nodeZ.num++;
            }
        }
        if (nodeA.num % 2 != 0) {
            helper(s.substring(nodeA.leftIndex + 1));
            helper(s.substring(0, nodeA.rightIndex));
            return;
        } else if (nodeB.num % 2 != 0) {
            helper(s.substring(nodeB.leftIndex + 1));
            helper(s.substring(0, nodeB.rightIndex));
            return;
        } else if (nodeC.num % 2 != 0) {
            helper(s.substring(nodeC.leftIndex + 1));
            helper(s.substring(0, nodeC.rightIndex));
            return;
        } else if (nodeX.num % 2 != 0) {
            helper(s.substring(nodeX.leftIndex + 1));
            helper(s.substring(0, nodeX.rightIndex));
            return;
        } else if (nodeY.num % 2 != 0) {
            helper(s.substring(nodeY.leftIndex + 1));
            helper(s.substring(0, nodeY.rightIndex));
            return;
        } else if (nodeZ.num % 2 != 0) {
            helper(s.substring(nodeZ.leftIndex + 1));
            helper(s.substring(0, nodeZ.rightIndex));
            return;
        }
        if (s.length() > max) {
            max = s.length();
        }
    }
}
