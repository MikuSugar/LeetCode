package JavaCode.random_records.N901_1000;

import java.util.Arrays;

/**
 * author:fangjie
 * time:2019/11/18
 */
public class N905_sort_array_by_parity {
    public int[] sortArrayByParity(int[] A) {
        int left=0,right=A.length-1;
        while (left!=right)
        {
            while (left!=right&&A[left]%2==0)left++;
            while (right!=left&&A[right]%2==1)right--;
            int temp=A[left];
            A[left]=A[right];
            A[right]=temp;
        }
        return A;
    }
}
/*
给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。

你可以返回满足此条件的任何数组作为答案。

 

示例：

输入：[3,1,2,4]
输出：[2,4,3,1]
输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 

提示：

1 <= A.length <= 5000
0 <= A[i] <= 5000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sort-array-by-parity
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
