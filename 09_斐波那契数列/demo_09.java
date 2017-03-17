/**
 * 一提到Fibonacci数列，大家第一反应肯定是递归
 * 但其递归实现存在着大量重复计算的问题，效率很低
 * 解决方法是把递归过程中得到的中间项存起来，避免重复计算
 * Fibonacci数列可以用在哪些地方？
 * 例如青蛙跳台阶等问题，这种问题的特点是
 * 某个状态的解，依赖于之前一步的所有状态解之和
 * 例如青蛙跳上8级台阶的跳法f(8)，取决于之前一次的跳法
 * 之前一次跳一级则有f(7), 之前一次跳两级则有f(6)
 * f(8) = f(7) + f(6)
 */

public class demo_09 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(Fibonacci(n));
    }

    private static int Fibonacci(int n) {
        int[] result = {0, 1};

        if (n < 2) {
            return result[n];
        }

        int fibOne = 1;
        int fibTwo = 0;
        int fibN = 0;

        for (int i = 2; i <= n; i++) {
            fibN = fibOne + fibTwo;
            fibTwo = fibOne;
            fibOne = fibN;
        }
        return fibN;
    }
}

