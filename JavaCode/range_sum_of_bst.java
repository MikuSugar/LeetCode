package JavaCode;

public class range_sum_of_bst {
      //Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    class Solution {

        private int sum;
        private int L;
        private int R;

        public int rangeSumBST(TreeNode root, int L, int R)
        {
            sum=0;
            this.L=L;
            this.R=R;
            dfs(root);
            return sum;
        }

        /**
         * DFS遍历树
         */
        void dfs(TreeNode root)
        {
            /**
             * 符合情况sum+
             */
            if(root.val>=L&&root.val<=R)
            {
                this.sum+=root.val;
            }

            /**
             * 递归遍历
             */
            if(root.left!=null)
            {
                dfs(root.left);
            }
            if(root.right!=null)
            {
                dfs(root.right);
            }
        }
    }
}
/**
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 * 二叉搜索树保证具有唯一的值。
 *
 * 示例 1：
 * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
 * 输出：32
 * 示例 2：
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * 输出：23
 */
