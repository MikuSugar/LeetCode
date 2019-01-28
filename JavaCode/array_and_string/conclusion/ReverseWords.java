package JavaCode.array_and_string.conclusion;

public class ReverseWords {

    public static void main(String[] args) {
        System.out.println(new ReverseWords().reverseWords("blue is sky the ")+"1");
    }

    public String reverseWords(String s) {
        String[] words=s.split("\\s+");
        if(words.length==0||s.equals("")) return "";
        StringBuilder sb=new StringBuilder();
        int k=0;
        if(words[0].equals("")) k=1;
        for(int i=words.length-1;i>k;i--)
        {
            sb.append(words[i]+" ");
        }
        sb.append(words[k]);
        return sb.toString();
    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/array-and-string/202/conclusion/793/
 * 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 示例:
 *
 * 输入: "the sky is blue",
 * 输出: "blue is sky the".
 * 说明:
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 进阶: 请选用C语言的用户尝试使用 O(1) 空间复杂度的原地解法。
 */
