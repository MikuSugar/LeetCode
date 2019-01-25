package JavaCode.queue_stack.conclusion;

import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("2[1[F]c2[a]]ef"));
    }

    public String decodeString(String s) {
        Stack<Integer> numberStack=new Stack<>();
        Stack<String> wordStack=new Stack<>();

        String result="";
        int cnt=0;

        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(c>='0'&&c<='9')
            {
                cnt=10*cnt+c-'0';
            }
            else if(c=='[')
            {
                wordStack.push(result);
                result="";
                numberStack.push(cnt);
                cnt=0;
            }
            else if(c==']')
            {
                int k=numberStack.pop();
                StringBuilder sb=new StringBuilder(wordStack.pop());
                for(int j=0;j<k;j++)
                {
                    sb.append(result);
                }
                result=sb.toString();
            }
            else
            {
                result+=c;
            }
        }

        return result;
    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/queue-stack/220/conclusion/890/
 * 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 *
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */
