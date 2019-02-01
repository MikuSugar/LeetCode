package JavaCode.binary_search.conclusion;

public class IsPerfectSquare {

    public static void main(String[] args) {
        System.out.println(new IsPerfectSquare().isPerfectSquare(808201));
    }
    public boolean isPerfectSquare(int num) {

        if(num==1) return true;

        int left=2;
        int right=num/2;
        while (left<=right)
        {
            int mid=left+(right-left)/2;
            long temp=(long)mid*mid;
            if(temp==num) return true;
            else if(temp>num)
            {
                right=mid-1;
            }
            else
            {
                left=mid+1;
            }
        }
        return false;
    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/binary-search/213/conclusion/851/
 * 有效的完全平方数
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 *
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 示例 1：
 *
 * 输入：16
 * 输出：True
 * 示例 2：
 *
 * 输入：14
 * 输出：False
 */
