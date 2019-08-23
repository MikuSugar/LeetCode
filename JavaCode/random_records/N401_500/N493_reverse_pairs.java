package JavaCode.random_records.N401_500;

public class N493_reverse_pairs {
    public int reversePairs(int[] nums) {
        return slove(nums,0,nums.length-1);
    }
    private int slove(int[] nums, int left, int right) {
        if(left>=right)return 0;
        int mid=left+((right-left)>>1);
        int res=slove(nums,left,mid)+slove(nums,mid+1,right);
        int i=left,j=mid+1,k=0,p=mid+1;
        int[] merge=new int[right-left+1];
        while (i <= mid) {
            while (p <= right && nums[i] > 2l* nums[p]) p++;
            res +=p-(mid+ 1);
            while (j <=right&& nums[i] >= nums[j]) merge[k++] = nums[j++];
            merge[k++] = nums[i++];
        }
        while (j <=right) merge[k++] = nums[j++];
        System.arraycopy(merge, 0, nums,left, merge.length);
        return res;
    }
}
/**
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 *
 * 你需要返回给定数组中的重要翻转对的数量。
 *
 * 示例 1:
 *
 * 输入: [1,3,2,3,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [2,4,3,5,1]
 * 输出: 3
 * 注意:
 *
 * 给定数组的长度不会超过50000。
 * 输入数组中的所有数字都在32位整数的表示范围内。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
