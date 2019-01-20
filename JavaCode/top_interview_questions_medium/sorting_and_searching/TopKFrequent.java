package JavaCode.top_interview_questions_medium.sorting_and_searching;


import java.util.*;

public class TopKFrequent {
    class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            Map<Integer,Integer> map=new HashMap<>();
            PriorityQueue<Map.Entry<Integer,Integer>> queue=new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o2.getValue()-o1.getValue();
                }
            });
            List<Integer> list=new ArrayList<>();
            for(int i:nums)
            {
                if(map.containsKey(i))
                {
                    map.put(i,map.get(i)+1);
                }
                else
                {
                    map.put(i,1);
                }
            }

            for(Map.Entry<Integer,Integer> m:map.entrySet())
            {
                queue.add(m);
            }

            for(int i=0;i<k;i++)
            {
                list.add(queue.poll().getKey());
            }

            return list;
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/97/
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */
