package JavaCode.contest.weekly.n201_300.n205;

/**
 * author: fangjie
 * email: syfangjie@live.cn
 * date: 2020/9/6 10:24 上午
 */
public class N1 {
    public String modifyString(String s) {
        char[] strs=s.toCharArray();
        for (int i=0; i<strs.length; i++) {
            if (strs[i]=='?') {
                char a='a'-1;
                char b='a'-1;
                if (i>0) a=strs[i-1];
                if (i<strs.length-1) b=strs[i+1];
                strs[i]=getChar(a, b);
            }
        }
        return new String(strs);
    }

    private char getChar(char a, char b) {
        for (int i=0; i<26; i++) {
            char cur=(char) ('a'+i);
            if (cur!=a&&cur!=b) return cur;
        }
        return 'a';
    }
}
/*
给你一个仅包含小写英文字母和 '?' 字符的字符串 s<var> </var>，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。

注意：你 不能 修改非 '?' 字符。

题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。

在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。



示例 1：

输入：s = "?zs"
输出："azs"
解释：该示例共有 25 种解决方案，从 "azs" 到 "yzs" 都是符合题目要求的。只有 "z" 是无效的修改，因为字符串 "zzs" 中有连续重复的两个 'z' 。
示例 2：

输入：s = "ubv?w"
输出："ubvaw"
解释：该示例共有 24 种解决方案，只有替换成 "v" 和 "w" 不符合题目要求。因为 "ubvvw" 和 "ubvww" 都包含连续重复的字符。
示例 3：

输入：s = "j?qg??b"
输出："jaqgacb"
示例 4：

输入：s = "??yw?ipkj?"
输出："acywaipkja"
 */
