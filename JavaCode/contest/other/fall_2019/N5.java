package JavaCode.contest.other.fall_2019;

import java.util.ArrayList;
import java.util.List;

/**
 * author:fangjie
 * time:2019/9/24
 */
public class N5 {

    private final static int MOD=(int) (1e9+7);
    private int dfn;
    public int[] bonus(int n, int[][] leadership, int[][] operations) {
        Tree[] trees=new Tree[n*4+5];
        for (int i=0;i<trees.length;i++)
        {
            trees[i]=new Tree();
        }
        List<Integer>[] edges=new List[n+5];
        for (int i=0;i<edges.length;i++)
        {
            edges[i]=new ArrayList<>();
        }
        for (int[] lead:leadership)
        {
            edges[lead[0]].add(lead[1]);
        }
        dfn=0;

        int[] left=new int[n+5];
        int[] right=new int[n+5];
        dfs(1,0,edges,left,right);
        bulidTree(1,1, dfn,trees);

        List<Integer> res=new ArrayList<>();
        for (int[] op:operations)
        {
            if(op[0]==1)
            {
                change(1,left[op[1]],left[op[1]],op[2],trees);
            }
            else if(op[0]==2)
            {
                change(1,left[op[1]],right[op[1]],op[2],trees);
            }
            else if(op[0]==3)
            {
                res.add((int) (query(1,left[op[1]],right[op[1]],trees)%MOD));
            }
        }
        int[] ans=new int[res.size()];
        int idx=0;
        for (int i:res)ans[idx++]=i;
        return ans;
    }

    private long query(int idx, int left, int right, Tree[] trees) {
        clearn(idx,trees);
        if(left<=trees[idx].left&&trees[idx].right<=right) return trees[idx].sum;
        int mid=(trees[idx].left+trees[idx].right)/2;
        long res=0;
        if(left<=mid)res+=query(idx<<1,left,right,trees);
        if(mid+1<=right)res+=query(idx*2+1,left,right,trees);
        return res;
    }

    private void dfs(int idx, int fa, List<Integer>[] edges, int[] left, int[] right) {
        left[idx]=++dfn;
        for (int x:edges[idx])
        {
            if(x==fa)continue;
            dfs(x,idx,edges,left,right);
        }
        right[idx]=dfn;
    }

    class Tree
    {
        int left,right;
        long sum;
        long lazy_tag;
        long getLen(){return right-left+1;}
    }

    private void bulidTree(int idx,int left,int rifht,Tree[] trees)
    {
        trees[idx].left=left;
        trees[idx].right=rifht;
        trees[idx].sum=trees[idx].lazy_tag=0;
        if(left<rifht)
        {
            int mid=(left+rifht)/2;
            bulidTree(idx<<1,left,mid,trees);
            bulidTree(idx*2+1,mid+1,rifht,trees);
        }
    }

    private void change(int idx,int left,int right,long value,Tree[] trees)
    {
        clearn(idx,trees);
        if(left<=trees[idx].left&&trees[idx].right<=right)
        {
            trees[idx].sum+=value*trees[idx].getLen()%MOD;
            trees[idx].lazy_tag+=value;
            setMod(trees,idx);
        }
        else
        {
            int mid=(trees[idx].left+trees[idx].right)/2;
            if(left<=mid)change(idx<<1,left,right,value,trees);
            if(right>=mid+1)change(idx*2+1,left,right,value,trees);
            update(idx,trees);
        }
    }

    private void update(int idx, Tree[] trees) {
        if(trees[idx].left==trees[idx].right)return;
        trees[idx].sum=trees[idx<<1].sum+trees[idx*2+1].sum;
        setMod(trees,idx);
    }

    private void clearn(int idx, Tree[] trees) {
        if(trees[idx].lazy_tag==0)return;
        if(trees[idx].left==trees[idx].right)return;
        long tag=trees[idx].lazy_tag;
        trees[idx].lazy_tag=0;
        trees[idx<<1].lazy_tag+=tag;
        trees[idx*2+1].lazy_tag+=tag;
        trees[idx<<1].sum+=tag*trees[idx<<1].getLen()%MOD;
        trees[idx*2+1].sum+=tag*trees[idx*2+1].getLen()%MOD;
        setMod(trees,idx<<1);
        setMod(trees,idx*2+1);
    }
    private void setMod(Tree[] trees,int idx)
    {
        trees[idx].lazy_tag%=MOD;
        trees[idx].sum%=MOD;
    }

}
/**
 *力扣决定给一个刷题团队发LeetCoin作为奖励。同时，为了监控给大家发了多少LeetCoin，力扣有时候也会进行查询。
 *
 *
 *
 * 该刷题团队的管理模式可以用一棵树表示：
 *
 * 团队只有一个负责人，编号为1。除了该负责人外，每个人有且仅有一个领导（负责人没有领导）；
 * 不存在循环管理的情况，如A管理B，B管理C，C管理A。
 *
 *
 * 力扣想进行的操作有以下三种：
 *
 * 给团队的一个成员（也可以是负责人）发一定数量的LeetCoin；
 * 给团队的一个成员（也可以是负责人），以及他/她管理的所有人（即他/她的下属、他/她下属的下属，……），发一定数量的LeetCoin；
 * 查询某一个成员（也可以是负责人），以及他/她管理的所有人被发到的LeetCoin之和。
 *
 *
 * 输入：
 *
 * N表示团队成员的个数（编号为1～N，负责人为1）；
 * leadership是大小为(N - 1) * 2的二维数组，其中每个元素[a, b]代表b是a的下属；
 * operations是一个长度为Q的二维数组，代表以时间排序的操作，格式如下：
 * operations[i][0] = 1: 代表第一种操作，operations[i][1]代表成员的编号，operations[i][2]代表LeetCoin的数量；
 * operations[i][0] = 2: 代表第二种操作，operations[i][1]代表成员的编号，operations[i][2]代表LeetCoin的数量；
 * operations[i][0] = 3: 代表第三种操作，operations[i][1]代表成员的编号；
 * 输出：
 *
 * 返回一个数组，数组里是每次查询的返回值（发LeetCoin的操作不需要任何返回值）。由于发的LeetCoin很多，请把每次查询的结果模1e9+7 (1000000007)。
 *
 *
 *
 * 示例 1：
 *
 * 输入：N = 6, leadership = [[1, 2], [1, 6], [2, 3], [2, 5], [1, 4]], operations = [[1, 1, 500], [2, 2, 50], [3, 1], [2, 6, 15], [3, 1]]
 * 输出：[650, 665]
 * 解释：团队的管理关系见下图。
 * 第一次查询时，每个成员得到的LeetCoin的数量分别为（按编号顺序）：500, 50, 50, 0, 50, 0;
 * 第二次查询时，每个成员得到的LeetCoin的数量分别为（按编号顺序）：500, 50, 50, 0, 50, 15.
 *
 *
 *
 *
 * 限制：
 *
 * 1 <= N <= 50000
 * 1 <= Q <= 50000
 * operations[i][0] != 3 时，1 <= operations[i][2] <= 5000
 */
