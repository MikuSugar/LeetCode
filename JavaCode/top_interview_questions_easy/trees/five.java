package JavaCode.top_interview_questions_easy.trees;

public class five {
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

        private int[] nums;
        public TreeNode sortedArrayToBST(int[] nums) {
            this.nums=nums;
            return fun0(0,nums.length-1);

        }


        /**
         * 递归添加
         * @param left 左边界
         * @param right 右边界
         * @return
         */
        TreeNode fun0(int left,int right)
        {
            if(left>right)
            {
                return null;
            }
            int mid=(left+right)/2;
            TreeNode node=new TreeNode(nums[mid]);
            node.left=fun0(left,mid-1);
            node.right=fun0(mid+1,right);
            return node;
        }

    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/7/trees/51/
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
