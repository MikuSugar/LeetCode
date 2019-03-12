package JavaCode.random_records.N201_300;

import java.util.ArrayList;
import java.util.List;

public class N228_summary_ranges
{

    public List<String> summaryRanges(int[] nums) {
        List<String> res=new ArrayList<>();
        if(nums.length==0)return res;
        int left=0;
        int right=0;
        while (right<nums.length)
        {
            if(right==left||nums[right]-nums[right-1]==1)
            {
                right++;
            }
            else
            {
                res.add(getString(left,right,nums));
                left=right;
            }
        }
        res.add(getString(left,right,nums));
        return res;
    }

    private String getString(int left,int right,int[] nums)
    {
        if(left+1==right)
        {
            return Integer.toString(nums[left]);
        }
        else
        {
            return nums[left]+"->"+nums[right-1];
        }
    }

}
/**
 * https://leetcode-cn.com/problems/summary-ranges/
 * 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
 *
 * 示例 1:
 *
 * 输入: [0,1,2,4,5,7]
 * 输出: ["0->2","4->5","7"]
 * 解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
 * 示例 2:
 *
 * 输入: [0,2,3,4,6,8,9]
 * 输出: ["0","2->4","6","8->9"]
 * 解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
 */
