/**
 * 题目要求：实现函数 double Power(double base, int exponent)
 * 求base的exponent次方，不得使用库函数，同时不需要考虑大数问题
 *
 * 需要考虑的点：1. exponent为0和负数的情况
 *               2. 如何提高效率：2^4=(2^2)^2
 */
import java.util.Scanner;

public class Demo_11 {
    public static void main(String[] args) {
        double base;
        int exponent;
        Demo_11 demo = new Demo_11();
        Scanner s = new Scanner(System.in);

        System.out.println("请输入基数：");
        base = s.nextDouble();
        System.out.println("请输入指数：");
        exponent = s.nextInt();

        // 求次方
        System.out.println(base + " 的 " + exponent + " 次方结果为： " + demo.Power(base, exponent));

    }

    public double Power(double base, int exponent) {
        boolean InvalidInput = false;
        // 特殊情况1：如果base为负，exponent为0
        if (equal(base, 0.0) && exponent < 0) {
            InvalidInput = true;
            return 0.0;
        }

        int absExponent = abs(exponent);   // 求exponent绝对值

        double result = PowerWithoutUnsigned(base, absExponent);
        if (exponent < 0) {
            result = 1.0 / result;     // 求导
        }
        return result;
    }

    // 求无符号数的exponent次方
    public double PowerWithoutUnsigned(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        // 递归
        double result = PowerWithoutUnsigned(base, exponent >> 1);   // 右移实现除以2
        result *= result;
        if ((exponent & 0x1) == 1) {     // 判断奇偶
            result *= base;
        }
        return result;
    }

    // 求绝对值
    public int abs(int n) {
        if (n < 0)
            return -n;
        else
            return n;
    }

    // 判断double类型数值是否相等,因为计算机计算误差
    public boolean equal(double num1, double num2) {
        if ((num1 - num2 > -0.0000001) && (num1 - num2) < 0.0000001) {
            return true;
        } else
            return false;
    }
}