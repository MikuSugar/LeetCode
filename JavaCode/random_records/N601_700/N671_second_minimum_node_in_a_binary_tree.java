package JavaCode.random_records.N601_700;

import JavaCode.data_structure_binary_tree.TreeNode;

public class N671_second_minimum_node_in_a_binary_tree {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public int findSecondMinimumValue(TreeNode root) {
        if(root==null)return -1;
        return dfs(root,root.val);
    }

    private int dfs(TreeNode node, int target) {
        if(node==null)return -1;
        if(node.val>target)return node.val;
        int left=dfs(node.left,target);
        int right=dfs(node.right,target);
        if(left==-1&&right==-1)return -1;
        if(left==-1)return right;
        if(right==-1)return left;
        return Math.min(left,right);
    }
}
/**
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。
 *
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   2   5
 *      / \
 *     5   7
 *
 * 输出: 5
 * 说明: 最小的值是 2 ，第二小的值是 5 。
 * 示例 2:
 *
 * 输入:
 *     2
 *    / \
 *   2   2
 *
 * 输出: -1
 * 说明: 最小的值是 2, 但是不存在第二小的值。
 */
