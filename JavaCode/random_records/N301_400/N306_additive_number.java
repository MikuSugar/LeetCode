package JavaCode.random_records.N301_400;

import java.util.Arrays;

public class N306_additive_number {

    private long[][] book;
    public boolean isAdditiveNumber(String num) {
        char[] nums=num.toCharArray();
        book=new long[nums.length][nums.length];
        for (long[] b:book)
        {
            Arrays.fill(b,-1);
        }
        for (int i=1;i<num.length()-1;i++)
        {
            for (int j=0;j<i;j++)
            {
                long ppre=help(0,j,nums);
                long pre=help(j+1,i,nums);
                if(ppre==-1||pre==-1)
                {
                    continue;
                }
                if(dfs(ppre,pre,i+1,nums))return true;
            }
        }
        return false;
    }

    private boolean dfs(long ppre, long pre, int idx, char[] nums) {
        if(idx==nums.length)return true;
        long target=ppre+pre;
        for (int i=idx;i<nums.length;i++)
        {
            long s=help(idx,i,nums);
            if(s==target)
            {
                if(dfs(pre,s,i+1,nums))return true;
            }
        }
        return false;
    }

    private long help(int i, int j, char[] nums) {
        if(nums[i]=='0'&&j!=i)return -1;
        if(book[i][j]!=-1)return book[i][j];
        StringBuilder sb=new StringBuilder();
        for (int k=i;k<=j;k++)
        {
            sb.append(nums[k]);
        }
        try {
            long res=Long.parseLong(sb.toString());
            book[i][j]=res;
            return res;
        }catch (Exception e)
        {
            return -1;
        }

    }

}
/**
 * 累加数是一个字符串，组成它的数字可以形成累加序列。
 *
 * 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 *
 * 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
 *
 * 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 *
 * 示例 1:
 *
 * 输入: "112358"
 * 输出: true
 * 解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * 示例 2:
 *
 * 输入: "199100199"
 * 输出: true
 * 解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
 * 进阶:
 * 你如何处理一个溢出的过大的整数输入?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/additive-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
