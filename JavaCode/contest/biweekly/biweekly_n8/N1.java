package JavaCode.contest.biweekly.biweekly_n8;

public class N1 {
    public int countLetters(String S) {
        char[] s=S.toCharArray();
        int res=0;
        int left=0,right=0;
        while (right<s.length)
        {
            if(s[left]!=s[right])
            {
                int len=right-left;
                left=right;
                res+=(len+1)*len/2;
            }
            right++;
        }
        res+=(right-left+1)*(right-left)/2;
        return res;
    }
}
/**
 * 给你一个字符串 S，返回只含 单一字母 的子串个数。
 *
 * 示例 1：
 *
 * 输入： "aaaba"
 * 输出： 8
 * 解释：
 * 只含单一字母的子串分别是 "aaa"， "aa"， "a"， "b"。
 * "aaa" 出现 1 次。
 * "aa" 出现 2 次。
 * "a" 出现 4 次。
 * "b" 出现 1 次。
 * 所以答案是 1 + 2 + 4 + 1 = 8。
 * 示例 2:
 *
 * 输入： "aaaaaaaaaa"
 * 输出： 55
 *
 *
 * 提示：
 *
 * 1 <= S.length <= 1000
 * S[i] 仅由小写英文字母组成。
 */
