package JavaCode.random_records.N901_1000;

import java.util.Arrays;

public class N913_cat_and_mouse {
    private int[][][] dp;
    public int catMouseGame(int[][] graph) {
        dp=new int[2*graph.length][graph.length][graph.length];
        for (int[][] dd:dp)
        {
            for (int[] p:dd)
            {
                Arrays.fill(p,-1);
            }
        }
        return solve(graph,0,1,2);
    }

    private int solve(int[][] graph, int t, int mouse, int cat) {
        if(t==dp.length)return 0;
        if(mouse==cat)return dp[t][mouse][cat]=2;
        if(mouse==0)return dp[t][mouse][cat]=1;
        if(dp[t][mouse][cat]!=-1)return dp[t][mouse][cat];
        boolean flag=true;
        if(t%2==0)//mouse go
        {
            for (int i:graph[mouse])
            {
                int next=solve(graph,t+1,i,cat);
                if(next==1)return dp[t][mouse][cat]=1;
                else if(next!=2)flag=false;
            }
           if (flag)return dp[t][mouse][cat]=2;
           return dp[t][mouse][cat]=0;
        }
        else //cat go
        {
            for (int i:graph[cat])
            {
                if(i==0)continue;
                int next=solve(graph,t+1,mouse,i);
                if(next==2)return dp[t][mouse][cat]=2;
                else if(next!=1)flag=false;
            }
            if(flag)return dp[t][mouse][cat]=1;
            return dp[t][mouse][cat]=0;
        }
    }
}
/**
 * 两个玩家分别扮演猫（Cat）和老鼠（Mouse）在无向图上进行游戏，他们轮流行动。
 *
 * 该图按下述规则给出：graph[a] 是所有结点 b 的列表，使得 ab 是图的一条边。
 *
 * 老鼠从结点 1 开始并率先出发，猫从结点 2 开始且随后出发，在结点 0 处有一个洞。
 *
 * 在每个玩家的回合中，他们必须沿着与他们所在位置相吻合的图的一条边移动。例如，如果老鼠位于结点 1，那么它只能移动到 graph[1] 中的（任何）结点去。
 *
 * 此外，猫无法移动到洞（结点 0）里。
 *
 * 然后，游戏在出现以下三种情形之一时结束：
 *
 * 如果猫和老鼠占据相同的结点，猫获胜。
 * 如果老鼠躲入洞里，老鼠获胜。
 * 如果某一位置重复出现（即，玩家们的位置和移动顺序都与上一个回合相同），游戏平局。
 * 给定 graph，并假设两个玩家都以最佳状态参与游戏，如果老鼠获胜，则返回 1；如果猫获胜，则返回 2；如果平局，则返回 0。
 *
 *  
 *
 * 示例：
 *
 * 输入：[[2,5],[3],[0,4,5],[1,4,5],[2,3],[0,2,3]]
 * 输出：0
 * 解释：
 * 4---3---1
 * |   |
 * 2---5
 *  \ /
 *   0
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cat-and-mouse
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
