package JavaCode.random_records.N801_900;


public class N856_score_of_parentheses {
    public static void main(String[] args) {
        System.out.println(new N856_score_of_parentheses().scoreOfParentheses("()()"));
    }
    private int cur;
    public int scoreOfParentheses(String S) {
        this.cur=0;
        int res=0;
        char[] chars = S.toCharArray();
        while (cur<S.length())
        {
            res+=solve(chars);
        }
        return res;
    }

    private int solve( char[] s) {
       int res=0;
       cur++;
       while (s[cur]=='(')
       {
           res+=solve(s);
       }
       cur++;
       return res==0?1:res*2;
    }
}
/**
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 *
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 *  
 *
 * 示例 1：
 *
 * 输入： "()"
 * 输出： 1
 * 示例 2：
 *
 * 输入： "(())"
 * 输出： 2
 * 示例 3：
 *
 * 输入： "()()"
 * 输出： 2
 * 示例 4：
 *
 * 输入： "(()(()))"
 * 输出： 6
 *  
 *
 * 提示：
 *
 * S 是平衡括号字符串，且只含有 ( 和 ) 。
 * 2 <= S.length <= 50
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/score-of-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
