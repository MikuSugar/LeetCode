package JavaCode.contest.n158;

/**
 * author:fangjie
 * time:2019/10/13
 */
public class N1 {
    public int balancedStringSplit(String s) {
        char[] strs=s.toCharArray();
        int res=0,cnt=0;
        for (char c:strs)
        {
            if(c=='R')cnt++;
            else cnt--;
            if(cnt==0)res++;
        }
        return res;
    }
}
/**
 * 在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
 *
 * 给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 *
 * 返回可以通过分割得到的平衡字符串的最大数量。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "RLRRLLRLRL"
 * 输出：4
 * 解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'。
 * 示例 2：
 *
 * 输入：s = "RLLLLRRRLR"
 * 输出：3
 * 解释：s 可以分割为 "RL", "LLLRRR", "LR", 每个子字符串中都包含相同数量的 'L' 和 'R'。
 * 示例 3：
 *
 * 输入：s = "LLLLRRRR"
 * 输出：1
 * 解释：s 只能保持原样 "LLLLRRRR".
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s[i] = 'L' 或 'R'
 */
