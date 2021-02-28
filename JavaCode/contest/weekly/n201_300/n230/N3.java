package JavaCode.contest.weekly.n201_300.n230;

import java.util.Arrays;

/**
 * author: fangjie
 * email: syfangjie@live.cn
 * date: 2021/2/28 11:02 上午
 */
public class N3 {
    public static void main(String[] args) {
         //[3,3,2,4,2,6,2]
        //[6,2,6,6,1,1,4,6,4,6,2,5,4,2,1]
        System.out.println(new N3().minOperations(new int[]{3,3,2,4,2,6,2},new int[]{6,2,6,6,1,1,4,6,4,6,2,5,4,2,1}));
    }
    public int minOperations(int[] nums1, int[] nums2) {
       int s1=0,s2=0;
       for (int i:nums1)s1+=i;
       for (int i:nums2)s2+=i;
       if(s1<s2)return slove(nums1,s1,nums2,s2);
       else return slove(nums2,s2,nums1,s1);
    }

    private int slove(int[] nums1, int s1, int[] nums2, int s2) {
        if(s1==s2)return 0;
        int[] arr=new int[nums1.length+nums2.length];
        int idx=0;
        for (int i:nums1)arr[idx++]=6-i;
        for (int i:nums2)arr[idx++]=i-1;
        Arrays.sort(arr);
        int s=0;
        int res=1;
        for (int i=arr.length-1;i>=0;i--){
            s+=arr[i];
            if(s>=s2-s1)return res;
            res++;
        }
        return -1;
    }

}
/*
给你两个长度可能不等的整数数组 nums1 和 nums2 。两个数组中的所有值都在 1 到 6 之间（包含 1 和 6）。

每次操作中，你可以选择 任意 数组中的任意一个整数，将它变成 1 到 6 之间 任意 的值（包含 1 和 6）。

请你返回使 nums1 中所有数的和与 nums2 中所有数的和相等的最少操作次数。如果无法使两个数组的和相等，请返回 -1 。



示例 1：

输入：nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
输出：3
解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
- 将 nums2[0] 变为 6 。 nums1 = [1,2,3,4,5,6], nums2 = [6,1,2,2,2,2] 。
- 将 nums1[5] 变为 1 。 nums1 = [1,2,3,4,5,1], nums2 = [6,1,2,2,2,2] 。
- 将 nums1[2] 变为 2 。 nums1 = [1,2,2,4,5,1], nums2 = [6,1,2,2,2,2] 。
示例 2：

输入：nums1 = [1,1,1,1,1,1,1], nums2 = [6]
输出：-1
解释：没有办法减少 nums1 的和或者增加 nums2 的和使二者相等。
示例 3：

输入：nums1 = [6,6], nums2 = [1]
输出：3
解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
- 将 nums1[0] 变为 2 。 nums1 = [2,6], nums2 = [1] 。
- 将 nums1[1] 变为 2 。 nums1 = [2,2], nums2 = [1] 。
- 将 nums2[0] 变为 4 。 nums1 = [2,2], nums2 = [4] 。


提示：

1 <= nums1.length, nums2.length <= 105
1 <= nums1[i], nums2[i] <= 6
 */
