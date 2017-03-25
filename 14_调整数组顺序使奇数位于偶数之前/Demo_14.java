/**
 * 问题描述：输入一个整数数组，实现一个函数来调整该数组中数字的顺序
 * 使得所有奇数位于偶数之前
 * 解决思路：设定两个指针分别指向数组的首尾，然后向中间移动两个指针
 * 在保证首指针在尾指针前面的情况下，当首指针指向偶数，尾指针指向奇数的情况下，交换两个指针指向的数字
 */

public class Demo_14 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        Demo_14 demo = new Demo_14();
        int[] newArray = demo.Reorder(array);
        for (int i = 0; i < newArray.length; i++) {
            System.out.println(newArray[i]);
        }
    }

    public int[] Reorder(int[] array) {
        int length = array.length;   // 数组长度
        int index_fore = 0;
        int index_back = length - 1;

        while (index_fore < index_back) {
            while ((array[index_fore] & 0x1) != 0) {
                index_fore++;
            }

            while ((array[index_back] & 0x1) == 0) {
                index_back--;
            }

            if (index_fore < index_back) {
                int tmp = array[index_fore];
                array[index_fore] = array[index_back];
                array[index_back] = tmp;
            }
        }
        return array;
    }
}