package com.nanfeng;

/**
 * Author：nanfeng
 * Created:2019/8/18
 */
public class HeBingList {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode result = null;
        ListNode last = null;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                ListNode next = cur1.next;
                cur1.next = null;
                if (result == null) {
                    result = cur1;
                } else {
                    last.next = cur1;
                }
                last = cur1;
                cur1 = next;
            } else {
                ListNode next = cur2.next;
                cur2.next = null;
                if (result == null) {
                    result = cur2;
                } else {
                    last.next = cur2;
                }
                last = cur2;
                cur2 = next;
            }
        }
        if (cur1 != null) {
            last.next = cur1;
        }
        if (cur2 != null) {
            last.next = cur2;
        }
        return result;
    }
}
