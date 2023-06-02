package JavaCode.random_records.N1601_N1700;

import utils.CheckUtil;

import java.util.Arrays;

/**
 * @author mikusugar
 * @version 1.0, 2023/5/31 16:07
 * @description N1657_determine_if_two_strings_are_close
 */
public class N1657_determine_if_two_strings_are_close {

    public static void main(String[] args) {
        final N1657_determine_if_two_strings_are_close algo = new N1657_determine_if_two_strings_are_close();
        CheckUtil.check(true, algo.closeStrings("abc", "bca"));
        CheckUtil.check(false, algo.closeStrings("a", "aa"));
        CheckUtil.check(true, algo.closeStrings("cabbba", "abbccc"));
        CheckUtil.check(false, algo.closeStrings("cabbba", "aabbss"));
    }

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        final int[] book1 = new int[26];
        final int[] book2 = new int[26];
        count(word1, book1);
        count(word2, book2);

        for (int i = 0; i < 26; i++) {
            if (book1[i] == 0 && book2[i] != 0) {
                return false;
            }
            if (book2[i] == 0 && book1[i] != 0) {
                return false;
            }
        }

        Arrays.sort(book1);
        Arrays.sort(book2);
        for (int i = 0; i < 26; i++) {
            if (book1[i] != book2[i]) {
                return false;
            }
        }
        return true;
    }

    private void count(String word, int[] book) {
        for (int i = 0; i < word.length(); i++) {
            book[word.charAt(i) - 'a']++;
        }
    }
}
/*
如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：

操作 1：交换任意两个 现有 字符。
例如，abcde -> aecdb
操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）
你可以根据需要对任意一个字符串多次使用这两种操作。

给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。

 

示例 1：

输入：word1 = "abc", word2 = "bca"
输出：true
解释：2 次操作从 word1 获得 word2 。
执行操作 1："abc" -> "acb"
执行操作 1："acb" -> "bca"
示例 2：

输入：word1 = "a", word2 = "aa"
输出：false
解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。
示例 3：

输入：word1 = "cabbba", word2 = "abbccc"
输出：true
解释：3 次操作从 word1 获得 word2 。
执行操作 1："cabbba" -> "caabbb"
执行操作 2："caabbb" -> "baaccc"
执行操作 2："baaccc" -> "abbccc"
示例 4：

输入：word1 = "cabbba", word2 = "aabbss"
输出：false
解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。


来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/determine-if-two-strings-are-close
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
