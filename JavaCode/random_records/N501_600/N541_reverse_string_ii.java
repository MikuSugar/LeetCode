package JavaCode.random_records.N501_600;

public class N541_reverse_string_ii {
    public String reverseStr(String s, int k) {
        StringBuilder res=new StringBuilder();
        int start=0;
        int len=s.length();
        while (len>=2*k)
        {
            res.append(new StringBuilder(s.substring(start,start+k)).reverse().append(s.substring(start+k,start+2*k)));
            start+=2*k;
            len-=2*k;
        }
        if(len<k)
        {
            res.append(new StringBuilder(s.substring(start)).reverse());
        }
        else
        {
            res.append(new StringBuilder(s.substring(start,start+k)).reverse().append(s.substring(start+k)));
        }
        return res.toString();
    }

}
/**
 * https://leetcode-cn.com/problems/reverse-string-ii/
 * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
 *
 * 示例:
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 * 要求:
 *
 * 该字符串只包含小写的英文字母。
 * 给定字符串的长度和 k 在[1, 10000]范围内。
 */
