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
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return fun(root.left, root.right);
    }

    private boolean fun(TreeNode left,TreeNode right)
    {
        if(left==null&&right==null) return true;
        else if(left==null||right==null) return false;
        return (left.val==right.val)&&fun(left.left,right.right)&&fun(left.right,right.left);
    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/3/solve-problems-recursively/13/
 *对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 说明:
 *
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */
