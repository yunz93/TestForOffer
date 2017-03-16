/**
 * 给定一个二叉树的前序遍历和中序遍历
 * 重建该二叉树
 * 打印二叉树
 * 解决思路，理解二叉树的三种遍历原理
 * 即可知道，根据前序遍历序列的第一位可以确定二叉树的根节点
 * 根据二叉树根节点在中序遍历序列中的位置可以划分出左右子树
 * 然后对左右子树做递归就可以了
 */
import java.util.Arrays;
/**
 * 二叉树节点类
 */
class BinaryTreeNode {
    int data;
    BinaryTreeNode leftNode;
    BinaryTreeNode rightNode;

}


public class demo_06 {
    public static void main(String[] args) throws Exception {
        int[] arrQ = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] arrZ = {4, 7, 2, 1, 5, 3, 8, 6};

        BinaryTreeNode root = ConstructCore(arrQ, arrZ);
    }

    private static BinaryTreeNode ConstructCore(int[] arrQ, int[] arrZ) {
        int lengthQ = arrQ.length;   // 前序序列长度
        int lengthZ = arrZ.length;   // 中序序列长度
        // 异常处理
        if (arrQ == null || arrZ == null) {
            return null;
        }
        if (lengthQ != lengthZ) {
            System.out.println("输入序列有误，请检查！");
            return null;
        }

        BinaryTreeNode root = new BinaryTreeNode();

        for (int i = 0; i < arrQ.length; i++) {
            if (arrZ[i] == arrQ[0]) {
                root.data = arrZ[i];
                System.out.print(root.data);
                // 重建左子树
                root.leftNode = ConstructCore(Arrays.copyOfRange(arrQ, 1, i+1),
                    Arrays.copyOfRange(arrZ, 0, i));
                // 重建右子树
                root.rightNode = ConstructCore(Arrays.copyOfRange(arrQ, i+1, lengthQ),
                    Arrays.copyOfRange(arrZ, i+1, lengthZ));
            }
            System.out.println();
        }
        return root;
    }
}