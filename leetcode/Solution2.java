package leetcode;

/**
 * Created on 2020/6/10.
 * leetcode 2
 * @author etlRlks
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution2 {
    /*
    给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
    并且它们的每个节点只能存储 一位 数字。
    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

    您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

    示例：

    输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    输出：7 -> 0 -> 8
    原因：342 + 465 = 807

     */
    public static void main(String[] args) {

        //0 2 5
        ListNode l1 = new ListNode(0);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(2);

        ListNode l2 = new ListNode(7);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(2);


        ListNode l = addTwoNumbers(l1, l2);
//        int count = 0;
//        while (l != null) {
//            count++;
//            System.out.println("main" + count + "--" + l.val);
//            l = l.next;
//        }
    }
    /*
    输入：l1 : (2 -> 4 -> 3) +
         l2 : (5 -> 7 -> 4)
    输出：      7 -> 1 -> 8
     */

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode listNode = new ListNode(l1.val + l2.val);
        ListNode temp = listNode;

        while (l1 != null && l2 == null ||
                l1 == null && l2 != null ||
                l1 != null && l2 != null) {

            if (l1 == null) {
                l1 = new ListNode(0);
            } else if (l2 == null) {
                l2 = new ListNode(0);
            }
            //5 6 2
            //5 5 2
            temp.val = l1.val + l2.val; //5 + 5

            if (temp.val >= 10) {       //10
                int b = temp.val / 10;    //十位  1
                int a = temp.val % 10;    //个位  0


                temp.val = a;   //0
                if (l2.next != null) {
                    l2.next.val = l2.next.val + b;
                } else if (l1.next != null) {
                    l1.next.val = l1.next.val + b;
                } else {
                    temp.next = new ListNode(0);
                    temp.next.val = b;
                }

                l1 = l1.next;
                l2 = l2.next;

            } else {
                l1 = l1.next;
                l2 = l2.next;
            }
            if (l1 != null || l2 != null) {
                temp.next = new ListNode(0);
                temp = temp.next;
            }
        }

        return listNode;
    }

}
