/**
 * 升级版
 * 问题描述：输入一个整数数组，实现一个函数来调整该数组中数字的顺序
 * 使得所有奇数位于偶数之前，并且保持原奇偶数列顺序不变
 * 解决思路：比较好的一个思路，利用空间换时间
 * 遍历两遍数组，分别把偶数和奇数压进栈，倒着压进去，然后pop出来
 */
import java.util.Stack;

public class Demo_14_01 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        Demo_14_01 demo = new Demo_14_01();
        int[] newArray = demo.Reorder(array);
        for (int i = 0; i < newArray.length; i++) {
            System.out.println(newArray[i]);
        }
    }

    public int[] Reorder(int[] array) {
        Stack stack = new Stack();
        // 把偶数按倒序压进栈
        for (int i = array.length - 1; i >= 0; i--) {
            if ((array[i] & 0x1) == 0) {
                stack.push(array[i]);
            }
        }
        // 把奇数倒序压进栈
        for (int i = array.length - 1; i >= 0; i--) {
            if ((array[i] & 0x1) != 0) {
                stack.push(array[i]);
            }
        }
        // 再将栈内内容装入原数组
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)stack.pop();
        }
        return array;
    }
}