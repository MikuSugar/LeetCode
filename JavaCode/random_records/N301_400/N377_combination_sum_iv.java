package JavaCode.random_records.N301_400;

import java.util.Arrays;

/**
 * author:fangjie
 * time:2019/10/23
 */
public class N377_combination_sum_iv {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] book=new int[target+1];
        Arrays.fill(book,-1);
        return dfs(nums,target,book);
    }

    private int dfs(int[] nums, int target, int[] book) {
        if(target==0)return 1;
        if(target<0)return 0;
        if(book[target]!=-1)return book[target];
        int res=0;
        for (int i=0;i<nums.length&&nums[i]<=target;i++)
        {
            res+=dfs(nums,target-nums[i], book);
        }
        return book[target]=res;
    }
}
/*
给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。

示例:

nums = [1, 2, 3]
target = 4

所有可能的组合为：
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

请注意，顺序不同的序列被视作不同的组合。

因此输出为 7。
进阶：
如果给定的数组中含有负数会怎么样？
问题会产生什么变化？
我们需要在题目中添加什么限制来允许负数的出现？

致谢：
特别感谢 @pbrother 添加此问题并创建所有测试用例。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum-iv
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
