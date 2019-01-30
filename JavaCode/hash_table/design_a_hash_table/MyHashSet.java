package JavaCode.hash_table.design_a_hash_table;

import java.util.ArrayList;
import java.util.List;

public class MyHashSet {

    /**
     * ["MyHashSet","add","add","contains","contains","add","contains","remove","contains"]
     * [[],[1],[2],[1],[3],[2],[2],[2],[2]]
     * @param args
     */
    public static void main(String[] args) {
        MyHashSet set=new MyHashSet();
        set.add(1);
        set.add(2);
        System.out.println(set.contains(1));
        System.out.println(set.contains(3));
        set.add(2);
        set.remove(2);
        System.out.println(set.contains(2));
    }

    private List<Integer>[] barrel;

    /**
     * 获取桶的序号
     * @param key
     * @return
     */
    int hashNumber(int key)
    {
        return key%1000;
    }

    /** Initialize your data structure here. */
    public MyHashSet() {
        this.barrel=new ArrayList[10001];
    }

    public void add(int key) {
       int number=hashNumber(key);
       if(barrel[number]==null)
       {
           barrel[number]=new ArrayList<>();
       }
       else
       {
           for(int i:barrel[number])
           {
               if(i==key)return;
           }
       }
       barrel[number].add(key);
    }

    public void remove(int key) {
        int number=hashNumber(key);
        if(barrel[number]==null) return;
        else
        {
            for(int i=0;i<barrel[number].size();i++)
            {
                if(barrel[number].get(i)==key)
                {
                    barrel[number].remove(i);
                    return;
                }
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(barrel[hashNumber(key)]==null||barrel[hashNumber(key)].size()==0) return false;
        for(int i:barrel[hashNumber(key)])
        {
            if(i==key) return true;
        }
        return false;
    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/hash-table/203/design-a-hash-table/799/
 * 设计哈希集合
 * 不使用任何内建的哈希表库设计一个哈希集合
 *
 * 具体地说，你的设计应该包含以下的功能
 *
 * add(value)：向哈希集合中插入一个值。
 * contains(value) ：返回哈希集合中是否存在这个值。
 * remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 *
 * 示例:
 *
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);
 * hashSet.add(2);
 * hashSet.contains(1);    // 返回 true
 * hashSet.contains(3);    // 返回 false (未找到)
 * hashSet.add(2);
 * hashSet.contains(2);    // 返回 true
 * hashSet.remove(2);
 * hashSet.contains(2);    // 返回  false (已经被删除)
 *
 * 注意：
 *
 * 所有的值都在 [1, 1000000]的范围内。
 * 操作的总数目在[1, 10000]范围内。
 * 不要使用内建的哈希集合库。
 */
