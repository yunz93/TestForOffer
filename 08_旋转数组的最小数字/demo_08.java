/**
 * 何为数组的旋转，即把数组最开始的若干元素搬到数组的末尾
 * 求递增数组的旋转数组的最小元素，要利用旋转数组的特性来提高算法效率
 * 递增数组的旋转数组内部其实有两个递增的小数组，可以用二分法的思路来寻找
 * 先取数组中位的元素，如果其大于数组首位元素，则其在第一个小递增序列中，最小元素在数组后半段
 * 如果其小于末位元素，则其在第二个小递增序列中，最小元素在数组前半段
 * 然后改变首尾指针的位置，进行相似操作，直到头尾指针相差一位，则尾指针指向最小元素
 */

public class demo_08 {
    public static void main(String[] args) throws Exception {
        int[] arr1 = {3, 4, 5, 6, 7, 8, 0, 1, 2};
        int[] arr2 = {1, 0, 1, 1, 1};
        System.out.println(searchForMin(arr1));
        System.out.println(searchForMin(arr2));
    }

    private static int searchForMin(int[] arr) throws Exception {
        // 异常处理
        if (arr == null || arr.length <= 0) {
            throw new Exception("输出异常！");
        }

        int first, last, medium;    // 指定首尾指针
        first = 0;
        last = arr.length - 1;

        medium = first;

        while (arr[first] >= arr[last]) {
            if ((last - first) == 1) {
                medium = last;
                break;
            }

            medium = (first + last) / 2;

            // 如果头中尾三个指针指向的元素相同
            if (arr[last] == arr[first] && arr[medium] == arr[first]) {
                // 顺序查找
                return MinOrder(arr, first, last);
            }
            // 如果中位元素大于首位元素
            if (arr[medium] > arr[first]) {
                first = medium;
            } else if (arr[medium] <= arr[last]) {
                last = medium;
            }
        }
        return arr[medium];
    }

    private static int MinOrder(int[] arr, int first, int last) {
        int min = arr[first];
        for (int i = first + 1; i <= last; ++i) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }
}