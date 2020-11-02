package JavaCode.contest.other.fall_2019;

import java.util.*;

/**
 * author:fangjie
 * time:2019/9/24
 */
public class N4 {
    public int domino(int n, int m, int[][] broken) {
        List<Integer>[] graph=getGraph(n,m,broken);
        int res=0;
        int[] mat=new int[n*10+m];
        Arrays.fill(mat,-1);
        for (int i=0;i<graph.length;i++)
        {
            if(graph[i].size()==0)continue;
            int y=i%10;
            int x=i/10;
            if((x+y)%2==0)continue;
            res+=dfs(i,new boolean[n*10+m],mat,graph);
        }
        return res;
    }

    private int dfs(int cur, boolean[] book, int[] mat, List<Integer>[] graph) {
        for (int next:graph[cur])
        {
            if(book[next])continue;
            book[next]=true;
            if(mat[next]==-1||dfs(mat[next],book,mat,graph)==1)
            {
                mat[cur]=next;
                mat[next]=cur;
                return 1;
            }
        }
        return 0;
    }


    private List<Integer>[] getGraph(int n, int m, int[][] broken) {
        List<Integer>[] res=new List[n*10+m];
        for (int i=0;i<res.length;i++)res[i]=new ArrayList<>();
        Set<Integer> br=new HashSet<>();
        for (int[] b:broken)
        {
            br.add(getKey(b[0],b[1]));
        }
        for (int i=0;i<n;i++)
        {
            for (int j=0;j<m;j++)
            {
                int key=getKey(i, j);
                if(br.contains(key))continue;
                for (int[] next:nexts)
                {
                    int ii=i+next[0];
                    int jj=j+next[1];
                    int key1=getKey(ii, jj);
                    if(ii<0||jj<0||ii>=n||jj>=m||br.contains(key1))continue;
                    res[key].add(key1);
                }
            }
        }
        return res;
    }

    private final static int[][] nexts={{-1,0},{0,-1},{0,1},{1,0}};
    private int getKey(int x,int y)
    {
        return x*10+y;
    }
}
/**
 *你有一块棋盘，棋盘上有一些格子已经坏掉了。你还有无穷块大小为1 * 2的多米诺骨牌，你想把这些骨牌不重叠地覆盖在完好的格子上，请找出你最多能在棋盘上放多少块骨牌？这些骨牌可以横着或者竖着放。
 *
 *
 *
 * 输入：n, m代表棋盘的大小；broken是一个b * 2的二维数组，其中每个元素代表棋盘上每一个坏掉的格子的位置。
 *
 * 输出：一个整数，代表最多能在棋盘上放的骨牌数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 2, m = 3, broken = [[1, 0], [1, 1]]
 * 输出：2
 * 解释：我们最多可以放两块骨牌：[[0, 0], [0, 1]]以及[[0, 2], [1, 2]]。（见下图）
 *
 *
 *
 *
 * 示例 2：
 *
 * 输入：n = 3, m = 3, broken = []
 * 输出：4
 * 解释：下图是其中一种可行的摆放方式
 *
 *
 *
 *
 * 限制：
 *
 * 1 <= n <= 8
 * 1 <= m <= 8
 * 0 <= b <= n * m
 */
