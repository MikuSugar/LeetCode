package JavaCode.contest.biweekly_n17;

import java.util.*;

/**
 * author:fangjie
 * time:2020/1/11
 */
public class N4 {
    public int distinctEchoSubstrings(String text) {
        if(text.length()<=1)return 0;
        char[] strs=text.toCharArray();
        Set<String> set=new HashSet<>(100);
        for (int j=1;j<strs.length;j++)
        {
            for (int i=0;i<j;i++)
            {
                int len=j-i+1;
                if(len%2!=0)continue;
                if(check(i,j,strs))set.add(new String(strs,i,len));
            }
        }
        return set.size();
    }

    private boolean check(int i, int j, char[] strs) {
        int mid=(j-i+1)/2-1+i;
        for (int ii=mid,jj=j;ii>=i;ii--,jj--)
        {
            if(strs[ii]!=strs[jj])return false;
        }
        return true;
    }


}
/*
给你一个字符串 text ，请你返回满足下述条件的 不同 非空子字符串的数目：这些子字符串可以写成某个字符串与其自身的串联。



示例 1：

输入：text = "abcabcabc"
输出：3
解释：3 个子字符串分别为 "abcabc" ， "bcabca" 和 "cabcab" 。
示例 2：

输入：text = "leetcodeleetcode"
输出：2
解释：2 个子字符串为 "ee" 和 "leetcodeleetcode" 。


提示：

1 <= text.length <= 2000
text 只包含小写英文字母。
 */
