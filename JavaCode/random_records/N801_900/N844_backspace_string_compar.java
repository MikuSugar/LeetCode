package JavaCode.random_records.N801_900;

import java.util.Stack;

public class N844_backspace_string_compar {
    public boolean backspaceCompare(String S, String T) {
        S=help(S);
        T=help(T);
        return S.equals(T);
    }

    private String help(String s) {
        Stack<Character> stack=new Stack<>();
        for (int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(c=='#')
            {
                if(!stack.isEmpty()) stack.pop();
                continue;
            }
            stack.push(c);
        }
        StringBuilder res=new StringBuilder("");
        while (!stack.isEmpty())
            res.append(stack.pop());
        return res.reverse().toString();
    }
}
/**
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 *
 *
 * 示例 1：
 *
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 *
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 *
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 *
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *
 *
 * 提示：
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 */
