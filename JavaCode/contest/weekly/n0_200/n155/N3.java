package JavaCode.contest.weekly.n0_200.n155;

import java.util.*;

/**
 * author:fangjie
 * time:2019/9/24
 */
public class N3 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        Map<Integer,PriorityQueue<Character>> map=new HashMap<>();
        List<Integer>[] garaph=new List[s.length()];
        getGaraph(pairs,garaph);

        int[] book=new int[s.length()];
        boolean[] used=new boolean[s.length()];

        char[] strs=s.toCharArray();
        int color=1;
        for (int i=0;i<s.length();i++)
        {
            if(!used[i])
            {
                map.put(color,new PriorityQueue<>());
                dfs(i,garaph,used,book,color++);
            }
        }
        for (int i=0;i<strs.length;i++)
        {
            map.get(book[i]).add(strs[i]);
        }
        for (int i=0;i<strs.length;i++)
        {
            strs[i]=map.get(book[i]).poll();
        }
        return new String(strs);
    }

    private void dfs(int i, List<Integer>[] garaph, boolean[] used, int[] book, final int color) {
        used[i]=true;
        book[i]=color;
        for (int next:garaph[i])
        {
            if(used[next])continue;
            dfs(next,garaph,used,book,color);
        }
    }


    private void getGaraph(List<List<Integer>> pairs, List<Integer>[] map) {
        for (int i=0;i<map.length;i++)
        {
            map[i]=new ArrayList<>();
        }
        for (List<Integer> pair:pairs)
        {
            int a=pair.get(0);
            int b=pair.get(1);
            map[a].add(b);
            map[b].add(a);
        }
    }
}
/**
 * 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
 *
 * 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
 *
 * 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
 *
 *
 *
 * 示例 1:
 *
 * 输入：s = "dcab", pairs = [[0,3],[1,2]]
 * 输出："bacd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[1] 和 s[2], s = "bacd"
 * 示例 2：
 *
 * 输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * 输出："abcd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[0] 和 s[2], s = "acbd"
 * 交换 s[1] 和 s[2], s = "abcd"
 * 示例 3：
 *
 * 输入：s = "cba", pairs = [[0,1],[1,2]]
 * 输出："abc"
 * 解释：
 * 交换 s[0] 和 s[1], s = "bca"
 * 交换 s[1] 和 s[2], s = "bac"
 * 交换 s[0] 和 s[1], s = "abc"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 10^5
 * 0 <= pairs.length <= 10^5
 * 0 <= pairs[i][0], pairs[i][1] < s.length
 * s 中只含有小写英文字母
 */
