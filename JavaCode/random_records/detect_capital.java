package JavaCode.RandomRecords;

public class detect_capital {
    class Solution {
        public boolean detectCapitalUse(String word) {

            //首字母是大写
            if(Character.isUpperCase(word.charAt(0)))
            {
                if(word.length()==1)
                {
                    return true;
                }

                //大写情况
                if(Character.isUpperCase(word.charAt(1)))
                {
                    for (int i = 2; i < word.length(); i++)
                    {
                        if (!Character.isUpperCase(word.charAt(i)))
                        {
                            return false;
                        }
                    }
                    return true;
                }
                //首字母大写情况
                else
                {
                    for(int i=2;i<word.length();i++)
                    {
                        if(Character.isUpperCase(word.charAt(i)))
                        {
                            return false;
                        }
                    }
                    return true;
                }
            }

            //首字母是小写
            else
            {
                for(int i=1;i<word.length();i++)
                {
                    if(Character.isUpperCase(word.charAt(i)))
                    {
                        return false;
                    }
                }
                return true;
            }
        }
    }
}
/**
 * https://leetcode-cn.com/problems/detect-capital/
 * 给定一个单词，你需要判断单词的大写使用是否正确。
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * 全部字母都是大写，比如"USA"。
 * 单词中所有字母都不是大写，比如"leetcode"。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 * 否则，我们定义这个单词没有正确使用大写字母。
 * 示例 1:
 * 输入: "USA"
 * 输出: True
 * 示例 2:
 * 输入: "FlaG"
 * 输出: False
 */
