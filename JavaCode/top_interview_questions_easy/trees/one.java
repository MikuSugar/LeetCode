package JavaCode.top_interview_questions_easy.trees;

public class one {
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
        private int depth;
        public int maxDepth(TreeNode root) {
            depth=0;
            if(root==null)
            {
                return depth;
            }
            dfs(root,1);
            return depth;
        }

        void dfs(TreeNode root,int level)
        {
            if(root.left!=null)
            {
                dfs(root.left,level+1);
            }
            if(root.right!=null)
            {
                dfs(root.right,level+1);
            }
            depth=Math.max(level,depth);
            return;
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/7/trees/47/
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 */
