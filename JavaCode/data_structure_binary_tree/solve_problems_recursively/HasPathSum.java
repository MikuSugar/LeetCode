package JavaCode.data_structure_binary_tree.solve_problems_recursively;

import JavaCode.data_structure_binary_tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class HasPathSum {

    private boolean isSum;
    public boolean hasPathSum(TreeNode root, int sum) {
        isSum=false;
        dfs(root,sum,0);
        return isSum;
    }

    void dfs(TreeNode root,int sum,int temp_sum)
    {
        if(root==null||isSum) return;
        temp_sum+=root.val;
        if(root.right==null&&root.left==null&&sum==temp_sum)
        {
            isSum=true;
            return;
        }
        dfs(root.left,sum,temp_sum);
        dfs(root.right,sum,temp_sum);
    }


}
/**
 * https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/3/solve-problems-recursively/14/
 * 路径总和
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
