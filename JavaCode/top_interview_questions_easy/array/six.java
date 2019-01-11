package JavaCode.top_interview_questions_easy.array;

import java.util.*;

public class six {
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            return fun0(nums1,nums2);
        }

        /**
         * 暴力Hash
         * @param nums1
         * @param nums2
         * @return
         */
        int[] fun0(int[] nums1,int[] nums2)
        {

            if(nums1.length==0||nums2.length==0)
            {
                return new  int[0];
            }

            Map<Integer,Integer> map1=new HashMap<>();//存储nums1
            Map<Integer,Integer> map2=new HashMap<>();//存储nums2
            List<Integer> list=new ArrayList<Integer>();//存储结果

            for(int i:nums1)
            {
                if(map1.containsKey(i))
                {
                    map1.put(i,map1.get(i)+1);
                }
                else
                {
                    map1.put(i,1);
                }
            }

            for(int i:nums2)
            {
                if(map2.containsKey(i))
                {
                    map2.put(i,map2.get(i)+1);
                }
                else
                {
                    map2.put(i,1);
                }

            }

            for(int key:map1.keySet())
            {
                if(map2.containsKey(key))
                {
                    int cnt=Math.min(map1.get(key),map2.get(key));
                    for(int i=0;i<cnt;i++)
                    {
                        list.add(key);
                    }
                }
            }

            int[] ans=new int[list.size()];
            for(int i=0;i<list.size();i++)
            {
                ans[i]=list.get(i);
            }
            return ans;
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/26/
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
