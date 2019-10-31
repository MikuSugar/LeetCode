package JavaCode.random_records.N301_400;

/**
 * author:fangjie
 * time:2019/10/31
 */
public class N321_create_maximum_number {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res=new int[k];
        int n=nums1.length,m=nums2.length;
        for (int i=Math.max(0,k-m);i<=k&&i<=n;i++)
        {
            int[] temp=merge(maxArray(nums1,i),maxArray(nums2,k-i),k);
            if(compareArray(temp,0,res,0))res=temp;
        }
        return res;
    }

    //栈
    private int[] maxArray(int[] nums,int k)
    {
        int[] res=new int[k];
        for (int i=0,j=0;i<nums.length;i++)
        {
            while (nums.length-i+j>k&&j>0&&res[j-1]<nums[i])j--;
            if(j<k)res[j++]=nums[i];
        }
        return res;
    }

    private int[] merge(int[] num1,int[] num2,int k)
    {
        int[] res=new int[k];
        for (int i=0,j=0,cur=0;cur<k;cur++)
        {
            res[cur]=compareArray(num1,i,num2,j)?num1[i++]:num2[j++];
        }
        return res;
    }

    private boolean compareArray(int[] num1, int i, int[] num2, int j) {
        while (i<num1.length&&j<num2.length&&num1[i]==num2[j])
        {
            i++;j++;
        }
        return j==num2.length||(i<num1.length&&num1[i]>num2[j]);
    }
}
/*
给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。

求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。

说明: 请尽可能地优化你算法的时间和空间复杂度。

示例 1:

输入:
nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5
输出:
[9, 8, 6, 5, 3]
示例 2:

输入:
nums1 = [6, 7]
nums2 = [6, 0, 4]
k = 5
输出:
[6, 7, 6, 0, 4]
示例 3:

输入:
nums1 = [3, 9]
nums2 = [8, 9]
k = 3
输出:
[9, 8, 9]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/create-maximum-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
