package JavaCode.contest.weekly.n201_300.n232;

import java.util.ArrayList;
import java.util.List;

/**
 * author: fangjie
 * email: syfangjie@live.cn
 * date: 2021/3/14 10:27 上午
 */
public class N1 {
    public boolean areAlmostEqual(String s1, String s2) {
        char[] strs1=s1.toCharArray();
        char[] strs2=s2.toCharArray();
        List<Integer> list=new ArrayList<>();
        for (int i=0;i<s1.length();i++)
        {
            if(strs1[i]!=strs2[i])list.add(i);
            if(list.size()>2)return false;
        }
        if(list.size()==0)return true;
        if(list.size()!=2)return false;
        int idx1=list.get(0);
        int idx2=list.get(1);
        return strs1[idx1]==strs2[idx2]&&strs1[idx2]==strs2[idx1];
    }
}
/*
给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。

如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。



示例 1：

输入：s1 = "bank", s2 = "kanb"
输出：true
解释：例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"
示例 2：

输入：s1 = "attack", s2 = "defend"
输出：false
解释：一次字符串交换无法使两个字符串相等
示例 3：

输入：s1 = "kelb", s2 = "kelb"
输出：true
解释：两个字符串已经相等，所以不需要进行字符串交换
示例 4：

输入：s1 = "abcd", s2 = "dcba"
输出：false


提示：

1 <= s1.length, s2.length <= 100
s1.length == s2.length
s1 和 s2 仅由小写英文字母组成
 */
