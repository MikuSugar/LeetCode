package JavaCode.top_interview_questions_hard.trees_and_graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSmaller {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> help=new ArrayList<>();
        Integer[] res=new Integer[nums.length];

        for (int i=nums.length-1;i>=0;i--)
        {
            int left=0;
            int right=help.size();
            while (left<right)
            {
                int mid=left+(right-left)/2;

                if(help.get(mid)<nums[i])
                {
                    left=mid+1;
                }
                else
                {
                    right=mid;
                }
            }
            res[i]=left;
            help.add(left,nums[i]);
        }
        return Arrays.asList(res);
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/57/trees-and-graphs/145/
 * 计算右侧小于当前元素的个数
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 *
 * 示例:
 *
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 */
