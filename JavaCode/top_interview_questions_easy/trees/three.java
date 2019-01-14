package JavaCode.top_interview_questions_easy.trees;

public class three {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return fun0(root,root);
        }
    }

    //递归
    boolean fun0(TreeNode left,TreeNode right)
    {
        if(left==null||right==null)
        {
            if(left==null&&right==null)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        if(right.val!=left.val)
        {
            return false;
        }
        return fun0(left.left,right.right)&&fun0(left.right,right.left);
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/7/trees/49/
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 说明:
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */
