package JavaCode.random_records;

public class N917_reverseOnlyLetters
{
    public String reverseOnlyLetters(String S) {
        int left=0;
        int right=S.length()-1;
        StringBuilder sb=new StringBuilder(S);
        while (left<right)
        {
            char l=S.charAt(left);
            char r=S.charAt(right);
            if(!isLetter(l))
            {
                left++;
                continue;
            }
            if(!isLetter(r))
            {
                right--;
                continue;
            }
            sb.setCharAt(left,r);
            sb.setCharAt(right,l);
        }
        return sb.toString();
    }

    private boolean isLetter(char c)
    {
        return (c>='a'&&c<='z')||(c>='A'&&c<='Z');
    }
}
/**
 * https://leetcode-cn.com/problems/reverse-only-letters/
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 *
 *
 *
 * 示例 1：
 *
 * 输入："ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 *
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * 示例 3：
 *
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 *
 *
 * 提示：
 *
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122
 * S 中不包含 \ or "
 */
