package JavaCode.contest.weekly.n0_200.n133;

public class N3 {


   //[8,20,6,2,20,17,6,3,20,8,12]
   //5
   //4
    public static void main(String[] args) {
        System.out.println(new N3().maxSumTwoNoOverlap(new int[]{8,20,6,2,20,17,6,3,20,8,12},4,5));
    }


    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int[] sum=new int[A.length+1];
        for (int i=1;i<=A.length;i++)
        {
            sum[i]=sum[i-1]+A[i-1];
        }
        int res=0;
        for (int i=0;i+L<=A.length;i++)
        {
            for (int j=i+L;j+M<=A.length;j++)
            {
                res=Math.max(res,sum[i+L]-sum[i]+sum[j+M]-sum[j]);
            }
            for (int j=0;j+M<=i;j++)
            {
                res=Math.max(res,sum[i+L]-sum[i]+sum[j+M]-sum[j]);
            }
        }
        return res;
    }


}
/**
 *给出非负整数数组 A ，返回两个非重叠（连续）子数组中元素的最大和，子数组的长度分别为 L 和 M。（这里需要澄清的是，长为 L 的子数组可以出现在长为 M 的子数组之前或之后。）
 *
 * 从形式上看，返回最大的 V，而 V = (A[i] + A[i+1] + ... + A[i+L-1]) + (A[j] + A[j+1] + ... + A[j+M-1]) 并满足下列条件之一：
 *
 *
 *
 * 0 <= i < i + L - 1 < j < j + M - 1 < A.length, 或
 * 0 <= j < j + M - 1 < i < i + L - 1 < A.length.
 *
 *
 * 示例 1：
 *
 * 输入：A = [0,6,5,2,2,5,1,9,4], L = 1, M = 2
 * 输出：20
 * 解释：子数组的一种选择中，[9] 长度为 1，[6,5] 长度为 2。
 * 示例 2：
 *
 * 输入：A = [3,8,1,3,2,1,8,9,0], L = 3, M = 2
 * 输出：29
 * 解释：子数组的一种选择中，[3,8,1] 长度为 3，[8,9] 长度为 2。
 * 示例 3：
 *
 * 输入：A = [2,1,5,6,0,9,5,0,3,8], L = 4, M = 3
 * 输出：31
 * 解释：子数组的一种选择中，[5,6,0,9] 长度为 4，[0,3,8] 长度为 3。
 *
 *
 * 提示：
 *
 * L >= 1
 * M >= 1
 * L + M <= A.length <= 1000
 * 0 <= A[i] <= 1000
 */
