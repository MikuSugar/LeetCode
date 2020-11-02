package JavaCode.contest.biweekly.biweekly_n17;

import java.util.ArrayList;
import java.util.List;

/**
 * author:fangjie
 * time:2020/1/11
 */
public class N1 {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> res=new ArrayList<>();
        for (int i=0;i<nums.length;i+=2)
        {
            for (int k=0;k<nums[i];k++)
            {
                res.add(nums[i+1]);
            }
        }
        int[] ans=new int[res.size()];
        int idx=0;
        for (int i:res)ans[idx++]=i;
        return ans;
    }
}
/*
给你一个以行程长度编码压缩的整数列表 nums 。

考虑每相邻两个元素 [a, b] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），每一对都表示解压后有 a 个值为 b 的元素。

请你返回解压后的列表。



示例：

输入：nums = [1,2,3,4]
输出：[2,4,4,4]


提示：

2 <= nums.length <= 100
nums.length % 2 == 0
1 <= nums[i] <= 100

 */
