package com.qjx.leetcode.list;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qincasin on 2020/3/29.
 */
class Node {
    int val;
    Node next, random;

    public Node(int x) {
        this.val = x;
    }
}

public class CopyListWithRandomPointer {
    /**
     * time : O(n);
     * space : O(n);
     */
    public Node copyRandomList(Node head) {
        //key 存储 当前的 node ，value 存储 复制之后的node
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;

        //复制 data信息
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        //再次 loop
        cur = head;

        while (cur != null) {
            //复制 next 元素
            map.get(cur).next = map.get(cur.next);
            //复制 random元素
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);

    }

    public static void main(String[] args) {
//        RandomListNode node = new RandomListNode(7);
//        node.next = new RandomListNode(13);
//
//        node.next.next = new RandomListNode(11);
//        node.random.random = new RandomListNode(0);
//
//        node.next.next.next = new RandomListNode(10);
//        node.random.random.random = new RandomListNode(4);
//
//        node.next.next.next.next = new RandomListNode(1);
//        node.random.random.random.random = new RandomListNode(2);
//        node.random.random.random.random.random = new RandomListNode(0);
//        RandomListNode randomListNode = copyRandomList(node);
//        System.out.println(randomListNode);
    }
}
