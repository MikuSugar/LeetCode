package JavaCode.random_records.N1401_1500;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * author:fangjie
 * time:2020/4/22
 */
public class N1417_reformat_the_string {
    public String reformat(String s) {
        List<Character> list1=new ArrayList<>(s.length()/2+5);
        List<Character> list2=new ArrayList<>(s.length()/2+5);

        for (char c:s.toCharArray())
        {
            if(Character.isDigit(c))list1.add(c);
            else list2.add(c);
        }

        if(Math.abs(list1.size()-list2.size())>=2)return "";

        if(list2.size()>list1.size())
        {
            List<Character> temp=list1;
            list1=list2;
            list2=temp;
        }
        Iterator<Character> it=list2.iterator();
        StringBuilder sb=new StringBuilder();
        for (char c:list1)
        {
            sb.append(c);
            if(it.hasNext())sb.append(it.next());
        }
        return sb.toString();
    }
}
/*
给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。

请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。

请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。

 

示例 1：

输入：s = "a0b1c2"
输出："0a1b2c"
解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
示例 2：

输入：s = "leetcode"
输出：""
解释："leetcode" 中只有字母，所以无法满足重新格式化的条件。
示例 3：

输入：s = "1229857369"
输出：""
解释："1229857369" 中只有数字，所以无法满足重新格式化的条件。
示例 4：

输入：s = "covid2019"
输出："c2o0v1i9d"
示例 5：

输入：s = "ab123"
输出："1a2b3"
 

提示：

1 <= s.length <= 500
s 仅由小写英文字母和/或数字组成。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reformat-the-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
