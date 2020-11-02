package JavaCode.contest.weekly.n0_200.n169;

import java.util.*;

/**
 * author:fangjie
 * time:2020/1/26
 */
public class N4 {

    private Map<Character,Integer> cToI;
    private Map<Integer,Character> iToC;
    public boolean isSolvable(String[] words, String result) {
        cToI=new HashMap<>(26);
        iToC=new HashMap<>();
        char[][] ss=new char[words.length][];
        int idx=0;
        for (String w:words)
        {
            ss[idx++]=new StringBuilder(w).reverse().toString().toCharArray();
            if(ss[idx-1].length>result.length())return false;
        }
        return slove(ss,new StringBuilder(result).reverse().toString().toCharArray(),0,0,0);
    }

    private boolean slove(char[][] words, char[] res, int idx, int digit, int sum) {
        if(digit==res.length) return sum==0;
        if(idx==words.length)
        {
            char cur=res[digit];
            if(!cToI.containsKey(cur)&&!iToC.containsKey(sum%10))
            {
                if(sum%10==0&&digit==res.length-1)return false;
                cToI.put(cur,sum%10);
                iToC.put(sum%10,cur);
                boolean temp=slove(words,res,0,digit+1,sum/10);
                cToI.remove(cur);
                iToC.remove(sum%10);
                return temp;
            }
            else if(cToI.containsKey(cur)&&cToI.get(cur)==sum%10)
            {
                if(sum%10==0&&digit==res.length-1)return false;
                return slove(words,res,0,digit+1,sum/10);
            }

            return false;
        }
        if(digit>=words[idx].length)return slove(words,res,idx+1,digit,sum);
        if(cToI.containsKey(words[idx][digit]))
        {
            if(digit==words[idx].length-1&&cToI.get(words[idx][digit])==0)return false;
            return slove(words,res,idx+1,digit,sum+cToI.get(words[idx][digit]));
        }
        for (int i=0;i<10;i++)
        {
            if(digit==words[idx].length-1&&i==0)continue;
            if(iToC.containsKey(i))continue;
            cToI.put(words[idx][digit],i);
            iToC.put(i,words[idx][digit]);
            boolean temp=slove(words,res,idx+1,digit,sum+i);
            cToI.remove(words[idx][digit]);
            iToC.remove(i);
            if(temp)return true;
        }
        return false;
    }
}
/*
给你一个方程，左边用 words 表示，右边用 result 表示。

你需要根据以下规则检查方程是否可解：

每个字符都会被解码成一位数字（0 - 9）。
每对不同的字符必须映射到不同的数字。
每个 words[i] 和 result 都会被解码成一个没有前导零的数字。
左侧数字之和（words）等于右侧数字（result）。 
如果方程可解，返回 True，否则返回 False。

 

示例 1：

输入：words = ["SEND","MORE"], result = "MONEY"
输出：true
解释：映射 'S'-> 9, 'E'->5, 'N'->6, 'D'->7, 'M'->1, 'O'->0, 'R'->8, 'Y'->'2'
所以 "SEND" + "MORE" = "MONEY" ,  9567 + 1085 = 10652
示例 2：

输入：words = ["SIX","SEVEN","SEVEN"], result = "TWENTY"
输出：true
解释：映射 'S'-> 6, 'I'->5, 'X'->0, 'E'->8, 'V'->7, 'N'->2, 'T'->1, 'W'->'3', 'Y'->4
所以 "SIX" + "SEVEN" + "SEVEN" = "TWENTY" ,  650 + 68782 + 68782 = 138214
示例 3：

输入：words = ["THIS","IS","TOO"], result = "FUNNY"
输出：true
示例 4：

输入：words = ["LEET","CODE"], result = "POINT"
输出：false
 

提示：

2 <= words.length <= 5
1 <= words[i].length, results.length <= 7
words[i], result 只含有大写英文字母
表达式中使用的不同字符数最大为 10

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/verbal-arithmetic-puzzle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
