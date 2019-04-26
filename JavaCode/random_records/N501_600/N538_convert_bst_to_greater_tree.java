package JavaCode.random_records.N501_600;

import JavaCode.data_structure_binary_tree.TreeNode;

public class N538_convert_bst_to_greater_tree {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public TreeNode convertBST(TreeNode root) {
        if(root!=null)
            dfs(root,0);
        return root;
    }

    private int dfs(TreeNode root, int sum) {
        if (root==null)return sum;
        sum=dfs(root.right,sum);
        root.val+=sum;
        return dfs(root.left,root.val);
    }
}
/**
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * 例如：
 *
 * 输入: 二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 */
