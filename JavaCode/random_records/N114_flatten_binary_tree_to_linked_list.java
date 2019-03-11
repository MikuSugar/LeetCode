package JavaCode.random_records;

import JavaCode.data_structure_binary_tree.TreeNode;

public class N114_flatten_binary_tree_to_linked_list {

    public void flatten(TreeNode root) {
        if(root==null) return;
        flatten(root.left);
        flatten(root.right);
        if(root.left!=null)
        {
           TreeNode p=root.left;
           while (p.right!=null)
           {
               p=p.right;
           }
           p.right=root.right;
           root.right=root.left;
           root.left=null;
        }
    }
}
/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * 给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
