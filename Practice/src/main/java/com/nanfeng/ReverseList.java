package com.nanfeng;

import java.util.ArrayList;


/**
 * Author：nanfeng
 * Created:2019/8/12
 */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}


public class ReverseList {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList();
        ListNode cur = listNode;
        while (cur != null) {
            list.add(0, cur.val);
            cur = cur.next;
        }
        return list;
    }
}
