package JavaCode.contest.biweekly_n7;

import java.util.*;

public class N4 {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
       int[] father=new int[n+1];
       for (int i=1;i<=n;i++)
       {
           father[i]=i;
       }
       List<int[]> list=new ArrayList<>();
       for (int i=1;i<=n;i++)
       {
           list.add(new int[]{wells[i-1],0,i});
       }
       for (int[] pipe:pipes)
       {
           list.add(new int[]{pipe[2],pipe[0],pipe[1]});
       }
       list.sort(Comparator.comparingInt(a -> a[0]));
       int res=0;
       for (int[] cur:list)
       {
           int f1=getFahter(cur[1],father);
           int f2=getFahter(cur[2],father);
           if(f1==f2)continue;
           res+=cur[0];
           father[f1]=f2;
       }
       return res;
    }

    private int getFahter(int i, int[] father) {
        return father[i]==i?i:(father[i]=getFahter(father[i],father));
    }
}
/**
 *村里面一共有 n 栋房子。我们希望通过建造水井和铺设管道来为所有房子供水。
 *
 * 对于每个房子 i，我们有两种可选的供水方案：
 *
 * 一种是直接在房子内建造水井，成本为 wells[i]；
 * 另一种是从另一口井铺设管道引水，数组 pipes 给出了在房子间铺设管道的成本，其中每个 pipes[i] = [house1, house2, cost] 代表用管道将 house1 和 house2 连接在一起的成本。当然，连接是双向的。
 * 请你帮忙计算为所有房子都供水的最低总成本。
 *
 *
 *
 * 示例：
 *
 *
 *
 * 输入：n = 3, wells = [1,2,2], pipes = [[1,2,1],[2,3,1]]
 * 输出：3
 * 解释：
 * 上图展示了铺设管道连接房屋的成本。
 * 最好的策略是在第一个房子里建造水井（成本为 1），然后将其他房子铺设管道连起来（成本为 2），所以总成本为 3。
 *
 *
 * 提示：
 *
 * 1 <= n <= 10000
 * wells.length == n
 * 0 <= wells[i] <= 10^5
 * 1 <= pipes.length <= 10000
 * 1 <= pipes[i][0], pipes[i][1] <= n
 * 0 <= pipes[i][2] <= 10^5
 * pipes[i][0] != pipes[i][1]
 */
