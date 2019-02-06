package JavaCode.introduction_to_data_structure_binary_search_tree.appendix_height_balanced_bst;

import JavaCode.introduction_to_data_structure_binary_search_tree.TreeNode;

public class IsBalanced {

    private boolean flag;
    public boolean isBalanced(TreeNode root) {
        flag=true;
        depth(root);
        return flag;
    }

    int depth(TreeNode root)
    {
        if(!flag||root==null) return 0;
        int l=depth(root.left);
        int r=depth(root.right);

        if(Math.abs(l-r)>1)
        {
            flag=false;
            return 0;
        }
        return Math.max(l,r)+1;
    }


}
/**
 * https://leetcode-cn.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/67/appendix-height-balanced-bst/188/
 * 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 */
