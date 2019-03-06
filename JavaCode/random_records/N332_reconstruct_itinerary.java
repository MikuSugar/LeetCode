package JavaCode.random_records;

import java.util.*;

public class N332_reconstruct_itinerary
{

    private List<String> res;
    private Map<String,PriorityQueue<String>> map;
    public List<String> findItinerary(String[][] tickets) {
        res=new ArrayList<>();
        map=new HashMap<>();
        for (String[] strs:tickets)
        {
            if(!map.containsKey(strs[0]))
            {
                map.put(strs[0],new PriorityQueue<>());
            }
            map.get(strs[0]).add(strs[1]);
        }
        dfs("JFK");
        Collections.reverse(res);
        return res;
    }

    private void dfs(String s)
    {
        if(!map.containsKey(s)||map.get(s).size()==0)
        {
            res.add(s);
            return;
        }
        PriorityQueue<String> queue=map.get(s);
        while (!queue.isEmpty())
        {
            dfs(queue.poll());
        }
        res.add(s);
    }
}
/**
 * https://leetcode-cn.com/problems/reconstruct-itinerary/
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 出发。
 *
 * 说明:
 *
 * 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 * 所有的机场都用三个大写字母表示（机场代码）。
 * 假定所有机票至少存在一种合理的行程。
 * 示例 1:
 *
 * 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * 示例 2:
 *
 * 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
 */
