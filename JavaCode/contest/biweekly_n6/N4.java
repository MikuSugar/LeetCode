package JavaCode.contest.biweekly_n6;

import java.util.Arrays;

public class N4 {
    public boolean canConvert(String str1, String str2) {
        if(str1.equals(str2))return true;
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int[] book=new int[26];
        Arrays.fill(book,-1);
        for(int i=0;i<s1.length;i++)
        {
            int x=s1[i]-'a';
            int y=s2[i]-'a';
            if(book[x]==-1)book[x]=y;
            else if(book[x]!=y)return false;
        }
        int has=0;
        for (int i:book)
        {
            has+=i!=-1?1:0;
        }
        boolean flag=false;
        for (int i=0;i<26;i++)
        {
            for (int j=i+1;j<26;j++)
            {
                if(book[i]!=-1&&book[i]==book[j])
                {
                    flag=true;
                    break;
                }
            }
        }
        if (has!=26)return true;
        if(flag)return true;
        return false;
    }
}
/**
 * 出两个长度相同的字符串，分别是 str1 和 str2。请你帮忙判断字符串 str1 能不能在 零次 或 多次 转化后变成字符串 str2。
 *
 * 每一次转化时，将会一次性将 str1 中出现的 所有 相同字母变成其他 任何 英文字母（见示例）。
 *
 * 只有在字符串 str1 能够通过上述方式顺利转化为字符串 str2 时才能返回 True，否则返回 False。​​
 *
 *
 *
 * 示例 1：
 *
 * 输入：str1 = "aabcc", str2 = "ccdee"
 * 输出：true
 * 解释：将 'c' 变成 'e'，然后把 'b' 变成 'd'，接着再把 'a' 变成 'c'。注意，转化的顺序也很重要。
 * 示例 2：
 *
 * 输入：str1 = "leetcode", str2 = "codeleet"
 * 输出：false
 * 解释：我们没有办法能够把 str1 转化为 str2。
 *
 *
 * 提示：
 *
 * 1 <= str1.length == str2.length <= 10^4
 * str1 和 str2 中都只会出现小写英文字母
 */
