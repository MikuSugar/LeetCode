package JavaCode.top_interview_questions_easy.trees;

public class two {
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


        public boolean isValidBST(TreeNode root) {
            if(root==null)
            {
                return true;
            }
            return dfs(root,Long.MAX_VALUE,Long.MIN_VALUE);
        }

        /**
         * 用Long 是为了防止int极端情况
         * @param root
         * @param max
         * @param min
         * @return
         */
        boolean dfs(TreeNode root,long max,long min)
        {
            if(root==null)
            {
                return true;
            }
            if(root.val<=min||root.val>=max)
            {
                return false;
            }
            return dfs(root.left,root.val,min)&&dfs(root.right,max,root.val);
        }

    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/7/trees/48/
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
