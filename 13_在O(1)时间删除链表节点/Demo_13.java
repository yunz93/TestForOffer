/**
 * 题目要求：给定单向链表的头指针和一个节点指针，定义一个函数
 * 在O(1)时间内删除该节点
 * 解题思路：通常删除单向链表中的节点，需要从表头顺序遍历要删除的节点
 * 找到该节点后，将该节点的前驱节点的指针指向它的下一节点，实现删除
 * 时间复杂度为O(n);
 * 另一种思路：不去遍历查找该节点的前驱节点，直接将该节点的下一节点的值取出，覆盖该节点的值
 * 然后删除下一节点，实现另一种形式的删除
 * 时间复杂度为O(1)
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


public class Demo_13 {
    public static void main(String[] args) {
        Demo_13 demo = new Demo_13();

        // 链表
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode forth = new ListNode(4);

        head.next = second;
        second.next = third;
        third.next = forth;

        System.out.println("第二个节点的下一节点的值为：" + second.next.data);
        demo.deleteNode(head, third);
        System.out.println("删除第三个节点后，第二个节点的下一节点的值为：" + second.next.data);
    }

    // 删除节点
    public void deleteNode(ListNode head, ListNode dest) {
        if (head == null || dest == null) {
            return;
        }

        // 要删除的节点不是尾节点
        if (dest.next != null) {
            ListNode next = dest.next;
            dest.data = next.data;    // 取得下一节点的值
            dest.next = next.next;    // 删除下一节点

            next = null;              // 释放该节点
        }

        // 链表只有一个节点，则删除头结点
        else if (head == dest) {
            dest = null;
            head = null;
        }

        // 链表有多个节点，删除尾节点
        else {
            ListNode pNode = head;
            while (pNode.next != dest) {
                pNode = pNode.next;
            }

            pNode.next = null;
            dest = null;
        }
    }
}