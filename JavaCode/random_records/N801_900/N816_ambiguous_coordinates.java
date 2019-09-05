package JavaCode.random_records.N801_900;

import java.util.ArrayList;
import java.util.List;

public class N816_ambiguous_coordinates {
    public List<String> ambiguousCoordinates(String S) {
        List<String> res=new ArrayList<>();
        S=S.substring(1,S.length()-1);
        for (int i=1;i<=S.length()-1;i++)
        {
            String left = S.substring(0, i);
            String right = S.substring(i);
            if(!check(left)||!check(right))continue;
            List<String> l=help(left);
            List<String> r=help(right);
            for (String ll:l)
            {
                for (String rr:r)
                {
                    res.add("("+ll+", "+rr+")");
                }
            }
        }
        return res;
    }

    private List<String> help(String s) {
        List<String> res=new ArrayList<>();
        if(checkNum(s))res.add(s);
        for (int i=1;i<=s.length()-1;i++)
        {
            String num=s.substring(0,i)+"."+s.substring(i);
            if(checkNum(num))res.add(num);
        }
        return res;
    }

    private boolean check(String s)
    {
        if(s.isEmpty())return false;
        if(s.length()==1)return true;
        char[] chars = s.toCharArray();
        if(chars[0]=='0'&&chars[chars.length-1]=='0')return false;
        return true;
    }
    private boolean checkNum(String s)
    {
        if(s.isEmpty())return false;
        if(s.length()==1)return true;
        if(s.charAt(0)=='0'&&s.charAt(1)=='0')return false;
        if(s.contains("."))
        {
            if(s.indexOf('.')!=1&&s.charAt(0)=='0')return false;
            if(s.charAt(s.length()-1)=='0')return false;
        }
        else if(s.charAt(0)=='0')return false;
        return true;
    }
}
/**
 * 我们有一些二维坐标，如 "(1, 3)" 或 "(2, 0.5)"，然后我们移除所有逗号，小数点和空格，得到一个字符串S。返回所有可能的原始字符串到一个列表中。
 *
 * 原始的坐标表示法不会存在多余的零，所以不会出现类似于"00", "0.0", "0.00", "1.0", "001", "00.01"或一些其他更小的数来表示坐标。此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。
 *
 * 最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。
 *
 *  
 *
 * 示例 1:
 * 输入: "(123)"
 * 输出: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
 * 示例 2:
 * 输入: "(00011)"
 * 输出:  ["(0.001, 1)", "(0, 0.011)"]
 * 解释:
 * 0.0, 00, 0001 或 00.01 是不被允许的。
 * 示例 3:
 * 输入: "(0123)"
 * 输出: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"]
 * 示例 4:
 * 输入: "(100)"
 * 输出: [(10, 0)]
 * 解释:
 * 1.0 是不被允许的。
 *  
 *
 * 提示:
 *
 * 4 <= S.length <= 12.
 * S[0] = "(", S[S.length - 1] = ")", 且字符串 S 中的其他元素都是数字。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ambiguous-coordinates
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
