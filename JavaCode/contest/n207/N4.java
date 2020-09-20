package JavaCode.contest.n207;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * author: fangjie
 * email: syfangjie@live.cn
 * date: 2020/9/20 10:15 上午
 */
public class N4 {
    public static void main(String[] args) {

    }
    //TODO
    public int connectTwoGroups(List<List<Integer>> cost) {
        List<int[]> edges=new ArrayList<>(cost.size()*cost.get(0).size()+5);
        for (int i=0;i<cost.size();i++){
            for (int j=0;j<cost.get(i).size();j++){
                edges.add(new int[]{i,j,cost.get(i).get(j)});
            }
        }
        int tar1=(1<<cost.size())-1;
        int tar2=(1<<cost.get(0).size())-1;
        return slove(0,0,tar1,tar2,edges,new int[tar1+1][tar2+1],new boolean[edges.size()]);
    }

    private int slove(int cur1, int cur2, int tar1, int tar2, List<int[]> edges, int[][] dp, boolean[] book) {
        if(cur1==tar1&&cur2==tar2)return 0;
        String key=cur1+","+cur2;
        if(dp[cur1][cur2]!=0)return dp[cur1][cur2];
        int res=Integer.MAX_VALUE>>1;
        for (int i=0;i<edges.size();i++){
            if(book[i])continue;
            book[i]=true;
            int[] e=edges.get(i);
            int n1=cur1|(1<<e[0]);
            int n2=cur2|(1<<e[1]);
            if (n1!=cur1||n2!=cur2) {
                res=Math.min(res,e[2]+slove(n1,n2,tar1,tar2,edges,dp, new boolean[edges.size()]));
            }
            book[i]=false;
        }
        return dp[cur1][cur2]=res;
    }
}
/*
给你两组点，其中第一组中有 size1 个点，第二组中有 size2 个点，且 size1 >= size2 。

任意两点间的连接成本 cost 由大小为 size1 x size2 矩阵给出，其中 cost[i][j] 是第一组中的点 i 和第二组中的点 j 的连接成本。如果两个组中的每个点都与另一组中的一个或多个点连接，则称这两组点是连通的。换言之，第一组中的每个点必须至少与第二组中的一个点连接，且第二组中的每个点必须至少与第一组中的一个点连接。

返回连通两组点所需的最小成本。



示例 1：



输入：cost = [[15, 96], [36, 2]]
输出：17
解释：连通两组点的最佳方法是：
1--A
2--B
总成本为 17 。
示例 2：



输入：cost = [[1, 3, 5], [4, 1, 1], [1, 5, 3]]
输出：4
解释：连通两组点的最佳方法是：
1--A
2--B
2--C
3--A
最小成本为 4 。
请注意，虽然有多个点连接到第一组中的点 2 和第二组中的点 A ，但由于题目并不限制连接点的数目，所以只需要关心最低总成本。
示例 3：

输入：cost = [[2, 5, 1], [3, 4, 7], [8, 1, 2], [6, 2, 4], [3, 8, 8]]
输出：10


提示：

size1 == cost.length
size2 == cost[i].length
1 <= size1, size2 <= 12
size1 >= size2
0 <= cost[i][j] <= 100
 */
