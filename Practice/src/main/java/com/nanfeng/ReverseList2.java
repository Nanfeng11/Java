package com.nanfeng;

/**
 * Author：nanfeng
 * Created:2019/8/18
 */
public class ReverseList2 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

//    public ListNode ReverseList(ListNode head) {
//        ListNode cur = head;
//        ListNode result = null;
//        while (cur!=null){
//            ListNode next = cur.next;
//            cur.next = result;
//            result = cur;
//            cur = next;
//        }
//        return result;
//    }

    public ListNode ReverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur!=null){
           ListNode next = cur.next;
           cur.next = prev;
           prev = cur;
           cur = next;
        }
        return prev;
    }
}
