package JavaCode.top_interview_questions_medium.math;

public class Sqrt {

    public static void main(String[] args) {
        System.out.println(new Sqrt().new Solution().mySqrt(Integer.MAX_VALUE));
    }
    class Solution {
        public int mySqrt(int x) {
            if(x==0||x==1)return x;
            int start=0;
            int end=x;
            //优化end
            for(int i=0;;i++) {
                int temp = (int) (x / Math.pow(2, i));
                if (temp < Math.pow(2, i)) {
                    end = x >> (i - 1);
                    break;
                }
            }
            while (start<=end)
            {
                int mid=(start+end)>>1;
                long temp=(long)mid*mid;
                if(temp==x)return mid;
                else if(temp>x)
                {
                    end=mid-1;
                }
                else
                {
                    start=mid+1;
                }
            }
            return start-1;
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/53/math/116/
 *实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
