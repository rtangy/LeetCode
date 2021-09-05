/**
 * leetcode2 https://leetcode-cn.com/problems/add-two-numbers/
 * Create new LinkedList for result
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        int carried = 0;
        while (l1 != null || l2 != null) {
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            int sum = a + b + carried;
            cur.next = new ListNode(sum % 10);
            carried = sum / 10;

            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carried == 1) {
            cur.next = new ListNode(1);
        }
        return dummyHead.next;
    }
}
// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}