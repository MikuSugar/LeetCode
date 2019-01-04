package JavaCode;
class Solution {
    public void rotate(int[] nums, int k) {
        for(int i=0;i<k%nums.length;i++)
        {
            move(nums);
        }
    }

    /**
     * 向右移动数组一个单位
     * @param nums
     */
    public void move(int[] nums)
    {
        int t1=nums[nums.length-1];
        int t2;
        for(int i=0;i<nums.length;i++)
        {
            t2=nums[i];
            nums[0]=t1;
            t1=t2;
        }
    }
}