package JavaCode.top_interview_questions_medium.math;

public class HappyNumber {
    class Solution {
        public boolean isHappy(int n) {
            while (true)
            {
                if(n==1) return true;
                if(n==4) break;//快乐数规律，只要出现4，必定会无限循环，不是快乐数
                int sum=0;
                while (n>0)
                {
                    int x=n%10;
                    sum+=x*x;
                    n=n/10;
                }
                n=sum;
            }
            return false;
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/53/math/112/
 * 快乐数
 * 编写一个算法来判断一个数是不是“快乐数”。
 *
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例:
 *
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
