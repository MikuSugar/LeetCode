package JavaCode.top_interview_questions_easy.math;

public class PrimeCounter
{
    public static void main(String[] args)
    {
        System.out.println(new PrimeCounter().new Solution().countPrimes(2000000));
    }
    class Solution {
        public int countPrimes(int n) {
//            int sum=0;
//            for(int i=2;i<n;i++)
//            {
//                if(isPrime(i))
//                {
//                    sum++;
//                }
//            }
//            return sum;

            return getCount(n);
        }


        /**
         * 埃拉托斯特尼筛法
         * @param n
         * @return 到n的个数
         */
        int getCount(int n)
        {
            boolean[] isP=new boolean[n];
            int sum=0;
            for(int i=2;i<n;i++)
            {
                isP[i]=true;
            }

            int len=(int)Math.sqrt(n);
            for(int i=2;i<=len;i++)
            {
                if(isP[i])
                {
                    for(int j=i*i;j<n;j+=i)
                    {
                        isP[j]=false;
                    }
                }
            }

            for(int i=2;i<n;i++)
            {
                if(isP[i])
                {
                    sum++;
                }
            }

            return sum;
        }

        /**暴力
         * 判断是否为素数
         * @param n 需要判断的数
         * @return
         */
        boolean isPrime(int n)
        {
            if(n<=1)
            {
                return false;
            }

            for(int i=2;i<=Math.sqrt(n);i++)
            {
                if(n%i==0)
                {
                    return false;
                }
            }
            return true;
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/25/math/61/
 * 统计所有小于非负整数 n 的质数的数量。
 * 示例:
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
