package JavaCode.random_records.N601_700;

public class N698_partition_to_k_equal_sum_subsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        for (int i:nums)
        {
            sum+=i;
        }
        if(sum%k!=0)return false;
        boolean[] book=new boolean[nums.length];
        return dfs(nums,book,0,k,0,sum/k);
    }

    /**
     * dfs 搜索
     * @param nums
     * @param book 标记数组
     * @param index 搜索起点
     * @param k 剩余份数
     * @param sum 当前的和
     * @param avg
     * @return
     */
    private boolean dfs(int[] nums, boolean[] book, int index, int k, int sum, int avg) {
        if(k==1)return true;//搜索结束且成功
        if(sum==avg)return dfs(nums,book,0,k-1,0,avg);//搜索下一份
        if(sum>avg)return false;//剪枝叶
        for (int i=index;i<nums.length;i++)
        {
            if(!book[i])
            {
                book[i]=true;
                if(dfs(nums,book,i+1,k,sum+nums[i],avg))return true;//继续搜索本份
                book[i]=false;
            }
        }
        return false;
    }

}
/**
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 *
 * 示例 1：
 *
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 *
 *
 * 注意:
 *
 * 1 <= k <= len(nums) <= 16
 * 0 < nums[i] < 10000
 */
