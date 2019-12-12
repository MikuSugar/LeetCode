package JavaCode.random_records.N301_400;

import java.util.*;

/**
 * author:fangjie
 * time:2019/12/4
 */
public class N381_insert_delete_getrandom_o1_duplicates_allowed {
    class RandomizedCollection {

        private List<Integer> list;
        private Map<Integer,Set<Integer>> map;
        private Random random;
        /** Initialize your data structure here. */
        public RandomizedCollection() {
            list=new ArrayList<>(10000);
            random=new Random();
            map=new HashMap<>();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            Set<Integer> set=map.getOrDefault(val, new HashSet<>());
            list.add(val);
            set.add(list.size()-1);
            map.put(val,set);
            return set.size()==1;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if(!map.containsKey(val))return false;
            Set<Integer> set=map.get(val);
            Iterator<Integer> it=set.iterator();
            int idx=it.next();
            set.remove(idx);
            if(set.size()==0)map.remove(val);
            if(idx==list.size()-1)list.remove(list.size()-1);
            else {
                list.set(idx,list.get(list.size()-1));
                Set<Integer> set1=map.get(list.get(list.size()-1));
                set1.remove(list.size()-1);
                set1.add(idx);
                list.remove(list.size()-1);
            }
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }

/*
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
/*
设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。

注意: 允许出现重复元素。

insert(val)：向集合中插入元素 val。
remove(val)：当 val 存在时，从集合中移除一个 val。
getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
示例:

// 初始化一个空的集合。
RandomizedCollection collection = new RandomizedCollection();

// 向集合中插入 1 。返回 true 表示集合不包含 1 。
collection.insert(1);

// 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
collection.insert(1);

// 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
collection.insert(2);

// getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
collection.getRandom();

// 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
collection.remove(1);

// getRandom 应有相同概率返回 1 和 2 。
collection.getRandom();

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
