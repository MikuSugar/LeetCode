package JavaCode.random_records.N401_500;

import java.util.LinkedList;
import java.util.List;

public class N442_find_all_duplicates_in_an_array {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res=new LinkedList<>();
        for (int n:nums)
        {
            n=Math.abs(n);
            if(nums[n-1]>0)
            {
                nums[n-1]*=-1;
            }
            else
            {
                res.add(n);
            }
        }
        return res;
    }
}
/**
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 *
 * 找到所有出现两次的元素。
 *
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 *
 * 示例：
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [2,3]
 */
