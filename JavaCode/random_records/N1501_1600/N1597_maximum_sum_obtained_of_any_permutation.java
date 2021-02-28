package JavaCode.random_records.N1501_1600;

import java.util.Arrays;

/**
 * author: fangjie
 * email: syfangjie@live.cn
 * date: 2021/2/4 4:53 下午
 */
public class N1597_maximum_sum_obtained_of_any_permutation {

    private final static int MOD=(int) (1e9+7);
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int[] book=new int[nums.length];
        for (int[] request:requests){
            book[request[0]]++;
            if(request[1]+1<nums.length)book[request[1]+1]--;
        }

        for (int i=1;i<nums.length;i++){
            book[i]+=book[i-1];
        }

        long res=0L;

        Arrays.sort(nums);
        Arrays.sort(book);
        for (int i=0;i<nums.length;i++)
        {
            res+=(long) nums[i]*book[i];
            res%=MOD;
        }
        return (int) res;
    }
}
/*
有一个整数数组 nums ，和一个查询数组 requests ，其中 requests[i] = [starti, endi] 。第 i 个查询求 nums[starti] + nums[starti + 1] + ... + nums[endi - 1] + nums[endi] 的结果 ，starti 和 endi 数组索引都是 从 0 开始 的。

你可以任意排列 nums 中的数字，请你返回所有查询结果之和的最大值。

由于答案可能会很大，请你将它对 109 + 7 取余 后返回。

 

示例 1：

输入：nums = [1,2,3,4,5], requests = [[1,3],[0,1]]
输出：19
解释：一个可行的 nums 排列为 [2,1,3,4,5]，并有如下结果：
requests[0] -> nums[1] + nums[2] + nums[3] = 1 + 3 + 4 = 8
requests[1] -> nums[0] + nums[1] = 2 + 1 = 3
总和为：8 + 3 = 11。
一个总和更大的排列为 [3,5,4,2,1]，并有如下结果：
requests[0] -> nums[1] + nums[2] + nums[3] = 5 + 4 + 2 = 11
requests[1] -> nums[0] + nums[1] = 3 + 5  = 8
总和为： 11 + 8 = 19，这个方案是所有排列中查询之和最大的结果。
示例 2：

输入：nums = [1,2,3,4,5,6], requests = [[0,1]]
输出：11
解释：一个总和最大的排列为 [6,5,4,3,2,1] ，查询和为 [11]。
示例 3：

输入：nums = [1,2,3,4,5,10], requests = [[0,2],[1,3],[1,1]]
输出：47
解释：一个和最大的排列为 [4,10,5,3,2,1] ，查询结果分别为 [19,18,10]。
 

提示：

n == nums.length
1 <= n <= 105
0 <= nums[i] <= 105
1 <= requests.length <= 105
requests[i].length == 2
0 <= starti <= endi < n


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-sum-obtained-of-any-permutation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */