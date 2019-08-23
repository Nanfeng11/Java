package com.nanfeng;

import java.util.HashMap;

/**
 * Author：nanfeng
 * Created:2019/8/20
 */
public class CopyListF {
    public class Node {
        Node next;
        Node random;
        int value;

        public Node(int value) {
            this.next = next;
            this.random = random;
            this.value = value;
        }
    }

    public Node copy1(Node head) {
        if (head == null) {
            return null;
        }
        Node p = head;
        while (p != null) {
            Node q = new Node(p.value);

            q.next = p.next;
            p.next = q;

            p = q.next;
        }

        p = head;
        while (p != null) {
            Node q = p.next;

            if (p.random != null) {
                q.random = p.random.next;
            } else {
                q.random = null;
            }

            p = q.next;
        }

        p = head;
        Node newHead = head.next;
        while (p != null) {
            Node q = p.next;

            p.next = q.next;

            if (q.next != null) {
                q.next = q.next.next;
            } else {
                q.next = null;
            }

            p = p.next;

        }

        return newHead;
    }

    public Node copy2(Node head) {
        Node newHead = new Node(-1);
        Node newLast = newHead;
        HashMap<Node, Node> map = new HashMap<>();

        Node p = head;
        while (p != null) {
            Node q = new Node(p.value);
            newLast.next = q;
            newLast = newLast.next;

            map.put(p, q);

            p = p.next;
        }

        p = head;
        Node q = newHead.next;
        while (p != null) {
            q.random = map.get(p.random);

            p = p.next;
            q = q.next;
        }

        return newHead.next;
    }
}
