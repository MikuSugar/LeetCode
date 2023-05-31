package JavaCode.random_records.N2201_N2400;

import utils.CheckUtil;
import utils.Parse;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayDeque;

/**
 * @author mikusugar
 * @version 1.0, 2023/3/30 16:43
 * @description N2289_steps_to_make_array_non_decreasing
 */
public class N2289_steps_to_make_array_non_decreasing {

    public static void main(String[] args) throws IOException {
        final N2289_steps_to_make_array_non_decreasing n2289 = new N2289_steps_to_make_array_non_decreasing();
        CheckUtil.check(n2289.totalSteps(Parse.toIntArr("[5,3,4,4,7,3,6,11,8,5,11]")), 3);
        CheckUtil.check(n2289.totalSteps(Parse.toIntArr("[4,5,7,7,13]")), 0);
        CheckUtil.check(n2289.totalSteps(Parse.toIntArr("[10,6,5,10,15]")), 1);

        final String bigArray = Files.readString(new File("src/JavaCode/random_records/N2201_N2400/2289.txt").toPath());
        CheckUtil.check(n2289.totalSteps(Parse.toIntArr(bigArray)), 99999);
    }

    public int totalSteps(int[] nums) {
        ArrayDeque<Integer> stack =new ArrayDeque<>();
        int[] dp =new int[nums.length];
        int res =0 ;
        for(int i=0;i<nums.length;i++){
            int p =0;
            while(!stack.isEmpty()&&nums[stack.peek()]<=nums[i]){
                p =Math.max(p,dp[stack.peek()]);
                stack.pop();
            }
            if(!stack.isEmpty()){
                dp[i] = p+1;
                res = Math.max(res,dp[i]);
            }
            stack.push(i);
        }
        return res;
    }


}
/*
给你一个下标从 0 开始的整数数组 nums 。在一步操作中，移除所有满足 nums[i - 1] > nums[i] 的 nums[i] ，其中 0 < i < nums.length 。

重复执行步骤，直到 nums 变为 非递减 数组，返回所需执行的操作数。

 

示例 1：

输入：nums = [5,3,4,4,7,3,6,11,8,5,11]
输出：3
解释：执行下述几个步骤：
- 步骤 1 ：[5,3,4,4,7,3,6,11,8,5,11] 变为 [5,4,4,7,6,11,11]
- 步骤 2 ：[5,4,4,7,6,11,11] 变为 [5,4,7,11,11]
- 步骤 3 ：[5,4,7,11,11] 变为 [5,7,11,11]
[5,7,11,11] 是一个非递减数组，因此，返回 3 。
示例 2：

输入：nums = [4,5,7,7,13]
输出：0
解释：nums 已经是一个非递减数组，因此，返回 0 。
 

提示：

1 <= nums.length <= 105
1 <= nums[i] <= 109


来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/steps-to-make-array-non-decreasing
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
