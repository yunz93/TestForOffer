/**
 * 问题描述：输入数字n，按顺序打印从1到最大的n位十进制数
 * 问题分析：没有指定n的范围，说明是个大数问题
 * 大数问题不好去设定数字类型，用数组解决更简单
 * 书中使用的是字符串，但我觉得数组更容易理解，说实话这个题我没弄太懂
 * 第二个问题是如何防止溢出
 * 如何正确打印结果，隐藏字符串前端的0
 */
import java.util.Scanner;

public class Demo_12 {
    public static void main(String[] args) {
        int n;

        Demo_12 demo = new Demo_12();

        System.out.println("请输入 n 值：");
        Scanner s = new Scanner(System.in);
        n = s.nextInt();

        demo.PrintOne2MaxOfNDigits(n);
    }

    public void PrintOne2MaxOfNDigits(int n) {
        int[] array=new int[n];
        if(n<=0)
            return;
        printArray(array,0);
    }

    private void printArray(int[] array,int n) {
        for(int i=0; i<10; i++) {
            if(n!=array.length) {
                array[n]=i;
                printArray(array, n+1);
            } else {
                boolean isFirstNo0=false;
                for(int j=0; j<array.length; j++) {
                    if(array[j]!=0) {
                        System.out.print(array[j]);
                        if(!isFirstNo0)
                            isFirstNo0=true;
                    } else {
                        if(isFirstNo0)
                            System.out.print(array[j]);
                    }
                }
                System.out.println();
                return;
            }
        }
    }
}