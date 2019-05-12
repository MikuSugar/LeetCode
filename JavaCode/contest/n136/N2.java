package JavaCode.contest.n136;

import java.util.ArrayList;
import java.util.List;

public class N2 {


    public static void main(String[] args) {
        new N2().gardenNoAdj(3,new int[][]{{1,2},{2,3},{3,1}});
    }

    private boolean isOk;
    public int[] gardenNoAdj(int N, int[][] paths) {
        isOk=false;
        List<Integer>[] map=new List[N+1];
        for (int i=0;i<=N;i++)
        {
            map[i]=new ArrayList<>();
        }
        int[] res=new int[N];
        for (int[]p:paths)
        {
            map[p[0]].add(p[1]);
            map[p[1]].add(p[0]);
        }
        dfs(0,map,res,N);
        return res;
    }

    private void dfs(int index, List<Integer>[] map, int[] res,int N) {
        if(isOk(index,map,res))
        {
            if(index==N)
            {
                isOk=true;
                return;
            }
            else
            {
                for (int i=1;i<=4;i++)
                {
                    if(isOk)return;
                    res[index]=i;
                    dfs(index+1,map,res,N);
                }
            }
        }
    }

    private boolean isOk(int index, List<Integer>[] map, int[] res) {
        if(index==0)return true;
        for (int i:map[index])
        {
            if(res[i-1]==res[index-1])return false;
        }
        return true;
    }
}
/**
 * 5056. 不邻接植花  显示英文描述
 * 用户通过次数 68
 * 用户尝试次数 129
 * 通过次数 68
 * 提交次数 211
 * 题目难度 Easy
 * 有 N 个花园，按从 1 到 N 标记。在每个花园中，你打算种下四种花之一。
 *
 * paths[i] = [x, y] 描述了花园 x 到花园 y 的双向路径。
 *
 * 另外，没有花园有 3 条以上的路径可以进入或者离开。
 *
 * 你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。
 *
 * 以数组形式返回选择的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。花的种类用  1, 2, 3, 4 表示。保证存在答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：N = 3, paths = [[1,2],[2,3],[3,1]]
 * 输出：[1,2,3]
 * 示例 2：
 *
 * 输入：N = 4, paths = [[1,2],[3,4]]
 * 输出：[1,2,1,2]
 * 示例 3：
 *
 * 输入：N = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
 * 输出：[1,2,3,4]
 *
 *
 * 提示：
 *
 * 1 <= N <= 10000
 * 0 <= paths.size <= 20000
 * 不存在花园有 4 条或者更多路径可以进入或离开。
 * 保证存在答案。
 */
