package JavaCode.contest.weekly.n0_200.n92;



//参考：https://leetcode.com/problems/prime-palindrome/discuss/146798/Search-Palindrome-with-Odd-Digits
public class N3 {
    public int primePalindrome(int N)
    {
        if (N <= 11) {
            if (N <= 2)
                return 2;
            else if (N == 3)
                return 3;
            else if (N <= 5)
                return 5;
            else if (N <= 7)
                return 7;
            else
                return 11;
        }
        for (int x=1;x<100000;x++)
        {
            //比较奇葩的获取回文数的方法，偶数位的回文数不可能是素数
            String s=Integer.toString(x);
            int y=Integer.parseInt(s+new StringBuilder(s).reverse().toString().substring(1));
            if(y>=N&&check(y))
            {
                return y;
            }
        }
        return -1;
    }

    private boolean check(int x) {
        if (x<2||x%2==0)return x==2;
        for (int i=3;i*i<=x;i+=2)
            if (x%i == 0) return false;
        return true;
    }

}
/**
 *  866. 回文素数  显示英文描述
 * 用户通过次数 12
 * 用户尝试次数 100
 * 通过次数 12
 * 提交次数 413
 * 题目难度 Medium
 * 求出大于或等于 N 的最小回文素数。
 *
 * 回顾一下，如果一个数大于 1，且其因数只有 1 和它自身，那么这个数是素数。
 *
 * 例如，2，3，5，7，11 以及 13 是素数。
 *
 * 回顾一下，如果一个数从左往右读与从右往左读是一样的，那么这个数是回文数。
 *
 * 例如，12321 是回文数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：6
 * 输出：7
 * 示例 2：
 *
 * 输入：8
 * 输出：11
 * 示例 3：
 *
 * 输入：13
 * 输出：101
 */
