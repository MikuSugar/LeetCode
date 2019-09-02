package JavaCode.random_records.N401_500;

import java.util.Arrays;

public class N457_circular_array_loop {
    public boolean circularArrayLoop(int[] nums) {
        int[] next=new int[nums.length];
        Arrays.fill(next,-1);
        for (int i=0;i<nums.length;i++)
        {
            if(nums[i]>0)
            {
                int idx=(nums[i]+i)%nums.length;
                if(idx!=i)next[i]=idx;
            }
        }
        if(help(next))return true;
        Arrays.fill(next,-1);
        for (int i=0;i<nums.length;i++)
        {
            if(nums[i]<0)
            {
                int idx=(nums.length+(i+nums[i])%nums.length)%nums.length;
                if(idx!=i)next[i]=idx;
            }
        }
        return help(next);
    }


    private boolean help(int[] next) {
        int[] book=new int[next.length];
        for (int i=0;i<next.length;i++)
        {
            if(dfs(book,i,next)==3)
            {
                return true;
            }
        }
        return false;
    }

    private int dfs(int[] book, int cur,int[] next) {
        if(next[cur]==-1)return book[cur]=2;
        if(book[cur]==1)return book[cur]=3;
        if(book[cur]!=0)return book[cur];
        book[cur]=1;
        if(dfs(book,next[cur],next)==3)return book[cur]=3;
        return book[cur]=2;
    }

}
/**
 * 给定一个含有正整数和负整数的环形数组 nums。 如果某个索引中的数 k 为正数，则向前移动 k 个索引。相反，如果是负数 (-k)，则向后移动 k 个索引。因为数组是环形的，所以可以假设最后一个元素的下一个元素是第一个元素，而第一个元素的前一个元素是最后一个元素。
 *
 * 确定 nums 中是否存在循环（或周期）。循环必须在相同的索引处开始和结束并且循环长度 > 1。此外，一个循环中的所有运动都必须沿着同一方向进行。换句话说，一个循环中不能同时包括向前的运动和向后的运动。
 *  
 *
 * 示例 1：
 *
 * 输入：[2,-1,1,2,2]
 * 输出：true
 * 解释：存在循环，按索引 0 -> 2 -> 3 -> 0 。循环长度为 3 。
 * 示例 2：
 *
 * 输入：[-1,2]
 * 输出：false
 * 解释：按索引 1 -> 1 -> 1 ... 的运动无法构成循环，因为循环的长度为 1 。根据定义，循环的长度必须大于 1 。
 * 示例 3:
 *
 * 输入：[-2,1,-1,-2,-2]
 * 输出：false
 * 解释：按索引 1 -> 2 -> 1 -> ... 的运动无法构成循环，因为按索引 1 -> 2 的运动是向前的运动，而按索引 2 -> 1 的运动是向后的运动。一个循环中的所有运动都必须沿着同一方向进行。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/circular-array-loop
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
