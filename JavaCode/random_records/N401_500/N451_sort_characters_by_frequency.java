package JavaCode.random_records.N401_500;


import java.util.*;

public class N451_sort_characters_by_frequency {


    public String frequencySort(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for (int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        List<Node> list=new ArrayList<>(48);
        for (Map.Entry<Character,Integer> e:map.entrySet())
        {
            list.add(new Node(e));
        }

        StringBuilder res=new StringBuilder();
        help(res,list);
        return res.toString();

    }

    private void help(StringBuilder res, List<Node> list) {
        list.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.cnt-o1.cnt;
            }
        });
        for (Node node:list)
        {
            for (int i=0;i<node.cnt;i++)
            {
                res.append(node.c);
            }
        }
    }

    private class Node
    {
        char c;
        int cnt;
        public Node(Map.Entry<Character,Integer> e)
        {
            this.c=e.getKey();
            this.cnt=e.getValue();
        }
    }
}
/**
 * https://leetcode-cn.com/problems/sort-characters-by-frequency/
 *  给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * 示例 1:
 *
 * 输入:
 * "tree"
 *
 * 输出:
 * "eert"
 *
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 *
 * 输入:
 * "cccaaa"
 *
 * 输出:
 * "cccaaa"
 *
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 *
 * 输入:
 * "Aabb"
 *
 * 输出:
 * "bbAa"
 *
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 */
