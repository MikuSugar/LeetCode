package JavaCode.random_records;

public class N926_flip_string_to_monotone_increasing {

    private int zero_cnt;
    private char[] c;

    public int minFlipsMonoIncr(String S) {
        zero_cnt=0;
        c=S.toCharArray();
        return fun(0);
    }

    private int fun(int index)
    {
        if(index==c.length)return 0;
        int res=Integer.MAX_VALUE>>1;
        if(c[index]=='0')
        {
            res=fun(index+1);
            zero_cnt++;
        }
        else
        {
            res=fun(index+1)+1;
            res=Math.min(zero_cnt,res);
        }
        return res;
    }
}
/**
 * https://leetcode-cn.com/problems/flip-string-to-monotone-increasing/
 * 如果一个由 '0' 和 '1' 组成的字符串，是以一些 '0'（可能没有 '0'）后面跟着一些 '1'（也可能没有 '1'）的形式组成的，那么该字符串是单调递增的。
 *
 * 我们给出一个由字符 '0' 和 '1' 组成的字符串 S，我们可以将任何 '0' 翻转为 '1' 或者将 '1' 翻转为 '0'。
 *
 * 返回使 S 单调递增的最小翻转次数。
 *
 *
 *
 * 示例 1：
 *
 * 输入："00110"
 * 输出：1
 * 解释：我们翻转最后一位得到 00111.
 * 示例 2：
 *
 * 输入："010110"
 * 输出：2
 * 解释：我们翻转得到 011111，或者是 000111。
 * 示例 3：
 *
 * 输入："00011000"
 * 输出：2
 * 解释：我们翻转得到 00000000。
 */
