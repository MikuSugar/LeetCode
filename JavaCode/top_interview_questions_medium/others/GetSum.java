package JavaCode.top_interview_questions_medium.others;

public class GetSum {
    public static void main(String[] args) {
        System.out.println(new GetSum().new Solution().getSum(5,9));
    }
    class Solution {

        /**
         * 如下规律：
         * 在没有进位的情况下a+b=a|b
         * 不算进位的加a+b=a^b   1^1=0 0^0=0 1^0=1 0^1=1
         * (a&b)<<1=需要补上的进位
         * 通过a&b来判断是否存在进位
         * @param a
         * @param b
         * @return
         */
        public int getSum(int a, int b) {
            if((a&b)==0)
            {
                return a|b;
            }
            return getSum(a^b,(a&b)<<1);
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/54/others/119/
 * 两整数之和
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 *
 * 示例 1:
 *
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 *
 * 输入: a = -2, b = 3
 * 输出: 1
 */
