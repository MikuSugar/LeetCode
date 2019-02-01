package JavaCode.binary_search.template_i;

import java.util.Random;

/**
 * 模拟下面描述的api,方便编写代码
 */
/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */
class GuessGame
{
    private int number=6;
    public int guess(int num)
    {
        if(num==number) return 0;
        if(num>number) return -1;
        return 1;
    }
}

public class GuessNumber extends GuessGame {

    public static void main(String[] args) {
        System.out.println(new GuessNumber().guessNumber(10));
    }

    public int guessNumber(int n) {
        int left=1;
        int right=n;
        while (left<=right)
        {
            int mid=left+(right-left)/2;
            int i=guess(mid);
            if(i==0)return mid;
            else if(i==1)left=mid+1;
            else right=mid-1;
        }
        return -1;
    }
}

/**
 * https://leetcode-cn.com/explore/learn/card/binary-search/209/template-i/837/
 * 猜数字大小
 * 我们正在玩一个猜数字游戏。 游戏规则如下：
 * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
 * 每次你猜错了，我会告诉你这个数字是大了还是小了。
 * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
 *
 * -1 : 我的数字比较小
 *  1 : 我的数字比较大
 *  0 : 恭喜！你猜对了！
 * 示例 :
 *
 * 输入: n = 10, pick = 6
 * 输出: 6
 */

