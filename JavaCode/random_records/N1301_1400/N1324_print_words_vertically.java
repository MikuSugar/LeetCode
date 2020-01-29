package JavaCode.random_records.N1301_1400;

import java.util.ArrayList;
import java.util.List;

/**
 * author:fangjie
 * time:2020/1/29
 */
public class N1324_print_words_vertically {
    public List<String> printVertically(String s) {
        String[] strs=s.split(" ");
        int max=0;
        for (String str:strs)max=Math.max(max,str.length());
        StringBuilder[] res=new StringBuilder[max];
        for (int i=0;i<max;i++)res[i]=new StringBuilder();
        for (String str:strs)
        {
            char[] chars=str.toCharArray();
            for (int i=0;i<max;i++)
            {
                if(i<chars.length)res[i].append(chars[i]);
                else res[i].append(" ");
            }
        }
        List<String> ans=new ArrayList<>(max);
        for (StringBuilder sb:res)
        {
            while (sb.length()!=0&&sb.charAt(sb.length()-1)==' ')sb.deleteCharAt(sb.length()-1);
            ans.add(sb.toString());
        }
        return ans;
    }
}
/*
给你一个字符串 s。请你按照单词在 s 中的出现顺序将它们全部竖直返回。
单词应该以字符串列表的形式返回，必要时用空格补位，但输出尾部的空格需要删除（不允许尾随空格）。
每个单词只能放在一列上，每一列中也只能有一个单词。

 

示例 1：

输入：s = "HOW ARE YOU"
输出：["HAY","ORO","WEU"]
解释：每个单词都应该竖直打印。
 "HAY"
 "ORO"
 "WEU"
示例 2：

输入：s = "TO BE OR NOT TO BE"
输出：["TBONTB","OEROOE","   T"]
解释：题目允许使用空格补位，但不允许输出末尾出现空格。
"TBONTB"
"OEROOE"
"   T"
示例 3：

输入：s = "CONTEST IS COMING"
输出：["CIC","OSO","N M","T I","E N","S G","T"]
 

提示：

1 <= s.length <= 200
s 仅含大写英文字母。
题目数据保证两个单词之间只有一个空格。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/print-words-vertically
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */