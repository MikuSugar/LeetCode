package JavaCode.random_records.N801_900;

/**
 * author:fangjie
 * time:2019/10/29
 */
public class N829_consecutive_numbers_sum {

    //(X+(X+K-1))*K/2=N
    //(2X+K-1)*k=2N  ==> N>(K-1)*K
    //2X+K-1=2N/k
    //X=(2N/K+1-K)/2
    //X=N/K+1/2-K/2;
    //X=(2N-K*K+K)/2K
    public int consecutiveNumbersSum(int N) {
        int res=0;
        for (int k=(int) Math.sqrt(2*N);k>=1;k--)
        {
            if(N>k*(k-1)/2&&(2*N-k*k+k)/2%k==0)
            {
                res++;
            }
        }
        return res;
    }
}
/*
给定一个正整数 N，试求有多少组连续正整数满足所有数字之和为 N?

示例 1:

输入: 5
输出: 2
解释: 5 = 5 = 2 + 3，共有两组连续整数([5],[2,3])求和后为 5。
示例 2:

输入: 9
输出: 3
解释: 9 = 9 = 4 + 5 = 2 + 3 + 4
示例 3:

输入: 15
输出: 4
解释: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
说明: 1 <= N <= 10 ^ 9

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/consecutive-numbers-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
