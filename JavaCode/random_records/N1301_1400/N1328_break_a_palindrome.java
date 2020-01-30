package JavaCode.random_records.N1301_1400;

/**
 * author:fangjie
 * time:2020/1/30
 */
public class N1328_break_a_palindrome {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length()==1)return "";
        char[] strs=palindrome.toCharArray();
        for (int i=0;i<strs.length;i++)
        {
            if(strs.length%2!=0&&i==strs.length/2)continue;
            if(strs[i]!='a'){
                strs[i]='a';
                break;
            }
            else if(i==strs.length-1)
            {
                strs[i]='b';
                break;
            }
        }
        return new String(strs);
    }

}
/*
给你一个回文字符串 palindrome ，请你将其中 一个 字符用任意小写英文字母替换，使得结果字符串的字典序最小，且 不是 回文串。

请你返回结果字符串。如果无法做到，则返回一个空串。

 

示例 1：

输入：palindrome = "abccba"
输出："aaccba"
示例 2：

输入：palindrome = "a"
输出：""
 

提示：

1 <= palindrome.length <= 1000
palindrome 只包含小写英文字母。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/break-a-palindrome
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
