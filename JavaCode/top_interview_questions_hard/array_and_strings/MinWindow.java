package JavaCode.top_interview_questions_hard.array_and_strings;

public class MinWindow {

    public String minWindow(String s, String t) {
        int[] tt=new int[255];
        for (char c:t.toCharArray())
        {
            tt[c]++;
        }

        int cnt=0;
        int left=0;
        int right=0;
        int res=Integer.MAX_VALUE;
        int start=0;

        while (right<s.length())
        {
            if(tt[s.charAt(right)]>0)
            {
                cnt++;
            }
            tt[s.charAt(right)]--;
            right++;

            while (cnt==t.length())
            {
                if(right-left<res)
                {
                    res=right-left;
                    start=left;
                }

                if(tt[s.charAt(left)]==0)
                {
                    cnt--;
                }
                tt[s.charAt(left)]++;
                left++;
            }
        }
        return res==Integer.MAX_VALUE?"":s.substring(start,start+res);
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/55/array-and-strings/133/
 * 最小窗口子字符串
 * 给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
