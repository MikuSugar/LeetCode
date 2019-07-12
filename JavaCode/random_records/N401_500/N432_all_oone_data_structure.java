package JavaCode.random_records.N401_500;

import java.util.*;

public class N432_all_oone_data_structure {

    class AllOne {
        private Map<String,Integer> key_map;
        private TreeMap<Integer, Set<String>> cnt_map;
        /** Initialize your data structure here. */
        public AllOne() {
            key_map=new HashMap<>();
            cnt_map=new TreeMap<>();
        }

        /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
        public void inc(String key) {
            if(key_map.containsKey(key))
            {
                int old_cnt=key_map.get(key);
                key_map.put(key,old_cnt+1);
                Set<String> set = cnt_map.get(old_cnt);
                set.remove(key);
                if(set.size()==0) cnt_map.remove(old_cnt);
                if(!cnt_map.containsKey(old_cnt+1))
                {
                    cnt_map.put(old_cnt+1,new HashSet<>());
                }
                cnt_map.get(old_cnt+1).add(key);
            }
            else
            {
                key_map.put(key,1);
                if(!cnt_map.containsKey(1))
                {
                    cnt_map.put(1,new HashSet<>());
                }
                cnt_map.get(1).add(key);
            }
        }

        /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
        public void dec(String key) {
            if(!key_map.containsKey(key))return;
            int old_cnt=key_map.get(key);
            key_map.remove(key);
            if(old_cnt==1)
            {
                Set<String> set = cnt_map.get(old_cnt);
                set.remove(key);
                if(set.size()==0)cnt_map.remove(old_cnt);
            }
            else
            {
                key_map.put(key,old_cnt-1);
                Set<String> set = cnt_map.get(old_cnt);
                set.remove(key);
                if(set.size()==0) cnt_map.remove(old_cnt);

                if(!cnt_map.containsKey(old_cnt-1))
                {
                    cnt_map.put(old_cnt-1,new HashSet<>());
                }
                cnt_map.get(old_cnt-1).add(key);
            }
        }

        /** Returns one of the keys with maximal value. */
        public String getMaxKey() {
            if(cnt_map.size()==0)return "";
            Map.Entry<Integer, Set<String>> e= cnt_map.lastEntry();
            for (String key:e.getValue())
            {
                return key;
            }
            return "";
        }

        /** Returns one of the keys with Minimal value. */
        public String getMinKey() {
            if(cnt_map.size()==0)return "";
            Map.Entry<Integer, Set<String>> e = cnt_map.firstEntry();
            for (String key:e.getValue())
            {
                return key;
            }
            return "";
        }
    }

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
}
/**
 * 实现一个数据结构支持以下操作：
 *
 * Inc(key) - 插入一个新的值为 1 的 key。或者使一个存在的 key 增加一，保证 key 不为空字符串。
 * Dec(key) - 如果这个 key 的值是 1，那么把他从数据结构中移除掉。否者使一个存在的 key 值减一。如果这个 key 不存在，这个函数不做任何事情。key 保证不为空字符串。
 * GetMaxKey() - 返回 key 中值最大的任意一个。如果没有元素存在，返回一个空字符串""。
 * GetMinKey() - 返回 key 中值最小的任意一个。如果没有元素存在，返回一个空字符串""。
 * 挑战：以 O(1) 的时间复杂度实现所有操作。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-oone-data-structure
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
