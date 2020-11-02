package JavaCode.contest.biweekly.biweekly_n17;

import JavaCode.data_structure_binary_tree.TreeNode;

/**
 * author:fangjie
 * time:2020/1/11
 */
public class N3 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    private int sum;
    public int sumEvenGrandparent(TreeNode root) {
        sum=0;
        slove(root);
        return sum;
    }

    private void slove(TreeNode root) {
        if(root==null)return;
        if(root.val%2==0) sum+=dfs(root.left,1)+dfs(root.right,1);
        slove(root.left);
        slove(root.right);
    }

    private int dfs(TreeNode node, int cnt) {
        if(node==null)return 0;
        if(cnt==0)return node.val;
        return dfs(node.left,cnt-1)+dfs(node.right,cnt-1);
    }
}
/*
给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：

该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
如果不存在祖父节点值为偶数的节点，那么返回 0 。



示例：



输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
输出：18
解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。


提示：

树中节点的数目在 1 到 10^4 之间。
每个节点的值在 1 到 100 之间。

 */
