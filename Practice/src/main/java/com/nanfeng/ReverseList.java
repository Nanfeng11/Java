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

//非递归
//public class ReverseList {
//    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        ArrayList<Integer> list = new ArrayList();
//        ListNode cur = listNode;
//        while (cur != null) {
//            list.add(0, cur.val);
//            cur = cur.next;
//        }
//        return list;
//    }
//}

//递归
public class ReverseList {
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode!=null){
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }
}
