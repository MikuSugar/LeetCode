package JavaCode.top_interview_questions_easy.strings;

public class four {

    /**
     * 一开始理解错了题意，其实这题应该很简单的。只要判断字母出现的次数是否一致即可
     */
    class Solution {
        public boolean isAnagram(String s, String t) {
            if(s.length()!=t.length())
            {
                return false;
            }

            char[] s1=s.toCharArray();
            char[] s2=t.toCharArray();

            int[] sbook=new int[256];
            int[] tbook=new int[256];

            for(int i=0;i<s1.length;i++)
            {
                sbook[s1[i]]++;
                tbook[s2[i]]++;
            }

            for(int i=0;i<sbook.length;i++)
            {
                if(sbook[i]!=tbook[i])
                {
                    return false;
                }
            }
            return true;

        }

    }
}

/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/35/
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
