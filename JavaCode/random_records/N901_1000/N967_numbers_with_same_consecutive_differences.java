package JavaCode.random_records.N901_1000;

import java.util.HashSet;
import java.util.Set;

public class N967_numbers_with_same_consecutive_differences {
    public int[] numsSameConsecDiff(int N, int K) {
            Set<Integer> set=new HashSet<>();
            for (int i=1;i<10;i++)
            {
                set.add(i);
            }
            for (int i=1;i<N;i++)
            {
                Set<Integer> tSet=new HashSet<>();
                for (int n:set)
                {
                    int t=n%10;
                    if(t-K>=0)
                    {
                        tSet.add(10*n+t-K);
                    }
                    if(K+t<10)
                    {
                        tSet.add(10*n+K+t);
                    }
                }
                set=tSet;
            }
            if(N==1) set.add(0);
            int[] res=new int[set.size()];
            int idx=0;
            for (int i:set)
            {
                res[idx++]=i;
            }
            return res;
    }
}
/**
 * 返回所有长度为 N 且满足其每两个连续位上的数字之间的差的绝对值为 K 的非负整数。
 *
 * 请注意，除了数字 0 本身之外，答案中的每个数字都不能有前导零。例如，01 因为有一个前导零，所以是无效的；但 0 是有效的。
 *
 * 你可以按任何顺序返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：N = 3, K = 7
 * 输出：[181,292,707,818,929]
 * 解释：注意，070 不是一个有效的数字，因为它有前导零。
 * 示例 2：
 *
 * 输入：N = 2, K = 1
 * 输出：[10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 *  
 *
 * 提示：
 *
 * 1 <= N <= 9
 * 0 <= K <= 9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/numbers-with-same-consecutive-differences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
