package JavaCode.contest.n181;

import java.util.HashSet;
import java.util.Set;

/**
 * author:fangjie
 * time:2020/3/22
 */
public class N2 {
    public int sumFourDivisors(int[] nums) {
        int res=0;
        for (int i:nums)
        {
            res+=slove(i);
        }
        return res;
    }

    private int slove(int num) {
        Set<Integer> set=new HashSet<>();
        for (int i=1;i<=Math.sqrt(num);i++)
        {
            if(num%i==0)
            {
                set.add(i);
                set.add(num/i);
            }
            if(set.size()>4)return 0;
        }
        if(set.size()!=4)return 0;
        int res=0;
        for (int i:set)res+=i;
        return res;
    }
}
/*
给你一个整数数组 nums，请你返回该数组中恰有四个因数的这些整数的各因数之和。

如果数组中不存在满足题意的整数，则返回 0 。



示例：

输入：nums = [21,4,7]
输出：32
解释：
21 有 4 个因数：1, 3, 7, 21
4 有 3 个因数：1, 2, 4
7 有 2 个因数：1, 7
答案仅为 21 的所有因数的和。


提示：

1 <= nums.length <= 10^4
1 <= nums[i] <= 10^5
 */
