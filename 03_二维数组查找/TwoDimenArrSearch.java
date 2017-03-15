import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * 实现二维数组的查找
 **/

public class TwoDimenArrSearch {

    public static void main(String[] args) throws IOException {
        int[][] matrix;
        int rows = 4;
        int columns = 4;
        int num;

        matrix = new int[rows][columns];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = i + j;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("请输入要查找的数： ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strNum = br.readLine();
        num = Integer.parseInt(strNum);

        System.out.println("该二维数组中是否存在该数？ " + Find(matrix, rows, columns, num));
    }

    public static boolean Find(int[][] matrix, int rows, int columns, int num) {
        boolean found = false;     // 是否查找到

        if (rows > 0 && columns > 0) {
            int row = 0;         // 行
            int column = columns -1;    // 列
            while (row < rows && column >= 0) {
                if (matrix[row][column] == num) {
                    found = true;
                    break;
                } else if (matrix[row][column] > num) {
                    --column;
                } else {
                    ++row;
                }
            }
        }
        return found;
    }
}