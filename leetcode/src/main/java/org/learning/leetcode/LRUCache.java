package org.learning.leetcode;

import org.assertj.core.util.Lists;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 146. LRU缓存机制,参考https://zhuanlan.zhihu.com/p/34133067
 * 思路：map+双链表
 */
public class LRUCache {

    private DlinkNode head = new DlinkNode();
    private DlinkNode tail = new DlinkNode();

    private int capacity = 0; // 缓存容量
    private int count = 0; //缓存存值数量
    private HashMap<Integer, DlinkNode> cache = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;

        cache = new HashMap<>(capacity);
        head.pre = null;
        head.post = tail;

        tail.pre = head;
        tail.post = null;
    }


    public int get(int key) {
        DlinkNode dlinkNode = cache.get(key);
        if (dlinkNode == null) {
            return -1;
        }
        moveToHead(dlinkNode);
        return dlinkNode.value;
    }

    public void put(int key, int value) {
        DlinkNode dlinkNode = cache.get(key);
        if (dlinkNode != null) {
            dlinkNode.setValue(value);
            moveToHead(dlinkNode);
            return;
        }

        DlinkNode node = new DlinkNode(key, value);
        addNode(node);
        cache.put(key, node);
        if (++count > capacity) {
            DlinkNode tail = popTail();
            cache.remove(tail.getKey());
            --count;
        }

    }

    @Override
    public String toString() {
        return head.toString();
    }


    private class DlinkNode {
        int key;
        int value;
        DlinkNode pre = null;
        DlinkNode post = null;

        public DlinkNode() {
        }

        public DlinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            List<Integer> values = Lists.newArrayList();
            DlinkNode node = this;
            do {
                values.add(node.value);
                node = node.post;
            } while (node != null);
            return values.stream().map(t -> String.valueOf(t)).collect(Collectors.joining("->"));
        }

    }


    public void moveNode(DlinkNode node) {
        DlinkNode pre = node.pre;
        DlinkNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    public void addNode(DlinkNode node) {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }


    public void moveToHead(DlinkNode node) {
        moveNode(node);
        addNode(node);
    }

    public DlinkNode popTail() {
        DlinkNode retVal = tail.pre;
        moveNode(retVal);
        return retVal;
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);/* 缓存容量 */
        System.out.println(cache);

        cache.put(1, 1);
        System.out.println(cache);


        cache.put(2, 2);
        System.out.println(cache);

        Assert.assertEquals(1, cache.get(1));        // 返回  1
        System.out.println(cache);

        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache);

        Assert.assertEquals(-1, cache.get(2));       // 返回 -1 (未找到)
        System.out.println(cache);

        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache);

        Assert.assertEquals(-1, cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache);

        Assert.assertEquals(3, cache.get(3));       // 返回  3
        System.out.println(cache);

        Assert.assertEquals(4, cache.get(4));       // 返回  4
        System.out.println(cache);
    }
}
