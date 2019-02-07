package JavaCode.trie.practical_application_i;

import java.util.HashMap;
import java.util.Map;

public class MapSum {
    /** Initialize your data structure here. */

    public static void main(String[] args) {
        MapSum sum=new MapSum();
        sum.insert("aa",3);
        System.out.println(sum.sum("a"));
        sum.insert("aa",2);
        System.out.println(sum.sum("a"));
    }

    class Node
    {
        Node[] child=new Node[26];
        int val;
        public Node()
        {
            val=0;
        }
    }

    Node insertTree(Node root,String key,int val)
    {
        if(root==null)
        {
            root=new Node();
        }
        Node p=root;
        int old_val=map.containsKey(key)?map.get(key):0;
        for(char c:key.toCharArray())
        {

            if(p.child[c-'a']==null)
            {
                p.child[c-'a']=new Node();
            }
            p.child[c-'a'].val+=(val-old_val);
            p=p.child[c-'a'];
        }
        map.put(key,val);
        return root;
    }

    private Node root;
    private Map<String,Integer> map;
    public MapSum() {
        root=null;
        map=new HashMap<>();
    }

    public void insert(String key, int val) {
        root=insertTree(root,key,val);
    }

    public int sum(String prefix) {
        Node p=root;
        for (char c:prefix.toCharArray())
        {
            if(p.child[c-'a']==null)
            {
                return 0;
            }
            p=p.child[c-'a'];
        }
        return p.val;
    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/trie/167/practical-application-i/647/
 * Map Sum Pairs
 * 实现一个 MapSum 类里的两个方法，insert 和 sum。
 *
 * 对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。
 *
 * 对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。
 *
 * 示例 1:
 *
 * 输入: insert("apple", 3), 输出: Null
 * 输入: sum("ap"), 输出: 3
 * 输入: insert("app", 2), 输出: Null
 * 输入: sum("ap"), 输出: 5
 */
