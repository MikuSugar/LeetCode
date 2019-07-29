package JavaCode.random_records.N401_500;

import java.util.HashMap;
import java.util.Map;

public class N460_lfu_cache {
    class LFUCache {
        private Map<Integer,ListNode> map;
        private Map<Integer,ListNode> tailMap;
        private final int capacity;
        private ListNode head;
        public LFUCache(int capacity) {
            this.capacity=capacity;
            this.map=new HashMap<>();
            this.tailMap=new HashMap<>();
            head=new ListNode();
            head.left=new ListNode();
            head.left.right=head;
            tailMap.put(0,head.left);
        }

        public int get(int key) {
            if(capacity<=0||!map.containsKey(key)) return -1;
            ListNode cur=map.get(key);
            use(cur);
            return cur.val;
        }

        private void use(ListNode cur)
        {
            cur.cnt++;
            if(cur.left!=null)cur.left.right=cur.right;
            if(cur.right!=null)cur.right.left=cur.left;
            if(!tailMap.containsKey(cur.cnt))
            {
                ListNode node=new ListNode();
                node.right=tailMap.get(cur.cnt-1);
                node.right.left=node;
                tailMap.put(cur.cnt,node);
            }
            ListNode tail = tailMap.get(cur.cnt);
            cur.left=tail;
            cur.right=tail.right;
            cur.right.left=cur;
            tail.right=cur;
        }
        public void put(int key, int value) {
            if(capacity==0)return;
            ListNode node=map.getOrDefault(key,null);
            if(node!=null)
            {
                node.val=value;
                use(node);
                return;
            }
            if(map.size()==capacity) removeFirslt();
            node=new ListNode(value,key);
            ListNode tail = tailMap.get(node.cnt);
            node.left=tail;
            node.right=tail.right;
            node.right.left=node;
            tail.right=node;
            map.put(key,node);
        }
        private void removeFirslt()
        {
            ListNode cur=head;
            while (cur.val==-1)
            {
                cur=cur.left;
            }
            cur.left.right=cur.right;
            cur.right.left=cur.left;
            map.remove(cur.key);
        }
        private class ListNode
        {
            int val,cnt,key;
            ListNode left,right;
            public ListNode() {
                this.val = -1;
            }
            public ListNode(int val, int key) {
                this.val = val;
                this.key = key;
                cnt=0;
            }
        }
    }

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
/**
 *设计并实现最不经常使用（LFU）缓存的数据结构。它应该支持以下操作：get 和 put。
 *
 * get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
 * put(key, value) - 如果键不存在，请设置或插入值。当缓存达到其容量时，它应该在插入新项目之前，使最不经常使用的项目无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，最近最少使用的键将被去除。
 *
 * 进阶：
 * 你是否可以在 O(1) 时间复杂度内执行两项操作？
 *
 * 示例：
 *
 * LFUCache cache = new LFUCache( 2 /* capacity (缓存容量)  );

        *cache.put(1,1);
        *cache.put(2,2);
        *cache.get(1);       // 返回 1
        *cache.put(3,3);    // 去除 key 2
        *cache.get(2);       // 返回 -1 (未找到key 2)
        *cache.get(3);       // 返回 3
        *cache.put(4,4);    // 去除 key 1
        *cache.get(1);       // 返回 -1 (未找到 key 1)
        *cache.get(3);       // 返回 3
        *cache.get(4);       // 返回 4
        *
        *来源：力扣（LeetCode）
        *链接：https://leetcode-cn.com/problems/lfu-cache
        *著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
