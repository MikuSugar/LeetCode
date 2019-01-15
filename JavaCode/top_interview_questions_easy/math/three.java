package JavaCode.top_interview_questions_easy.math;

public class three
{
    class Solution {
        public boolean isPowerOfThree(int n) {
            return fun1(n);
        }

        //递归解法
        boolean fun0(int n)
        {
            if(n==3||n==1)
            {
                return true;
            }
            else if(n%3!=0||n==0)
            {
                return false;
            }
            return fun0(n/3);
        }

        //非递归解法
        boolean fun1(int n)
        {
            if(n<=0)
            {
                return false;
            }
            int max3=(int)Math.pow(3,(int)(Math.log(Integer.MAX_VALUE*1.0)/Math.log(3)));
            return max3%n==0;
        }


    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/25/math/62/
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 * 示例 1:
 * 输入: 27
 * 输出: true
 * 示例 2:
 * 输入: 0
 * 输出: false
 * 示例 3:
 * 输入: 9
 * 输出: true
 * 示例 4:
 * 输入: 45
 * 输出: false
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 */
