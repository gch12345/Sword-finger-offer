package Tencent;

import java.util.List;
import java.util.Map;

/**
 * 1) 洗牌算法：对52张牌洗牌，要求尽量洗乱，而且原牌不能在原位置上重复
 * void ShuffleArray(int array[], int len)
 *
 * 2) 现在有n个微信群，每个群里面有2到m个人，设计一个数据结构存储这些信息，要求该结构能快速找出每一个人所在的所有的群Id。
 *
 * 3) 数组a[N]，存放了数字1至N-1，其中某个数字重复一次。写一个函数，找出被重复的数字。时间复杂度必须为O(N), 空间复杂度不能是O[N]。 函数原型：
 * int find(int a[], int N)
 *
 * 4) 现在有一个微信群，里面有n个人，每个人的id用整数int标示，现在要求找出id是对称数字的人出来，如3， 121， 12321。 请实现改查找函数，不能把整数转为字符串来判断。
 * //返回 1：对称； 0： 不对称
 * int ismirror(int value)
 *
 * 5) 给定一个字符串，如“1234”，请实现一个函数，把这个字符串转成10进制整型，不能用系统函数
 * int atoi(char *str)
 *
 * 6) 有一个二叉树，每个节点的值是一个整数。写一个函数，判断这棵树中是否存在从根到叶子节点的一个路径，这个路径上所有节点之和为某一个值。存在返回1， 否则返回0。
 * struct TreeNode
 * {
 * int value;
 * 	struct TreeNode *left, *right;
 * };
 * int haspath(struct TreeNode *root, int value)
 */
class Treenode {
    int val;
    Treenode left;
    Treenode right;
}
public class Main {
    //1.
    void ShuffleArray(int array[], int len) {
        int newArr[] = new int[len];
        for(int i = 0; i < len; i++) {
            int index = (int)Math.random() % len;
            while (newArr[index] != 0 && index != i) {
                index = (int)Math.random() % len;
            }
            newArr[index] = array[i];
        }
    }
    //2.
    //Map<String, List<Integer>>

    //3.
    int find(int a[], int N) {
        int ret = -1;
        for (int i = 0; i < a.length; i++) {
            int num = a[i];
            if (num != i + 1) {
                int temp = a[i];
                a[i] = a[num - 1];
                a[num - 1] = temp;
            } else if (num == a[num - 1]){
                ret = num;
                break;
            }
        }
        return ret;
    }
    //4.
    int ismirror(int value) {
        if (value < 10) {
            return 1;
        }
        int num1 = value;
        int num2 = 0;
        while (value > 0) {
            num2 = num2 * 10 + value % 10;
            value = value / 10;
        }
        if (num2 == num1) {
            return 1;
        }
        return 0;
    }
    //5.
    int atoi(char[] str) {
        if (str == null) {
            return 0;
        }
        int ret = 0;
        for (int i = 0; i < str.length; i++) {
            ret = ret * 10 + str[i] - '0';
        }
        return ret;
    }
    //6.
    int haspath(Treenode root, int val){
        boolean ret = helper(root, 0, val);
        if (ret) {
            return 1;
        }
        return 0;
    }
    boolean helper(Treenode root, int num, int val) {
        if (root == null) {
            return false;
        }
        if (num == val && root.left == null && root.right == null) {
           return true;
        }
        boolean left = helper(root.left, num + root.val, val);
        boolean right = helper(root.right, num + root.val, val);
        return left || right;
    }
}
