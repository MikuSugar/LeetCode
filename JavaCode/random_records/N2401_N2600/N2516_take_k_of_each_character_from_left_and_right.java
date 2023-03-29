package JavaCode.random_records.N2401_N2600;

/**
 * @author mikusugar
 * @version 1.0, 2023/3/29 15:16
 * @description N2516_take_k_of_each_character_from_left_and_right
 */
public class N2516_take_k_of_each_character_from_left_and_right {
    public static void main(String[] args) {
        System.out.println(new N2516_take_k_of_each_character_from_left_and_right().takeCharacters(
                "aabaaaacaabc", 2
        ));
        System.out.println(new N2516_take_k_of_each_character_from_left_and_right().takeCharacters(
                "a", 1
        ));
    }

    public int takeCharacters(String s, int k) {
        int[][] lBook = new int[3][s.length()];
        int[][] rBook = new int[3][s.length()];
        init(s, lBook, rBook);

        int left = 0;
        int right = s.length();
        int res = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid, k, lBook, rBook)) {
                res = Math.min(res, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;

    }

    private static void init(String s, int[][] lBook, int[][] rBook) {
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == 'a') a++;
            else if (cur == 'b') b++;
            else c++;
            lBook[0][i] = a;
            lBook[1][i] = b;
            lBook[2][i] = c;
        }
        a = 0;
        b = 0;
        c = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char cur = s.charAt(i);
            if (cur == 'a') a++;
            else if (cur == 'b') b++;
            else c++;
            rBook[0][s.length() - 1 - i] = a;
            rBook[1][s.length() - 1 - i] = b;
            rBook[2][s.length() - 1 - i] = c;
        }
    }

    private boolean check(int minute, int k, int[][] lBook, int[][] rBook) {
        for (int i = 0; i <= minute; i++) {
            int a = 0, b = 0, c = 0;
            int lIdx = i - 1;
            int rIdx = minute - i - 1;
            if (lIdx != -1) {
                a += lBook[0][lIdx];
                b += lBook[1][lIdx];
                c += lBook[2][lIdx];
            }
            if (rIdx != -1) {
                a += rBook[0][rIdx];
                b += rBook[1][rIdx];
                c += rBook[2][rIdx];
            }
            if (a >= k && b >= k && c >= k) {
                return true;
            }
        }
        return false;
    }
}
/*
给你一个由字符 'a'、'b'、'c' 组成的字符串 s 和一个非负整数 k 。每分钟，你可以选择取走 s 最左侧 还是 最右侧 的那个字符。

你必须取走每种字符 至少 k 个，返回需要的 最少 分钟数；如果无法取到，则返回 -1 。

 

示例 1：

输入：s = "aabaaaacaabc", k = 2
输出：8
解释：
从 s 的左侧取三个字符，现在共取到两个字符 'a' 、一个字符 'b' 。
从 s 的右侧取五个字符，现在共取到四个字符 'a' 、两个字符 'b' 和两个字符 'c' 。
共需要 3 + 5 = 8 分钟。
可以证明需要的最少分钟数是 8 。
示例 2：

输入：s = "a", k = 1
输出：-1
解释：无法取到一个字符 'b' 或者 'c'，所以返回 -1 。
 

提示：

1 <= s.length <= 105
s 仅由字母 'a'、'b'、'c' 组成
0 <= k <= s.length

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/take-k-of-each-character-from-left-and-right
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
