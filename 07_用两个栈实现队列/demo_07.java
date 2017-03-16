/**
 * 用两个栈实现队列
 * 栈的特点：先进后出
 * 队列的特点：先进先出
 * 如何用两个栈实现先进先出呢？
 * 很简单，将第一个栈内的元素弹出后依次压入第二个栈实现了逆序，然后再从第二个栈弹出
 * 这样，从系统外面看来，就实现了先入先出
 */
import java.util.Stack;

public class demo_07 {
    public static void main(String[] args) throws Exception {
        QueueByTwoStack<String> list = new QueueByTwoStack<>();
        list.insert("1");
        list.insert("2");
        list.insert("3");
        list.insert("4");
        // 打印弹出结果，验证是否先入先出
        System.out.println(list.delete());
        System.out.println(list.delete());
        System.out.println(list.delete());
        System.out.println(list.delete());
    }
}

class QueueByTwoStack<T> {

    Stack<T> stack_1 = new Stack<>();
    Stack<T> stack_2 = new Stack<>();
    // 尾部插入
    public void insert(T t) {
        stack_1.push(t);
    }
    // 头部删除
    public T delete() throws Exception {
        if (stack_2.isEmpty()) {
            while (!stack_1.isEmpty()) {
                stack_2.push(stack_1.pop());
            }
        }

        if (stack_2.isEmpty()) {
            throw new Exception("队列已空");
        }

        return stack_2.pop();
    }
}