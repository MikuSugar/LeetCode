package JavaCode.random_records.N2401_N2600;

/**
 * @author mikusugar
 * @version 1.0, 2023/3/23 16:08
 * @description N2472_maximum_number_of_non_overlapping_palindrome_substrings
 */
public class N2472_maximum_number_of_non_overlapping_palindrome_substrings {
    public static void main(String[] args) {
        //s = "abaccdbbd", k = 3  res=2
        System.out.println(new N2472_maximum_number_of_non_overlapping_palindrome_substrings()
                .maxPalindromes("abaccdbbd", 3));
    }

    public int maxPalindromes(String s, int k) {
        final char[] strs = s.toCharArray();
        int res = 0;
        for (int i = 0; i < strs.length; ) {
            if (i + k - 1 < strs.length) {
                if (check(i, i + k - 1, strs)) {
                    res++;
                    i = i + k;
                } else if (i + k < strs.length && check(i, i + k, strs)) {
                    res++;
                    i = i + k + 1;
                } else {
                    i++;
                }
            } else break;

        }
        return res;
    }

    private static boolean check(int left, int right, char[] strs) {
        for (int i = left, j = right; i <= j; i++, j--) {
            if (strs[i] != strs[j]) {
                return false;
            }
        }
        return true;
    }
}
/*
给你一个字符串 s 和一个 正 整数 k 。

从字符串 s 中选出一组满足下述条件且 不重叠 的子字符串：

每个子字符串的长度 至少 为 k 。
每个子字符串是一个 回文串 。
返回最优方案中能选择的子字符串的 最大 数目。

子字符串 是字符串中一个连续的字符序列。

 

示例 1 ：

输入：s = "abaccdbbd", k = 3
输出：2
解释：可以选择 s = "abaccdbbd" 中斜体加粗的子字符串。"aba" 和 "dbbd" 都是回文，且长度至少为 k = 3 。
可以证明，无法选出两个以上的有效子字符串。
示例 2 ：

输入：s = "adbcda", k = 2
输出：0
解释：字符串中不存在长度至少为 2 的回文子字符串。
 

提示：

1 <= k <= s.length <= 2000
s 仅由小写英文字母组成

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/maximum-number-of-non-overlapping-palindrome-substrings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
