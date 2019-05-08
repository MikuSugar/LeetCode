package JavaCode.random_records.N1_100;

public class N58_length_of_last_word {
    public int lengthOfLastWord(String s) {
        int res=0;
        int idx=s.length()-1;
        while (idx>=0&&s.charAt(idx)==' ')
        {
            idx--;
        }
        for (;idx>=0;idx--)
        {
            if(check(s.charAt(idx)))
            {
                res++;
            }
            else break;
        }
        return res;
    }
    private static boolean check(char c)
    {
        return (c>='a'&&c<='z')||(c>='A'&&c<='Z');
    }
}
/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 */
