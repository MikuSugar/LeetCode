package JavaCode.array_and_string.conclusion;

public class ReverseWords_two {

    public static void main(String[] args) {
        System.out.println(new ReverseWords_two().reverseWords("Let's take LeetCode contest"));
    }

    public String reverseWords(String s) {
        if(s.equals("")) return s;

        String[] words=s.split("\\s+");

        StringBuilder sb=new StringBuilder();

        for(int i=0;i<words.length-1;i++)
        {

            sb.append(new StringBuilder(words[i]).reverse().toString()+" ");
        }
        sb.append(new StringBuilder(words[words.length-1]).reverse().toString());
        return sb.toString();

    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/array-and-string/202/conclusion/794/
 * 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例 1:
 *
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
