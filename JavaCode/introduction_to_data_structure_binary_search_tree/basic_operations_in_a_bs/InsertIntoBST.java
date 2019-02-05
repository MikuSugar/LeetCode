package JavaCode.introduction_to_data_structure_binary_search_tree.basic_operations_in_a_bs;

import JavaCode.introduction_to_data_structure_binary_search_tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node=new TreeNode(val);
        if(root==null) return node;
        TreeNode p=root;

        while (true)
        {
            if(p.val<val)
            {
                if(p.right==null)
                {
                    p.right=node;
                    break;
                }
                p=p.right;
            }
            else if (p.val>val)
            {
                if(p.left==null)
                {
                    p.left=node;
                    break;
                }
                p=p.left;
            }
        }
        return root;
    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/65/basic-operations-in-a-bst/177/
 * Insert into a Binary Search Tree
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 保证原始二叉搜索树中不存在新值。
 *
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 *
 * 例如,
 *
 * 给定二叉搜索树:
 *
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * 和 插入的值: 5
 * 你可以返回这个二叉搜索树:
 *
 *          4
 *        /   \
 *       2     7
 *      / \   /
 *     1   3 5
 * 或者这个树也是有效的:
 *
 *          5
 *        /   \
 *       2     7
 *      / \
 *     1   3
 *          \
 *           4
 */
