package JavaCode.random_records.N401_500;

import JavaCode.data_structure_binary_tree.TreeNode;

import java.util.TreeSet;

public class N530_minimum_absolute_difference_in_bst {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    private TreeNode pre;
    public int getMinimumDifference(TreeNode root) {
        int res=Integer.MAX_VALUE;
        if(root==null)return res;
        res=getMinimumDifference(root.left);
        if(pre!=null)
        {
            res=Math.min(res,root.val-pre.val);
        }
        pre=root;
        return Math.min(res,getMinimumDifference(root.right));
    }
}
/**
 *给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
 *
 * 示例 :
 *
 * 输入:
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出:
 * 1
 *
 * 解释:
 * 最小绝对差为1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 */
