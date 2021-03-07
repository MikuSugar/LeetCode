package JavaCode.contest.weekly.n201_300.n231;


import java.util.HashMap;
import java.util.Map;

/**
 * author: fangjie
 * email: syfangjie@live.cn
 * date: 2021/3/7 10:27 上午
 */
public class N4 {
    public int minChanges(int[] nums, int k) {
        Map<Integer,Integer>[] maps=new Map[k];
        for (int i=0;i<k;i++)maps[i]=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            maps[i%k].put(nums[i],maps[i%k].getOrDefault(nums[i],0)+1);
        }
        //TODO;
        return -1;
    }
}
/*
给你一个整数数组 nums​​​ 和一个整数 k​​​​​ 。区间 [left, right]（left <= right）的 异或结果 是对下标位于 left 和 right（包括 left 和 right ）之间所有元素进行 XOR 运算的结果：nums[left] XOR nums[left+1] XOR ... XOR nums[right] 。

返回数组中 要更改的最小元素数 ，以使所有长度为 k 的区间异或结果等于零。



示例 1：

输入：nums = [1,2,0,3,0], k = 1
输出：3
解释：将数组 [1,2,0,3,0] 修改为 [0,0,0,0,0]
示例 2：

输入：nums = [3,4,5,2,1,7,3,4,7], k = 3
输出：3
解释：将数组 [3,4,5,2,1,7,3,4,7] 修改为 [3,4,7,3,4,7,3,4,7]
示例 3：

输入：nums = [1,2,4,1,2,5,1,2,6], k = 3
输出：3
解释：将数组[1,2,4,1,2,5,1,2,6] 修改为 [1,2,3,1,2,3,1,2,3]


提示：

1 <= k <= nums.length <= 2000
​​​​​​0 <= nums[i] < 210
 */
