package JavaCode.random_records.N401_500;

import java.util.ArrayList;
import java.util.List;

public class N500_keyboard_row {
    private final static byte[] book={1,2,2,1,0,1,1,1,0,1,1,1,2,2,0,0,0,0,1,0,0,2,0,2,0,2};

    public String[] findWords(String[] words) {
        List<String> res=new ArrayList<>(words.length/2+1);
        for (String s:words)
        {
            if(check(s))res.add(s);
        }
        return res.toArray(new String[res.size()]);
    }

    private boolean check(String s) {
        char[] str = s.toCharArray();
        byte target=book[str[0]>='a'?str[0]-'a':str[0]-'A'];
        for (char c:str)
        {
            if(book[c>='a'?c-'a':c-'A']!=target)return false;
        }
        return true;
    }
}
/**
 * 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。

 * 示例：
 *
 * 输入: ["Hello", "Alaska", "Dad", "Peace"]
 * 输出: ["Alaska", "Dad"]
 *  
 *
 * 注意：
 *
 * 你可以重复使用键盘上同一字符。
 * 你可以假设输入的字符串将只包含字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/keyboard-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
