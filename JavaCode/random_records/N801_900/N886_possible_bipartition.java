package JavaCode.random_records.N801_900;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N886_possible_bipartition
{
    //染色法
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] color=new int[N+1];
        List<Integer>[] book=new ArrayList[N+1];
        for (int i=1;i<=N;i++)
        {
            book[i]=new ArrayList<>();
            color[i]=-1;
        }
        for (int[] a:dislikes)
        {
            book[a[0]].add(a[1]);
            book[a[1]].add(a[0]);
        }
        for (int i=1;i<=N;i++)
        {
            if(color[i]==-1&&!dfs(i,0,book,color))
            {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int num,int c,List<Integer>[] book,int[] color)
    {
        if(color[num]!=-1)
        {
            return color[num]==c;
        }
        color[num]=c;
        int t_c=c==0?1:0;
        for (int i:book[num])
        {
            if(!dfs(i,t_c,book,color))
            {
                return false;
            }
        }
        return true;
    }
}
/**
 * https://leetcode-cn.com/problems/possible-bipartition/
 * 给定一组 N 人（编号为 1, 2, ..., N）， 我们想把每个人分进任意大小的两组。
 *
 * 每个人都可能不喜欢其他人，那么他们不应该属于同一组。
 *
 * 形式上，如果 dislikes[i] = [a, b]，表示不允许将编号为 a 和 b 的人归入同一组。
 *
 * 当可以用这种方法将每个人分进两组时，返回 true；否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：N = 4, dislikes = [[1,2],[1,3],[2,4]]
 * 输出：true
 * 解释：group1 [1,4], group2 [2,3]
 * 示例 2：
 *
 * 输入：N = 3, dislikes = [[1,2],[1,3],[2,3]]
 * 输出：false
 * 示例 3：
 *
 * 输入：N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= N <= 2000
 * 0 <= dislikes.length <= 10000
 * 1 <= dislikes[i][j] <= N
 * dislikes[i][0] < dislikes[i][1]
 * 对于 dislikes[i] == dislikes[j] 不存在 i != j
 */
