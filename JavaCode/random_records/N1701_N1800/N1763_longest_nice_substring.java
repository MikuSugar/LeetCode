package JavaCode.random_records.N1701_N1800;

/**
 * @author mikusugar
 */
public class N1763_longest_nice_substring {

    public String longestNiceSubstring(String s) {
        int len = 0;
        int idx = -1;
        final char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            int low = 0;
            int up = 0;
            for (int j = i; j < str.length; j++) {
                if (str[j] >= 'A' && str[j] <= 'Z') {
                    up |= 1 << (str[j] - 'A');
                } else {
                    low |= 1 << (str[j] - 'a');
                }
                if (up == low && (j - i + 1) > len) {
                    len = j - i + 1;
                    idx = i;
                }
            }
        }
        return len == 0 ? "" : s.substring(idx, idx + len);
    }


}
/*
当一个字符串 s 包含的每一种字母的大写和小写形式 同时 出现在 s 中，就称这个字符串 s 是 美好 字符串。比方说，"abABB" 是美好字符串，因为 'A' 和 'a' 同时出现了，且 'B' 和 'b' 也同时出现了。然而，"abA" 不是美好字符串因为 'b' 出现了，而 'B' 没有出现。

给你一个字符串 s ，请你返回 s 最长的 美好子字符串 。如果有多个答案，请你返回 最早 出现的一个。如果不存在美好子字符串，请你返回一个空字符串。

 

示例 1：

输入：s = "YazaAay"
输出："aAa"
解释："aAa" 是一个美好字符串，因为这个子串中仅含一种字母，其小写形式 'a' 和大写形式 'A' 也同时出现了。
"aAa" 是最长的美好子字符串。
示例 2：

输入：s = "Bb"
输出："Bb"
解释："Bb" 是美好字符串，因为 'B' 和 'b' 都出现了。整个字符串也是原字符串的子字符串。
示例 3：

输入：s = "c"
输出：""
解释：没有美好子字符串。
示例 4：

输入：s = "dDzeE"
输出："dD"
解释："dD" 和 "eE" 都是最长美好子字符串。
由于有多个美好子字符串，返回 "dD" ，因为它出现得最早。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-nice-substring
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */