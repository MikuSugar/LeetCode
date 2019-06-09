package JavaCode.contest.n140;


import java.util.Stack;

public class N4 {

    public String smallestSubsequence(String text) {
        int[] cnt=new int[26];
        char[] texts = text.toCharArray();
        for (char c:texts)
        {
            cnt[c-'a']++;
        }
        Stack<Character> stack=new Stack<>();
        boolean[] book =new boolean[26];
        for (char c:texts)
        {
            cnt[c-'a']--;
            if(book[c-'a'])continue;
            if(stack.isEmpty())
            {
                stack.add(c);
                book[c-'a']=true;
            }
            else
            {
                while (!stack.isEmpty())
                {
                    Character peek = stack.peek();
                    if(cnt[peek-'a']>0&&(peek-'a'>c-'a'))
                    {
                        stack.pop();
                        book[peek-'a']=false;
                    }
                    else break;
                }
                if(!book[c-'a'])
                {
                    stack.add(c);
                    book[c-'a']=true;
                }
            }

        }
        StringBuilder sb=new StringBuilder();
        while (!stack.isEmpty())
        {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
/**
 *返回字符串 text 中按字典序排列最小的子序列，该子序列包含 text 中所有不同字符一次。
 *
 *
 *
 * 示例 1：
 *
 * 输入："cdadabcc"
 * 输出："adbc"
 * 示例 2：
 *
 * 输入："abcd"
 * 输出："abcd"
 * 示例 3：
 *
 * 输入："ecbacba"
 * 输出："eacb"
 * 示例 4：
 *
 * 输入："leetcode"
 * 输出："letcod"
 *
 *
 * 提示：
 *
 * 1 <= text.length <= 1000
 * text 由小写英文字母组成
 */
