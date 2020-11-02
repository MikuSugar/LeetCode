package JavaCode.contest.weekly.n0_200.n154;

public class N2 {
    private int cur;
    public String reverseParentheses(String s) {
        StringBuilder res=new StringBuilder();
        char[] str=s.toCharArray();
        cur=0;
        while (cur<str.length)
        {
            if(str[cur]!='(')
            {
                res.append(str[cur++]);
            }
            else res.append(slove(str));
        }
        return res.toString();
    }

    private String slove(char[] str) {
        cur++;
        StringBuilder res=new StringBuilder();
        while (cur<str.length)
        {
            if(str[cur]=='(')
            {
                res.append(slove(str));
            }
            else if(str[cur]==')')break;
            else res.append(str[cur++]);
        }
        cur++;
        return res.reverse().toString();
    }
}
/**
 *给出一个字符串 s（仅含有小写英文字母和括号）。
 *
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 *
 * 注意，您的结果中 不应 包含任何括号。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "(abcd)"
 * 输出："dcba"
 * 示例 2：
 *
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 * 示例 3：
 *
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 * 示例 4：
 *
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 2000
 * s 中只有小写英文字母和括号
 * 我们确保所有括号都是成对出现的
 */
