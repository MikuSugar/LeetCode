package JavaCode.random_records.N501_600;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class N503_next_greater_element_ii {
    public int[] nextGreaterElements(int[] nums) {
        int[] res=new int[nums.length];
        Arrays.fill(res,-1);
        PriorityQueue<int[]> q=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        for (int i=0;i<nums.length;i++)
        {
            q.add(new int[]{nums[i],i});
            while (q.peek()[0]<nums[i])
            {
                res[q.poll()[1]]=nums[i];
            }
        }
        for (int i:nums)
        {
            while (!q.isEmpty()&&q.peek()[0]<nums[i])
            {
                res[q.poll()[1]]=i;
            }
            if(q.isEmpty())break;
        }
        return res;
    }
}
/**
 * https://leetcode-cn.com/problems/next-greater-element-ii/
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 示例 1:
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 */
