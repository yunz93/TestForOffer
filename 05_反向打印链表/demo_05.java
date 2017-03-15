import java.util.Stack;

/**
 * 反向打印链表有两种方式
 * 一、利用栈的先入后出特性
 * 二、利用递归
 */

// 节点类
class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

// 链表实现类
class LinkedList {
    public ListNode getFirst() {
        return first;
    }

    public ListNode getLast() {
        return last;
    }

    private ListNode first;
    private ListNode last;

    // 链表是否为空
    public boolean isEmpty() {
        return first == null;
    }

    // 在链表尾部插入
    public void insert(int data) {
        ListNode newNode = new ListNode(data);
        if (this.isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
    }

    // 反向打印链表 栈方法
    public void reversePrint_01(ListNode first) {
        Stack<ListNode> stack = new Stack<>();
        // 把链表的所有节点存入栈
        while (first != null) {
            stack.push(first);
            first = first.next;
        }
        // 再一个个弹出来并打印
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().data + " ");
        }
        System.out.println();
    }

    // 反向打印链表 递归方法
    public void reversePrint_02(ListNode first) {
        if (first != null) {
            if (first.next != null) {
                reversePrint_02(first.next);
            }
        }
        System.out.print(first.data + " ");
    }
}

public class demo_05 {
    public static void main(String[] args) {
        // 生成一个链表
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 10; i++) {
            linkedList.insert(i);
        }
        // 方法一测试
        linkedList.reversePrint_01(linkedList.getFirst());
        // 方法二测试
        linkedList.reversePrint_02(linkedList.getFirst());
    }
}