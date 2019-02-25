package JavaCode.RandomRecords;
import java.util.HashSet;
import java.util.Set;

public class N805_splitArraySameAverage
{
    public boolean splitArraySameAverage(int[] A)
    {

        int len=A.length;
        /**
         * 易得两个A数组的平均值等于B数组等于C数组
         * 设A、B、C的和分别为Sum、Sum1、Sum2，
         * 令k比n-k小
         * Sum/n=Sum1/k=Sum2/(n-k)→Sum*k/n=Sum1→Sum*k%n=0;
         */

        int sum=0;
        for (int n:A)
        {
            sum+=n;
        }
        int avg=sum/len;

        boolean res=false;
        for (int i=1;i<=len/2;i++)
        {
            if(sum*i%len==0)
            {
                res=true;
                break;
            }
        }
        if(!res) return res;

        Set<Integer>[] dp=new Set[len/2+1];//dp[i]表示i个数的和
        dp[0]=new HashSet<>();
        dp[0].add(0);
        for (int n:A)
        {
            for (int i=len/2;i>=1;i--)
            {
                if(dp[i-1]!=null)
                {
                    for (int j : dp[i - 1])
                    {
                        if (dp[i] == null) dp[i] = new HashSet<>();
                        dp[i].add(n + j);

                    }
                }
            }
        }

        for(int i=1;i<=len/2;i++)
        {
            if(sum*i%len==0&&dp[i].contains(sum*i/len))
            {
                return true;
            }
        }
        return false;
    }
}
/**
 * https://leetcode-cn.com/problems/split-array-with-same-average/
 * 给定的整数数组 A ，我们要将 A数组 中的每个元素移动到 B数组 或者 C数组中。（B数组和C数组在开始的时候都为空）
 *
 * 返回true ，当且仅当在我们的完成这样的移动后，可使得B数组的平均值和C数组的平均值相等，并且B数组和C数组都不为空。
 *
 * 示例:
 * 输入:
 * [1,2,3,4,5,6,7,8]
 * 输出: true
 * 解释: 我们可以将数组分割为 [1,4,5,8] 和 [2,3,6,7], 他们的平均值都是4.5。
 * 注意:
 *
 * A 数组的长度范围为 [1, 30].
 * A[i] 的数据范围为 [0, 10000].
 */
