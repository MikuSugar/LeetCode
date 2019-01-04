package JavaCode;

import java.util.ArrayList;
import java.util.List;

public class all_paths_from_source_to_target {
    class Solution {

        private List<List<Integer>> list;
        private int[][] graph;
        private List<Integer> tempList;
        private int end;//终点

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            this.tempList=new ArrayList<>();
            this.list=new ArrayList<>();
            this.graph=graph;
            this.end=graph.length-1;
            tempList.add(0);
            dfs(0);
            return list;
        }

        void dfs(int level)
        {
            if(graph[level].length==0)
            {
                return;
            }
            else
            {
                for(int i=0;i<graph[level].length;i++)
                {

                    /**
                     * 走到终点时
                     */
                    if(graph[level][i]==this.end)
                    {
                        tempList.add(end);
                        List<Integer> result=new ArrayList<>();
                        for(int j=0;j<tempList.size();j++)
                        {
                            result.add(tempList.get(j));
                        }
                        tempList.remove(tempList.size()-1);
                        list.add(result);
                    }

                    /**
                     * 没有到终点，继续递归
                     */
                    else
                    {
                        tempList.add(graph[level][i]);
                        dfs(graph[level][i]);
                        tempList.remove(tempList.size()-1);
                    }
                }
            }
        }
    }
}

/**
 * https://leetcode-cn.com/problems/all-paths-from-source-to-target/
 * 给一个有 n 个结点的有向无环图，找到所有从 0 到 n-1 的路径并输出（不要求按顺序）
 *
 * 二维数组的第 i 个数组中的单元都表示有向图中 i 号结点所能到达的下一些结点（译者注：有向图是有方向的，即规定了a→b你就不能从b→a）空就是没有下一个结点了。
 *
 * 示例:
 * 输入: [[1,2], [3], [3], []
 * ]
 * 输出: [[0,1,3],[0,2,3]]
 * 解释: 图是这样的:
 * 0--->1
 * |    |
 * v    v
 * 2--->3
 * 这有两条路: 0 -> 1 -> 3 和 0 -> 2 -> 3.
 */
