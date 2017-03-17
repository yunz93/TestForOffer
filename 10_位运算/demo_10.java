import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 实现一个函数，输入一个整数，输出该数的二进制表示中的1的个数
 * 第一种思路：一个数与1做与运算，如果结果是1，证明该数的二进制表示的最右位为1
 * 1. 右移该数，逐一判断每一位是否为1，但遇到负数会陷入死循环。
 * 2. 左移1，逐一判断每一位是否为1
 * 第二种思路：把一个整数减一，再和原整数做与运算，会把该整数的最右边一个1变成0
 * 比第一种思路好的地方在于，操作次数较少，有几个一操作几次
 */

public class demo_10 {
    public static void main(String[] args) throws IOException {
        demo_10 test = new demo_10();
        System.out.println("请输入一个整数：");
        BufferedReader keyin = new BufferedReader(new InputStreamReader(System.in));
        String input = keyin.readLine();
        int num = Integer.parseInt(input);

        // System.out.println("所输入的数的二进制表达式中有：" + test.NumOf1_1(num) + " 个 1");
        System.out.println("所输入的数的二进制表达式中有：" + test.NumOf1_2(num) + " 个 1");
        System.out.println("所输入的数的二进制表达式中有：" + test.NumOf1_3(num) + " 个 1");
        keyin.close();
    }

    public int NumOf1_1(int n) {
        int count = 0;

        while(n != 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public int NumOf1_2(int n) {
        int count = 0;
        int flag = 1;

        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    public int NumOf1_3(int n) {
        int count = 0;

        while (n != 0) {
            ++ count;
            n = (n - 1) & n;
        }

        return count;
    }
}