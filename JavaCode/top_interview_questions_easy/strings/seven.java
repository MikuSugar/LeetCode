package JavaCode.top_interview_questions_easy.strings;

public class seven {
    class Solution {
        public int strStr(String haystack, String needle) {
           return fun0(haystack,needle);
        }

        /**
         * 暴力解法
         * @param haystack
         * @param needle
         * @return
         */
        int fun0(String haystack,String needle)
        {
            if(needle.length()==0)
            {
                return 0;
            }

            char[] s=haystack.toCharArray();
            char[] n=needle.toCharArray();

            for(int i=0;i<s.length;i++)
            {
                if(s[i]==n[0])
                {
                    int j=i+1;
                    int k=1;
                    boolean flag=true;
                    for(;j<s.length&&k<n.length;j++,k++)
                    {
                        if(s[j]!=n[k])
                        {
                            flag=false;
                            break;
                        }
                    }
                    if((k-1)!=n.length)
                    {
                        flag=false;
                    }
                    if(flag)
                    {
                        return i;
                    }

                }
            }

            return -1;
        }

        //优化fun0()
        int fun1(String haystack,String needle)
        {
            if(needle.length()==0)
            {
                return 0;
            }

            char[] s=haystack.toCharArray();
            char[] n=needle.toCharArray();

            //减少循环次数
            for(int i=0;i<s.length-n.length+1;i++)
            {
                if(s[i]==n[0])
                {
                    int j=i+1;
                    int k=1;
                    boolean flag=true;
                    for(;j<s.length&&k<n.length;j++,k++)
                    {
                        if(s[j]!=n[k])
                        {
                            flag=false;
                            break;
                        }
                    }
                    if((k-1)!=n.length)
                    {
                        flag=false;
                    }
                    if(flag)
                    {
                        return i;
                    }

                }
            }

            return -1;
        }

    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/38/
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
