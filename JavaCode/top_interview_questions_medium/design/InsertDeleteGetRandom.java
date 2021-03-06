package JavaCode.top_interview_questions_medium.design;

import java.util.*;

public class InsertDeleteGetRandom {

    public static void main(String[] args) {
        RandomizedSet set=new InsertDeleteGetRandom().new RandomizedSet();
        set.insert(3);
        set.insert(3);
        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
        set.insert(1);
        set.remove(3);
        System.out.println(set.getRandom());
        System.out.println(set.getRandom());
        set.insert(0);
        set.remove(0);

    }

    class RandomizedSet {

        private List<Integer> list;///存储数据
        private Map<Integer,Integer> map;//存储数据及其对应的位置
        private Random random;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            list=new ArrayList<>();
            map=new HashMap<>();
            random=new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(map.containsKey(val)) return false;
            else {
                list.add(val);
                map.put(val,list.size()-1);
                return true;
            }
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(map.containsKey(val))
            {

                int i=map.get(val);
                if(i==list.size()-1)
                {
                    list.remove(list.size()-1);
                    map.remove(val);
                    return true;
                }
                list.set(i,list.get(list.size()-1));
                list.remove(list.size()-1);
                map.put(list.get(i),i);
                map.remove(val);
                return true;
            }
            else
            {
                return false;
            }
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/52/design/110/
 * Insert Delete GetRandom O(1)
 * 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
 *
 * insert(val)：当元素 val 不存在时，向集合中插入该项。
 * remove(val)：元素 val 存在时，从集合中移除该项。
 * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 * 示例 :
 *
 * // 初始化一个空的集合。
 * RandomizedSet randomSet = new RandomizedSet();
 *
 * // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
 * randomSet.insert(1);
 *
 * // 返回 false ，表示集合中不存在 2 。
 * randomSet.remove(2);
 *
 * // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
 * randomSet.insert(2);
 *
 * // getRandom 应随机返回 1 或 2 。
 * randomSet.getRandom();
 *
 * // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
 * randomSet.remove(1);
 *
 * // 2 已在集合中，所以返回 false 。
 * randomSet.insert(2);
 *
 * // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
 * randomSet.getRandom();
 */
