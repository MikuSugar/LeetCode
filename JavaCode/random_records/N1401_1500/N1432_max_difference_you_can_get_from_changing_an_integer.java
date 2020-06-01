package JavaCode.random_records.N1401_1500;

/**
 * @Author: fangjie
 * @Date: 2020/6/1 8:02 下午
 */
public class N1432_max_difference_you_can_get_from_changing_an_integer {

    public int maxDiff(int num) {
        if(num<10)return 8;

        return max(String.valueOf(num).toCharArray())-min(String.valueOf(num).toCharArray());
    }

    private int min(char[] nums) {
        int idx=0;
        if(nums[0]=='1')
        {
            while (idx<nums.length&&(nums[idx]=='1'||nums[idx]=='0'))idx++;
            if(idx==nums.length)return Integer.parseInt(new String(nums));

            char tar=nums[idx];
            for (int i=idx;i<nums.length;i++)
            {
                if(tar==nums[i])nums[i]='0';
            }
            return Integer.parseInt(new String(nums));
        }
        char tar=nums[0];
        for (int i=0;i<nums.length;i++)
        {
            if(tar==nums[i])nums[i]='1';
        }
        return Integer.parseInt(new String(nums));
    }

    private int max(char[] nums) {
        if(nums[0]=='9')
        {
            int idx=0;
            while (idx<nums.length&&nums[idx]=='9') idx++;
            if(idx==nums.length)return Integer.parseInt(new String(nums));

            char tar=nums[idx];
            for (int i=idx;i<nums.length;i++)
            {
                if(tar==nums[i])nums[i]='9';
            }
            return Integer.parseInt(new String(nums));
        }
        char tar=nums[0];
        for (int i=0;i<nums.length;i++)
        {
            if(tar==nums[i])nums[i]='9';
        }
        return Integer.parseInt(new String(nums));
    }
}
/*
给你一个整数 num 。你可以对它进行如下步骤恰好 两次 ：

选择一个数字 x (0 <= x <= 9).
选择另一个数字 y (0 <= y <= 9) 。数字 y 可以等于 x 。
将 num 中所有出现 x 的数位都用 y 替换。
得到的新的整数 不能 有前导 0 ，得到的新整数也 不能 是 0 。
令两次对 num 的操作得到的结果分别为 a 和 b 。

请你返回 a 和 b 的 最大差值 。

 

示例 1：

输入：num = 555
输出：888
解释：第一次选择 x = 5 且 y = 9 ，并把得到的新数字保存在 a 中。
第二次选择 x = 5 且 y = 1 ，并把得到的新数字保存在 b 中。
现在，我们有 a = 999 和 b = 111 ，最大差值为 888
示例 2：

输入：num = 9
输出：8
解释：第一次选择 x = 9 且 y = 9 ，并把得到的新数字保存在 a 中。
第二次选择 x = 9 且 y = 1 ，并把得到的新数字保存在 b 中。
现在，我们有 a = 9 和 b = 1 ，最大差值为 8
示例 3：

输入：num = 123456
输出：820000
示例 4：

输入：num = 10000
输出：80000
示例 5：

输入：num = 9288
输出：8700
 

提示：

1 <= num <= 10^8

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/max-difference-you-can-get-from-changing-an-integer
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
