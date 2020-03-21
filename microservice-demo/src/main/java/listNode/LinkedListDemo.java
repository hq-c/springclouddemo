package listNode;

/**
 * 输入一个链表，输出该链表中倒数第k个节点
 */
public class LinkedListDemo {


    public ListNode findKthTotail(ListNode head ,int k){
        ListNode p, q;
        p = q = head;
        int i = 0;
        for (; p != null; i++){
            p = p.next;
            if(i >= k)
                q = q.next;
        }
        return i < k ? null : q;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        LinkedListDemo test = new LinkedListDemo();
        ListNode result = test.findKthTotail(head, 1);
        System.out.println(result.val);
        /*
        * i=1 p=1 q=1
        * i=2 p=2 q=2
        *
        * */
    }
}
