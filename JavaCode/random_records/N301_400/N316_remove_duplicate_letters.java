package JavaCode.random_records.N301_400;

import java.util.Stack;

public class N316_remove_duplicate_letters {

    public String removeDuplicateLetters(String s) {
        int[] book=new int[26];
        char[] strs = s.toCharArray();
        for (char c:strs)
        {
            ++book[c-'a'];
        }
        boolean[] used=new boolean[26];
        Stack<Character> stack=new Stack<>();
        for (char c:strs)
        {
            book[c-'a']--;
            if(used[c-'a'])continue;
            while (!stack.isEmpty()&&stack.peek()>c&&book[stack.peek()-'a']>0)
            {
                char pop = stack.pop();
                used[pop-'a']=false;
            }
            stack.add(c);
            used[c-'a']=true;
        }
        char[] res=new char[stack.size()];
        int idx=res.length-1;
        while (!stack.isEmpty())
        {
            res[idx--]=stack.pop();
        }
        return new String(res);
    }
}
/**
 * 给定一个仅包含小写字母的字符串，去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 示例 1:
 *
 * 输入: "bcabc"
 * 输出: "abc"
 * 示例 2:
 *
 * 输入: "cbacdcbc"
 * 输出: "acdb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
