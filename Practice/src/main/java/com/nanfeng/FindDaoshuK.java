package com.nanfeng;

/**
 * Author：nanfeng
 * Created:2019/8/17
 */
public class FindDaoshuK {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode one = head;
        ListNode two = head;
        int i;
        for (i = 0; i < k && two != null; i++) {
            two = two.next;
        }
        if (i < k && two == null) {
            return null;
        } else if (two == null) {
            return head;
        }
        while (two != null) {
            one = one.next;
            two = two.next;
        }
        return one;
    }
}
