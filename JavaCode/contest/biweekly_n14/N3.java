package JavaCode.contest.biweekly_n14;

import java.util.Arrays;

/**
 * author:fangjie
 * time:2019/11/30
 */
public class N3 {
    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        int[] sum=new int[nodes];
        for (int node=0;node<value.length;node++)
        {
            sum[node]+=value[node];
            dfs(node,sum,parent,value[node]);
        }
        int res=0;
        byte[] book=new byte[nodes];
        for (int node=0;node<value.length;node++)
        {
            if(check(sum,node,parent,book))res++;
        }
        System.out.println(Arrays.toString(book));
        return res;
    }

    private boolean check(int[] sum, int node, int[] parent, byte[] book) {
        if(sum[node]==0)
        {
            book[node]=1;
            return false;
        }
        if(parent[node]==-1)
        {
            book[node]=2;
            return true;
        }
        if(book[node]==1)return false;
        if(book[node]==2)return true;
        boolean res=check(sum,parent[node],parent, book);
        if(res) book[node]=2;
        else book[node]=1;
        return res;
    }

    private void dfs(int node, int[] sum, int[] parent, int value) {
        if(parent[node]==-1)return;
        int fa=parent[node];
        sum[fa]+=value;
        dfs(fa,sum,parent,value);
    }

}
/*
给你一棵以节点 0 为根节点的树，定义如下：

节点的总数为 nodes 个；
第 i 个节点的值为 value[i] ；
第 i 个节点的父节点是 parent[i] 。
请你删除节点值之和为 0 的每一棵子树。

在完成所有删除之后，返回树中剩余节点的数目。



示例：



输入：nodes = 7, parent = [-1,0,0,1,2,2,2], value = [1,-2,4,0,-2,-1,-1]
输出：2


提示：

1 <= nodes <= 10^4
-10^5 <= value[i] <= 10^5
parent.length == nodes
parent[0] == -1 表示节点 0 是树的根。
 */
