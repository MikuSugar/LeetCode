package JavaCode.top_interview_questions_medium.math;

public class Divide {
    public static void main(String[] args) {
        System.out.println(new Divide().new Solution().divide(59,-5));
    }

    class Solution {
        public int divide(int dividend, int divisor) {
            if(dividend==Integer.MIN_VALUE&&divisor==-1) return Integer.MAX_VALUE;
            if(Math.abs((long)dividend)<Math.abs((long)divisor)) return 0;
            boolean flag=true;//商是否是正数标志符号
            if((dividend>0&&divisor<0)||(dividend<0&&divisor>0)) flag=false;

            long de=Math.abs((long)dividend);
            long di=Math.abs((long)divisor);
            int cnt=0;

            while (de>=di)
            {
                long temp=di;
                int cnt_temp=1;
                while (de>(temp<<1))
                {
                    temp<<=1;
                    cnt_temp<<=1;
                }
                cnt+=cnt_temp;
                de-=temp;
            }

            if(!flag) return -cnt;
            return cnt;
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/53/math/117/
 * 两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 */
