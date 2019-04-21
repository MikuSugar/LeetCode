package JavaCode.contest.spring_2019_02;

public class N3 {

    public int longestRepeatingSubstring(String S) {
        for (int len=S.length()-1;len>0;len--)
        {
            for (int i=0;i+len<S.length();i++)
            {
                String t= S.substring(i,i+len);
                String t2=S.substring(i+1);
                if(t2.indexOf(t)!=-1)return len;
            }
        }
        return 0;
    }
}


/**
 * 3. 最长重复子串  显示英文描述
 * 用户通过次数 2
 * 用户尝试次数 3
 * 通过次数 2
 * 提交次数 3
 * 题目难度 Medium
 * 给定字符串 S，找出最长重复子串的长度。如果不存在重复子串就返回 0。
 *
 *
 *
 * 示例 1：
 *
 * 输入："abcd"
 * 输出：0
 * 解释：没有重复子串。
 * 示例 2：
 *
 * 输入："abbaba"
 * 输出：2
 * 解释：最长的重复子串为 "ab" 和 "ba"，每个出现 2 次。
 * 示例 3：
 *
 * 输入："aabcaabdaab"
 * 输出：3
 * 解释：最长的重复子串为 "aab"，出现 3 次。
 * 示例 4：
 *
 * 输入："aaaaa"
 * 输出：4
 * 解释：最长的重复子串为 "aaaa"，出现 2 次。
 *
 *
 * 提示：
 *
 * 字符串 S 仅包含从 'a' 到 'z' 的小写英文字母。
 * 1 <= S.length <= 1500
 */
