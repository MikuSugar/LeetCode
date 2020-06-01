package JavaCode.random_records.N1401_1500;

import java.util.Arrays;

/**
 * @Author: fangjie
 * @Date: 2020/6/1 8:44 下午
 */
public class N1433_check_if_a_string_can_break_another_string {

    public boolean checkIfCanBreak(String s1, String s2) {
        char[] strs1=s1.toCharArray();
        char[] strs2=s2.toCharArray();
        Arrays.sort(strs1);
        Arrays.sort(strs2);
        return check(strs1,strs2)||check(strs2,strs1);
    }

    private boolean check(char[] strs1, char[] strs2) {
        for (int i=0;i<strs1.length;i++)
        {
            if(strs1[i]>strs2[i])return false;
        }
        return true;
    }
}
/*
给你两个字符串 s1 和 s2 ，它们长度相等，请你检查是否存在一个 s1  的排列可以打破 s2 的一个排列，或者是否存在一个 s2 的排列可以打破 s1 的一个排列。

字符串 x 可以打破字符串 y （两者长度都为 n ）需满足对于所有 i（在 0 到 n - 1 之间）都有 x[i] >= y[i]（字典序意义下的顺序）。

 

示例 1：

输入：s1 = "abc", s2 = "xya"
输出：true
解释："ayx" 是 s2="xya" 的一个排列，"abc" 是字符串 s1="abc" 的一个排列，且 "ayx" 可以打破 "abc" 。
示例 2：

输入：s1 = "abe", s2 = "acd"
输出：false
解释：s1="abe" 的所有排列包括："abe"，"aeb"，"bae"，"bea"，"eab" 和 "eba" ，s2="acd" 的所有排列包括："acd"，"adc"，"cad"，"cda"，"dac" 和 "dca"。然而没有任何 s1 的排列可以打破 s2 的排列。也没有 s2 的排列能打破 s1 的排列。
示例 3：

输入：s1 = "leetcodee", s2 = "interview"
输出：true
 

提示：

s1.length == n
s2.length == n
1 <= n <= 10^5
所有字符串都只包含小写英文字母。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/check-if-a-string-can-break-another-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
