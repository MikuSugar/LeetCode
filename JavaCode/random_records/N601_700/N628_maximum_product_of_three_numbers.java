package JavaCode.random_records.N601_700;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 两种情况：最大值=3个最大值相乘，或者两个最小值和一个最大值相乘
 * 维护一个最大堆和一个最小堆
 * 复制度O（n）
 */
public class N628_maximum_product_of_three_numbers {
    public int maximumProduct(int[] nums) {
        PriorityQueue<Integer> q_max=new PriorityQueue<>();//最大堆
        PriorityQueue<Integer> q_min=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i=0;i<3;i++)
        {
            q_max.add(nums[i]);
            q_min.add(nums[i]);
        }
        for (int i=3;i<nums.length;i++)
        {
            if(q_max.peek()<nums[i])
            {
                q_max.poll();
                q_max.add(nums[i]);
            }
            if(q_min.peek()>nums[i])
            {
                q_min.poll();
                q_min.add(nums[i]);
            }
        }
        q_min.poll();
        int res1=1,res2=1;
        res1=q_max.poll()*q_max.poll()*q_max.peek();
        if(q_max.peek()<0||nums.length==3)return res1;
        res2=q_min.poll()*q_min.poll()*q_max.poll();
        return res1<res2?res2:res1;
    }
}
/**
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: 24
 */
