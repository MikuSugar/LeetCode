package JavaCode.top_interview_questions_hard.trees_and_graphs;

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
public class MaxPathSum {
    private int max;
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        this.max=Integer.MIN_VALUE;
        dfs(root);
        return this.max;
    }

    private int dfs(TreeNode root)
    {
        if(root==null)return 0;
        int left=Math.max(0,dfs(root.left));
        int right=Math.max(0,dfs(root.right));
        this.max=Math.max(max,root.val+left+right);
        return root.val+Math.max(left,right);
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/57/trees-and-graphs/140/
 * 二叉树中的最大路径和
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 * 示例 2:
 *
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 */

