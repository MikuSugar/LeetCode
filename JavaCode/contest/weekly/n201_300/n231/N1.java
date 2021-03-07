package JavaCode.contest.weekly.n201_300.n231;

/**
 * author: fangjie
 * email: syfangjie@live.cn
 * date: 2021/3/7 10:26 上午
 */
public class N1 {
    public boolean checkOnesSegment(String s) {
        char[] strs=s.toCharArray();
        int idx=0;
        while (idx<strs.length){
            if(strs[idx]=='0')idx++;
            else break;
        }
        if(idx==strs.length)return false;
        while (idx<strs.length){
            if(strs[idx]=='1')idx++;
            else break;
        }
        for (int i=idx;i<strs.length;i++){
            if(strs[i]=='1')return false;
        }
        return true;
    }
}
/*
给你一个二进制字符串 s ，该字符串 不含前导零 。

如果 s 最多包含 一个由连续的 '1' 组成的字段 ，返回 true​​​ 。否则，返回 false 。



示例 1：

输入：s = "1001"
输出：false
解释：字符串中的 1 没有形成一个连续字段。
示例 2：

输入：s = "110"
输出：true


提示：

1 <= s.length <= 100
s[i]​​​​ 为 '0' 或 '1'
s[0] 为 '1'
 */
