package JavaCode.random_records.N1401_1500;


import java.util.Arrays;

/**
 * @Author:fangjie
 * @Date:2020/5/14 9:43 下午
 */
public class N1444_number_of_ways_of_cutting_a_pizza {

    public int ways(String[] pizza, int k) {

        int[][][] dp=new int[pizza.length+5][pizza[0].length()+5][k+5];
        for (int[][] arr : dp)
        {
            for (int[] arr1 : arr)
            {
                Arrays.fill(arr1, -1);
            }
        }

        char[][] graph=new char[pizza.length][];
        for (int i=0;i<pizza.length;i++)
        {
            graph[i]=pizza[i].toCharArray();
        }

        return slove(0,0,k-1,graph,dp);
    }

    private int slove(int i, int j, int k, char[][] graph, int[][][] dp) {

        if(dp[i][j][k]!=-1)return dp[i][j][k];

        if(k==0)
        {
            if(check(i,j,graph.length-1,graph[0].length-1,graph))return dp[i][j][k]=1;
            return dp[i][j][k]=0;
        }

        int res=0;
        for (int p=i;p<graph.length;p++)
        {
            if(check(i,j,p,graph[0].length-1,graph))
            {
                res+=slove(p+1,j,k-1,graph,dp)%MOD;
                res%=MOD;
            }
        }
        for (int p=j;p<graph[0].length;p++)
        {
            if(check(i,j,graph.length-1,p,graph))
            {
                res+=slove(i,p+1,k-1,graph,dp)%MOD;
                res%=MOD;
            }
        }
        return dp[i][j][k]=res;
    }

    private boolean check(int i, int j, int i1, int j1, char[][] graph) {
        for (int k1=i;k1<=i1;k1++)
        {
            for (int k2=j;k2<=j1;k2++)
            {
                if(graph[k1][k2]=='A')return true;
            }
        }
        return false;
    }

    private final static int MOD=(int) (1e9+7);
}
/*
给你一个 rows x cols 大小的矩形披萨和一个整数 k ，矩形包含两种字符： 'A' （表示苹果）和 '.' （表示空白格子）。你需要切披萨 k-1 次，得到 k 块披萨并送给别人。

切披萨的每一刀，先要选择是向垂直还是水平方向切，再在矩形的边界上选一个切的位置，将披萨一分为二。如果垂直地切披萨，那么需要把左边的部分送给一个人，如果水平地切，那么需要把上面的部分送给一个人。在切完最后一刀后，需要把剩下来的一块送给最后一个人。

请你返回确保每一块披萨包含 至少 一个苹果的切披萨方案数。由于答案可能是个很大的数字，请你返回它对 10^9 + 7 取余的结果。

 

示例 1：



输入：pizza = ["A..","AAA","..."], k = 3
输出：3
解释：上图展示了三种切披萨的方案。注意每一块披萨都至少包含一个苹果。
示例 2：

输入：pizza = ["A..","AA.","..."], k = 3
输出：1
示例 3：

输入：pizza = ["A..","A..","..."], k = 1
输出：1
 

提示：

1 <= rows, cols <= 50
rows == pizza.length
cols == pizza[i].length
1 <= k <= 10
pizza 只包含字符 'A' 和 '.' 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-ways-of-cutting-a-pizza
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */