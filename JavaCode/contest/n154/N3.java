package JavaCode.contest.n154;

public class N3 {
    private final static int MOD=(int) (1e9+7);
    public int kConcatenationMaxSum(int[] arr, int k) {
        if(k==1)
        {
            long max=getMax(arr);
            return (int)(max%MOD);
        }
        long max=getMax(help(arr));
        if(max==0)return 0;
        long sum=getSum(arr);
        long preMax=getPreMax(arr);
        long lastMax=getLastMax(arr);
        long tar=preMax+lastMax;
        if(tar<=0)return (int) (max%MOD);
        long temp=tar+sum*(k-2);
        return (int) (Math.max(temp,max)%MOD);
    }

    private int[] help(int[] arr) {
        int[] res=new int[arr.length*2];
        System.arraycopy(arr,0,res,0,arr.length);
        System.arraycopy(arr,0,res,arr.length,arr.length);
        return res;
    }

    private long getLastMax(int[] arr) {
       int sum=0;
       int res=0;
       for (int i:arr)
       {
           sum+=i;
           res=Math.max(res,sum);
       }
       return res;
    }

    private long getPreMax(int[] arr) {
        int sum=0;
        int res=0;
        for (int i=arr.length-1;i>=0;i--)
        {
            sum+=arr[i];
            res=Math.max(res,sum);
        }
        return res;
    }

    private long getSum(int[] arr) {
        long sum=0;
        for (int i:arr)
        {
            sum+=i;
        }
        return sum;
    }

    private long getMax(int[] arr) {
        long sum=0;
        long max=0;
        for (int i:arr)
        {
            sum+=i;
            if(sum>max) max=sum;
            if(sum<0)sum=0;
        }
        return max;
    }
}
/**
 *给你一个整数数组 arr 和一个整数 k。
 *
 * 首先，我们要对该数组进行修改，即把原数组 arr 重复 k 次。
 *
 * 举个例子，如果 arr = [1, 2] 且 k = 3，那么修改后的数组就是 [1, 2, 1, 2, 1, 2]。
 *
 * 然后，请你返回修改后的数组中的最大的子数组之和。
 *
 * 注意，子数组长度可以是 0，在这种情况下它的总和也是 0。
 *
 * 由于 结果可能会很大，所以需要 模（mod） 10^9 + 7 后再返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [1,2], k = 3
 * 输出：9
 * 示例 2：
 *
 * 输入：arr = [1,-2,1], k = 5
 * 输出：2
 * 示例 3：
 *
 * 输入：arr = [-1,-2], k = 7
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^5
 * 1 <= k <= 10^5
 * -10^4 <= arr[i] <= 10^4
 */
