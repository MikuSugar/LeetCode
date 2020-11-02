package JavaCode.contest.weekly.n0_200.n146;

public class N4 {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int res=0;
        int t1=arr1[0]+arr2[0];
        int t2=-arr1[0]-arr2[0];
        int t3=arr1[0]-arr2[0];
        int t4=-arr1[0]+arr2[0];
        for (int i=1;i<arr1.length;i++)
        {
            res=Math.max(res,t1+i-arr1[i]-arr2[i]);
            res=Math.max(res,t2+i+arr1[i]+arr2[i]);
            res=Math.max(res,t3+i-arr1[i]+arr2[i]);
            res=Math.max(res,t4+i+arr1[i]-arr2[i]);
            t1=Math.max(t1,arr1[i]+arr2[i]-i);
            t2=Math.max(t2,-arr1[i]-arr2[i]-i);
            t3=Math.max(t3,arr1[i]-arr2[i]-i);
            t4=Math.max(t4,-arr1[i]+arr2[i]-i);
        }
        return res;
    }
}
/**
 *给你两个长度相等的整数数组，返回下面表达式的最大值：
 *
 * |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
 *
 * 其中下标 i，j 满足 0 <= i, j < arr1.length。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr1 = [1,2,3,4], arr2 = [-1,4,5,6]
 * 输出：13
 * 示例 2：
 *
 * 输入：arr1 = [1,-2,-5,0,10], arr2 = [0,-2,-1,-7,-4]
 * 输出：20
 *
 *
 * 提示：
 *
 * 2 <= arr1.length == arr2.length <= 40000
 * -10^6 <= arr1[i], arr2[i] <= 10^6
 */
