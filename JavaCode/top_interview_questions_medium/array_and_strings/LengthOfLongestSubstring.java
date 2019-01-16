package JavaCode.top_interview_questions_medium.array_and_strings;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring
{
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character,Integer> map=new HashMap<>();
            int max=0;

            int top;//头指针
            int tail;//尾指针
            for(top=0,tail=0;top<s.length();top++)
            {
                if(map.containsKey(s.charAt(top)))
                {
                    int temp=map.get(s.charAt(top));
                    if(temp>=tail)
                    {
                        tail = temp + 1;
                    }
                }
                map.put(s.charAt(top),top);
                max=Math.max(max,top-tail+1);
            }

            return max;

        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/29/array-and-strings/78/
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
