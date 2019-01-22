package JavaCode.top_interview_questions_medium.math;

public class TrailingZeroes {
    public static void main(String[] args) {
        System.out.println(new TrailingZeroes().new Solution().trailingZeroes(50));
    }
    class Solution {
        public int trailingZeroes(int n) {

            int cnt=0;
            while (n>0)
            {
                n=n/5;
                cnt+=n;
            }
            return cnt;
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/53/math/113/
 * 阶乘后的零
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 */
