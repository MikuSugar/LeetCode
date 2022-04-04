package JavaCode.contest.weekly.n201_300.n287;

import scala.Char;

import java.util.*;

/**
 * @author mikusugar
 *
 */
public class N4 {
}
class Encrypter {

    private final Set<String> dict;
    private final int[] bookKey;
    private final String[] values;
    private final Map<String, List<Integer>> mapValues;
    private final char[] keys;
    private final TreeNode root;
    private final Map<String,Integer> resMap;

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        dict = new HashSet<>();
        dict.addAll(Arrays.asList(dictionary));
        root = new TreeNode();
        for (String s : dictionary) buildTree(root, s);
        resMap=new HashMap<>();

        bookKey = new int[26];
        Arrays.fill(bookKey, -1);
        for (int i = 0; i < keys.length; i++) {
            bookKey[keys[i] - 'a'] = i;
        }
        this.keys = keys;

        this.values = values;
        mapValues = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            if (!mapValues.containsKey(values[i])) mapValues.put(values[i], new ArrayList<>());
            mapValues.get(values[i]).add(i);
        }
    }

    public String encrypt(String word1) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word1.length(); i++) {
            char c = word1.charAt(i);
            if (bookKey[c - 'a'] != -1) sb.append(values[bookKey[c - 'a']]);
            else sb.append(c);
        }
        return sb.toString();
    }


    public int decrypt(String word2) {
        if(resMap.containsKey(word2))return resMap.get(word2);
        final LinkedList<Character> list = new LinkedList<>();
        final int res = dfs(word2.toCharArray(), 0, list);
        resMap.put(word2,res);
        return res;
    }

    private int dfs(char[] strs, int idx, LinkedList<Character> list) {
        if (idx >= strs.length) {
            StringBuilder sb = new StringBuilder();
            for (char c : list) sb.append(c);
            if (dict.contains(sb.toString())) {
                return 1;
            }
            return 0;
        }
        if (!check(root, list)) return 0;
        int res = 0;
        if (strs.length - idx < 2) {
            list.add(strs[idx]);
            dfs(strs, idx + 1, list);
            list.removeLast();
        } else {
            String s = strs[idx] + "" + strs[idx + 1];
            if (mapValues.containsKey(s)) {
                final List<Integer> list1 = mapValues.get(s);
                for (int k : list1) {
                    list.add(keys[k]);
                    res += dfs(strs, idx + 2, list);
                    list.removeLast();
                }
            } else {
                list.add(strs[idx]);
                list.add(strs[idx + 1]);
                res += dfs(strs, idx + 2, list);
                list.removeLast();
                list.removeLast();
            }
        }
        return res;
    }


    static class TreeNode {
        TreeNode[] nexts;

        TreeNode() {
            nexts = new TreeNode[26];
        }
    }

    private static void buildTree(TreeNode root, String s) {
        final char[] strs = s.toCharArray();
        TreeNode p = root;
        for (char c : strs) {
            if (p.nexts[c - 'a'] == null) p.nexts[c - 'a'] = new TreeNode();
            p = p.nexts[c - 'a'];
        }
    }

    private static boolean check(TreeNode root, List<Character> list) {
        TreeNode p = root;
        for (char c : list) {
            if (p.nexts[c - 'a'] == null) return false;
            p = p.nexts[c - 'a'];
        }
        return true;
    }
}

/*
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */
/*
给你一个字符数组 keys ，由若干 互不相同 的字符组成。还有一个字符串数组 values ，内含若干长度为 2 的字符串。另给你一个字符串数组 dictionary ，包含解密后所有允许的原字符串。请你设计并实现一个支持加密及解密下标从 0 开始字符串的数据结构。

字符串 加密 按下述步骤进行：

对字符串中的每个字符 c ，先从 keys 中找出满足 keys[i] == c 的下标 i 。
在字符串中，用 values[i] 替换字符 c 。
字符串 解密 按下述步骤进行：

将字符串每相邻 2 个字符划分为一个子字符串，对于每个子字符串 s ，找出满足 values[i] == s 的一个下标 i 。如果存在多个有效的 i ，从中选择 任意 一个。这意味着一个字符串解密可能得到多个解密字符串。
在字符串中，用 keys[i] 替换 s 。
实现 Encrypter 类：

Encrypter(char[] keys, String[] values, String[] dictionary) 用 keys、values 和 dictionary 初始化 Encrypter 类。
String encrypt(String word1) 按上述加密过程完成对 word1 的加密，并返回加密后的字符串。
int decrypt(String word2) 统计并返回可以由 word2 解密得到且出现在 dictionary 中的字符串数目。


示例：

输入：
["Encrypter", "encrypt", "decrypt"]
[[['a', 'b', 'c', 'd'], ["ei", "zf", "ei", "am"], ["abcd", "acbd", "adbc", "badc", "dacb", "cadb", "cbda", "abad"]], ["abcd"], ["eizfeiam"]]
输出：
[null, "eizfeiam", 2]

解释：
Encrypter encrypter = new Encrypter([['a', 'b', 'c', 'd'], ["ei", "zf", "ei", "am"], ["abcd", "acbd", "adbc", "badc", "dacb", "cadb", "cbda", "abad"]);
encrypter.encrypt("abcd"); // 返回 "eizfeiam"。
                           // 'a' 映射为 "ei"，'b' 映射为 "zf"，'c' 映射为 "ei"，'d' 映射为 "am"。
encrypter.decrypt("eizfeiam"); // return 2.
                              // "ei" 可以映射为 'a' 或 'c'，"zf" 映射为 'b'，"am" 映射为 'd'。
                              // 因此，解密后可以得到的字符串是 "abad"，"cbad"，"abcd" 和 "cbcd"。
                              // 其中 2 个字符串，"abad" 和 "abcd"，在 dictionary 中出现，所以答案是 2 。


提示：

1 <= keys.length == values.length <= 26
values[i].length == 2
1 <= dictionary.length <= 100
1 <= dictionary[i].length <= 100
所有 keys[i] 和 dictionary[i] 互不相同
1 <= word1.length <= 2000
1 <= word2.length <= 200
所有 word1[i] 都出现在 keys 中
word2.length 是偶数
keys、values[i]、dictionary[i]、word1 和 word2 只含小写英文字母
至多调用 encrypt 和 decrypt 总计 200 次
 */
