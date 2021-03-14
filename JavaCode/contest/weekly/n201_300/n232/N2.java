package JavaCode.contest.weekly.n201_300.n232;

import java.util.HashMap;
import java.util.Map;

/**
 * author: fangjie
 * email: syfangjie@live.cn
 * date: 2021/3/14 10:28 上午
 */
public class N2 {
    public int findCenter(int[][] edges) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int[] e:edges){
            map.put(e[0],map.getOrDefault(e[0],0)+1);
            map.put(e[1],map.getOrDefault(e[1],0)+1);
        }
        int res=-1;
        int max=-1;
        for (Map.Entry<Integer,Integer> e: map.entrySet()){
            if(e.getValue()>max){
                max=e.getValue();
                res=e.getKey();
            }
        }
        return res;
    }
}
/*
有一个无向的 星型 图，由 n 个编号从 1 到 n 的节点组成。星型图有一个 中心 节点，并且恰有 n - 1 条边将中心节点与其他每个节点连接起来。

给你一个二维整数数组 edges ，其中 edges[i] = [ui, vi] 表示在节点 ui 和 vi 之间存在一条边。请你找出并返回 edges 所表示星型图的中心节点。



示例 1：


输入：edges = [[1,2],[2,3],[4,2]]
输出：2
解释：如上图所示，节点 2 与其他每个节点都相连，所以节点 2 是中心节点。
示例 2：

输入：edges = [[1,2],[5,1],[1,3],[1,4]]
输出：1


提示：

3 <= n <= 105
edges.length == n - 1
edges[i].length == 2
1 <= ui, vi <= n
ui != vi
题目数据给出的 edges 表示一个有效的星型图
 */
