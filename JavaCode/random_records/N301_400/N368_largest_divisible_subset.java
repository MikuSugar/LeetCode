package JavaCode.random_records.N301_400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N368_largest_divisible_subset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] count=new int[nums.length];
        int[] pre=new int[nums.length];
        Arrays.sort(nums);
        int max=0,idx=-1;
        for (int i=0;i<nums.length;i++)
        {
            count[i]=1;
            pre[i]=-1;
            for (int j=i-1;j>=0;j--)
            {
                if(nums[i]%nums[j]==0)
                {
                    if(1+count[j]>count[i])
                    {
                        count[i]=count[j]+1;
                        pre[i]=j;
                    }
                }
            }
            if(count[i]>max)
            {
                max=count[i];
                idx=i;
            }
        }

        List<Integer> res=new ArrayList<>();
        while (idx!=-1)
        {
            res.add(nums[idx]);
            idx=pre[idx];
        }
        return res;
    }
}
/**
 * 给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si = 0。
 *
 * 如果有多个目标子集，返回其中任何一个均可。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2] (当然, [1,3] 也正确)
 * 示例 2:
 *
 * 输入: [1,2,4,8]
 * 输出: [1,2,4,8]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-divisible-subset
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
