package JavaCode.contest.weekly.n201_300.n285;

import scala.reflect.internal.Trees;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author mikusugar
 */
//TODO
public class N4 {


    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        TreeMap<Integer, Integer>[] max = new TreeMap[26];

        for (int i = 0; i < max.length; i++) {
            max[i] = new TreeMap<>();
        }

        final Node root = new Node();
        Node pre = root;
        final char[] strs = s.toCharArray();
        Node[] book = new Node[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (pre.c != strs[i]) {
                final TreeMap<Integer, Integer> map = max[pre.c - 'a'];
                map.put(pre.val, map.getOrDefault(pre.val, 0) + 1);
                Node node = new Node();
                node.c = strs[i];
                node.val = 1;
                node.pre = pre;
                pre.next = node;
                pre = node;

            } else {
                pre.val++;
            }
            book[i] = pre;
        }
        {
            final TreeMap<Integer, Integer> map = max[pre.c - 'a'];
            map.put(pre.val, map.getOrDefault(pre.val, 0) + 1);
        }

        int[] res = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {
            char cur = queryCharacters.charAt(i);
            int idx = queryIndices[i];

            if (cur == strs[idx]) {
                res[i] = getMax(max);
            } else {
                char p = '(';
                if (idx > 0) p = strs[idx - 1];
                char n = ')';
                if (idx < strs.length - 1) n = strs[idx + 1];

                if (cur == p && cur != n) {
                    final Node preNode = book[idx - 1];
                    final TreeMap<Integer, Integer> preTreeMap = max[preNode.c - 'a'];
                    addHelp(preNode, preTreeMap);
                    final Node node = book[idx];
                    subHelp(node, max[node.c - 'a']);
                    if (node.val == 0) remove(node);
                    book[idx] = preNode;
                    strs[idx] = cur;
                } else if (cur == n && cur != p) {
                    final Node next = book[idx + 1];
                    addHelp(next,max[next.c-'a']);
                    final Node node = book[idx];
                    subHelp(node, max[node.c - 'a']);
                    if (node.val == 0) remove(node);
                    book[idx] = next;
                    strs[idx] = cur;
                }else if(cur == n){
                    final Node preNode = book[idx - 1];
                    final Node nextNode = book[idx + 1];
                }

                res[i] = getMax(max);
            }
        }

        return res;

    }

    private void remove(Node node) {
        node.pre.next = node.next;
        if (node.next != null) node.next.pre = node.pre;
    }

    private void subHelp(Node node, TreeMap<Integer, Integer> map) {
        int cnt = map.get(node.val);
        if (cnt - 1 == 0) map.remove(node.val);
        else map.put(node.val, cnt - 1);
        node.val--;
        if (node.val != 0) {
            map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        }
    }

    private void addHelp(Node node, TreeMap<Integer, Integer> map) {
        int cnt = map.get(node.val);
        if (cnt - 1 == 0) map.remove(node.val);
        else map.put(node.val, cnt - 1);
        node.val++;
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
    }


    private int getMax(TreeMap<Integer, Integer>[] max) {
        int res = 0;
        for (TreeMap<Integer, Integer> map : max) {
            if (map.isEmpty()) continue;
            res = Math.max(res, map.lastKey());
        }
        return res;
    }

    static class Node {
        char c = '&';
        int val = 0;
        Node pre;
        Node next;
    }
}
/*
给你一个下标从 0 开始的字符串 s 。另给你一个下标从 0 开始、长度为 k 的字符串 queryCharacters ，一个下标从 0 开始、长度也是 k 的整数 下标 数组 queryIndices ，这两个都用来描述 k 个查询。

第 i 个查询会将 s 中位于下标 queryIndices[i] 的字符更新为 queryCharacters[i] 。

返回一个长度为 k 的数组 lengths ，其中 lengths[i] 是在执行第 i 个查询 之后 s 中仅由 单个字符重复 组成的 最长子字符串 的 长度 。



示例 1：

输入：s = "babacc", queryCharacters = "bcb", queryIndices = [1,3,3]
输出：[3,3,4]
解释：
- 第 1 次查询更新后 s = "bbbacc" 。由单个字符重复组成的最长子字符串是 "bbb" ，长度为 3 。
- 第 2 次查询更新后 s = "bbbccc" 。由单个字符重复组成的最长子字符串是 "bbb" 或 "ccc"，长度为 3 。
- 第 3 次查询更新后 s = "bbbbcc" 。由单个字符重复组成的最长子字符串是 "bbbb" ，长度为 4 。
因此，返回 [3,3,4] 。
示例 2：

输入：s = "abyzz", queryCharacters = "aa", queryIndices = [2,1]
输出：[2,3]
解释：
- 第 1 次查询更新后 s = "abazz" 。由单个字符重复组成的最长子字符串是 "zz" ，长度为 2 。
- 第 2 次查询更新后 s = "aaazz" 。由单个字符重复组成的最长子字符串是 "aaa" ，长度为 3 。
因此，返回 [2,3] 。


提示：

1 <= s.length <= 105
s 由小写英文字母组成
k == queryCharacters.length == queryIndices.length
1 <= k <= 105
queryCharacters 由小写英文字母组成
0 <= queryIndices[i] < s.length
 */