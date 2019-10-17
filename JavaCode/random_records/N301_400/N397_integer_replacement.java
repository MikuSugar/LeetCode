package JavaCode.random_records.N301_400;

/**
 * author:fangjie
 * time:2019/10/17
 */
public class N397_integer_replacement {
    public int integerReplacement(int n) {
        return slove(n);
    }

    private int slove(long n) {
        if(n==1)return 0;
        if(n%2==0)return 1+slove(n/2);
        return 1+Math.min(slove(n+1),slove(n-1));
    }
}
/**
 * 给定一个正整数 n，你可以做如下操作：
 *
 * 1. 如果 n 是偶数，则用 n / 2替换 n。
 * 2. 如果 n 是奇数，则可以用 n + 1或n - 1替换 n。
 * n 变为 1 所需的最小替换次数是多少？
 *
 * 示例 1:
 *
 * 输入:
 * 8
 *
 * 输出:
 * 3
 *
 * 解释:
 * 8 -> 4 -> 2 -> 1
 * 示例 2:
 *
 * 输入:
 * 7
 *
 * 输出:
 * 4
 *
 * 解释:
 * 7 -> 8 -> 4 -> 2 -> 1
 * 或
 * 7 -> 6 -> 3 -> 2 -> 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
