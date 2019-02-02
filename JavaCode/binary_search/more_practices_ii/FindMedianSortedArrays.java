package JavaCode.binary_search.more_practices_ii;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        int len=len1+len2;

        if(len%2==0)
        {
            return (fundKth(nums1,0,len1,nums2,0,len2,len/2)+fundKth(nums1,0,len1,nums2,0,len2,len/2+1))/2;
        }
        return fundKth(nums1,0,len1,nums2,0,len2,len/2+1);
    }

    /**
     * 找到第k个小的数
     * @param nums1
     * @param start1
     * @param len1
     * @param nums2
     * @param start2
     * @param len2
     * @param k
     * @return
     */
    double fundKth(int[] nums1,int start1,int len1,int[] nums2,int start2,int len2,int k )
    {
        if(len1-start1>len2-start2)
        {
            return fundKth(nums2,start2,len2,nums1,start1,len1,k);
        }

        //nums1全部已经加入前k中
       if(len1-start1==0)
        {
            return nums2[k-1];
        }

       //第k-1小的数
        if(k==1)
        {
            return Math.min(nums1[start1],nums2[start2]);
        }


        //常规情况
        int p1=start1+Math.min(len1-start1,k/2);
        int p2=start2+k-p1+start1;//p1-start1+p2-start2=k

        if(nums1[p1-1]<nums2[p2-1])
        {
            return fundKth(nums1,p1,len1,nums2,start2,len2,k-p1+start1);
        }
        else if(nums1[p1-1]>nums2[p2-1])
        {
            return fundKth(nums1,start1,len1,nums2,p2,len2,k-p2+start2);
        }
        else
        {
            return nums1[p1-1];
        }

    }


}
/**
 * https://leetcode-cn.com/explore/learn/card/binary-search/215/more-practices-ii/859/
 * 寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 */
