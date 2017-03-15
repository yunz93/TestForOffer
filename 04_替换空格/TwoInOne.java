/**
 * 将两个有序的数组归并，要求归并到其中比较大的数组，并保持有序
 */

public class TwoInOne {
    public static void main(String[] args) {
        int[] arr1 = new int[20];
        PrintArr(arr1);

        arr1[0] = 2;
        arr1[1] = 2;
        arr1[2] = 4;
        arr1[3] = 5;
        arr1[4] = 7;
        arr1[5] = 9;
        PrintArr(arr1);

        int[] arr2 = new int[]{2, 4, 6, 8, 10};

        sort(arr1, arr2);
        PrintArr(arr1);
    }

    private static void PrintArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int[] sort(int[] arr1, int[] arr2) {
        int length1 = 5;  // 数组1的数字长度
        int length2 = 5;  // 数组2的数字长度
        int lengthAll = length1 + length2;

        int q = lengthAll - 1;    // 指针q指向合并数组的尾端
        int p1 = length1 - 1;     // 指针p1指向数组1的尾端
        int p2 = length2 -1 ;     // 指针p2指向数组2的尾端

        while (p1 >= 0 && p2 > 0) {   // 两数组数目相同的部分
            if (arr1[p1] >= arr2[p2]) {
                arr1[q] = arr1[p1];
                p1--;                 // p1向前挪动一位
                q--;
            } else {
                arr1[q] = arr2[p2];
                p2--;
                q--;
            }
        }

        while (p1 >= 0)   {           // 如果数组1较多
            arr1[q] = arr1[p1];
            q--;
            p1--;
        }

        while (p2 >= 0)   {           // 如果数组2较多
            arr1[q] = arr1[p2];
            q--;
            p2--;
        }
        return arr1;
    }
}