package JavaCode.random_records.N1301_1400;

import JavaCode.data_structure_binary_tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * author:fangjie
 * time:2020/3/18
 */
public class N1372_longest_zigzag_path_in_a_binary_tree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    private int res=0;
    public int longestZigZag(TreeNode root) {
        Map<TreeNode,int[]> map=new HashMap<>();
        dfs(root,0,map);
        dfs(root,1,map);
        return res-1;
    }

    private int dfs(TreeNode root, int flag, Map<TreeNode,int[]> map) {
        if(root==null)return 0;
        if(map.containsKey(root))
        {
            int[] book=map.get(root);
            if(book[flag]!=-1)return book[flag];
        }
        int res=1;
        if(flag==0)res+=dfs(root.left,1,map);
        else res+=dfs(root.right,0,map);
        this.res=Math.max(this.res,res);
        dfs(root.right,1,map);
        dfs(root.left,0,map);

        int[] book=map.getOrDefault(root,new int[]{-1,-1});
        book[flag]=res;
        map.put(root,book);
        return res;
    }
}
/*
给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：

选择二叉树中 任意 节点和一个方向（左或者右）。
如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
改变前进方向：左变右或者右变左。
重复第二步和第三步，直到你在树中无法继续移动。
交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。

请你返回给定树中最长 交错路径 的长度。



示例 1：



输入：root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
输出：3
解释：蓝色节点为树中最长交错路径（右 -> 左 -> 右）。
示例 2：



输入：root = [1,1,1,null,1,null,null,1,1,null,1]
输出：4
解释：蓝色节点为树中最长交错路径（左 -> 右 -> 左 -> 右）。
示例 3：

输入：root = [1]
输出：0


提示：

每棵树最多有 50000 个节点。
每个节点的值在 [1, 100] 之间。
 */
