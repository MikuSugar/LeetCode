package JavaCode.random_records.N2401_N2600;

import utils.CheckUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mikusugar
 * @version 1.0, 2023/3/31 15:40
 * @description N2531_make_number_of_distinct_characters_equal
 */
public class N2531_make_number_of_distinct_characters_equal {

    public static void main(String[] args) {
        final N2531_make_number_of_distinct_characters_equal algo = new N2531_make_number_of_distinct_characters_equal();
        CheckUtil.check(algo.isItPossible("ac", "b"), false);
        CheckUtil.check(algo.isItPossible("abcc", "aab"), true);
        CheckUtil.check(algo.isItPossible("abcde", "fghij"), true);
        CheckUtil.check(algo.isItPossible("aa", "ab"), false);
    }

    public boolean isItPossible(String word1, String word2) {
        final Map<Character, Integer> map1 = parse(word1);
        final Map<Character, Integer> map2 = parse(word2);

        for (Character c1 : map1.keySet()) {
            for (Character c2 : map2.keySet()) {
                if (change(c1, c2, map1, map2)) {
                    return true;
                }
            }
        }
        return false;

    }

    private boolean change(Character c1, Character c2, Map<Character, Integer> map1, Map<Character, Integer> map2) {
        int sum1 = getSum(c1, c2, map1);
        int sum2 = getSum(c2, c1, map2);
        return sum1 == sum2;
    }

    private static int getSum(Character removeC, Character addC, Map<Character, Integer> map) {
        if (removeC.equals(addC)) {
            return map.size();
        }
        int sum = map.size();
        if (map.get(removeC) == 1) {
            sum--;
        }
        if (!map.containsKey(addC)) {
            sum++;
        }
        return sum;
    }

    private Map<Character, Integer> parse(String word) {
        final Map<Character, Integer> map = new HashMap<>(26);
        for (int i = 0; i < word.length(); i++) {
            final Character cur = word.charAt(i);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        return map;
    }
}
/*
给你两个下标从 0 开始的字符串 word1 和 word2 。

一次 移动 由以下两个步骤组成：

选中两个下标 i 和 j ，分别满足 0 <= i < word1.length 和 0 <= j < word2.length ，
交换 word1[i] 和 word2[j] 。
如果可以通过 恰好一次 移动，使 word1 和 word2 中不同字符的数目相等，则返回 true ；否则，返回 false 。

 

示例 1：

输入：word1 = "ac", word2 = "b"
输出：false
解释：交换任何一组下标都会导致第一个字符串中有 2 个不同的字符，而在第二个字符串中只有 1 个不同字符。
示例 2：

输入：word1 = "abcc", word2 = "aab"
输出：true
解释：交换第一个字符串的下标 2 和第二个字符串的下标 0 。之后得到 word1 = "abac" 和 word2 = "cab" ，各有 3 个不同字符。
示例 3：

输入：word1 = "abcde", word2 = "fghij"
输出：true
解释：无论交换哪一组下标，两个字符串中都会有 5 个不同字符。
 

提示：

1 <= word1.length, word2.length <= 105
word1 和 word2 仅由小写英文字母组成。


来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/make-number-of-distinct-characters-equal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
