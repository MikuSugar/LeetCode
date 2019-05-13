package JavaCode.random_records.N1_100;

import java.util.*;

public class N18_4sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums,target,4,0);
    }

    private List<List<Integer>> kSum(int[] nums, int target, int k, int index) {
        List<List<Integer>> res=new ArrayList<>();
        if(index>=nums.length)return res;

        if(k==2)
        {
            int left=index,right=nums.length-1;
            while (left<right)
            {
                int mid=target-nums[left];
                if(mid==nums[right])
                {
                    List<Integer> list=new ArrayList<>(2);
                    list.add(nums[right]);
                    list.add(nums[left]);
                    res.add(list);

                    //跳过重复
                    while (left<right&&nums[left]==nums[left+1])left++;
                    while (left<right&&nums[right]==nums[right-1])right--;
                    left++;
                    right--;
                }
                else if(mid>nums[right])left++;
                else right--;
            }
        }
        else
        {
            for (int i=index;i<nums.length-k+1;i++)
            {
                List<List<Integer>> list=kSum(nums,target-nums[i],k-1,i+1);
                if(list.size()!=0)
                {
                    for (List<Integer> l:list)
                    {
                        l.add(nums[i]);
                    }
                    res.addAll(list);
                }
                //跳过重复
                while (i<nums.length-1&&nums[i]==nums[i+1])
                {
                    i++;
                }
            }
        }
        return res;
    }
}
/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
