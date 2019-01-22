package JavaCode.top_interview_questions_medium.math;

public class Pow {
    public static void main(String[] args) {
        System.out.println(new Pow().new Solution().myPow(-1,Integer.MIN_VALUE));
    }
    class Solution {

        //公式 x^n = x^(n / 2) *  x^(n / 2) * x^(n % 2)
        public double myPow(double x, int n) {
            if(x==1)return 1;
            if(x==-1)
            {
                if(n%2==0) return 1;
                else return -1;
            }
            if(n>=0) return fun(x,n);
            else return 1/fun(x,-n);

        }

        //递归求解
        double fun(double x,int n)
        {
            if(n==0) return 1;
            double ans=fun(x,n/2);
            if(n%2==0)
                return ans*ans;
            else
                return ans*ans*x;
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/53/math/115/
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 */
