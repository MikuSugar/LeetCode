package JavaCode.random_records.N401_500;

import JavaCode.data_structure_binary_tree.TreeNode;

public class N404_sum_of_left_leaves {
    private int sum;
    public int sumOfLeftLeaves(TreeNode root) {
        this.sum=0;
        dfs(root,false);
        return sum;
    }

    void dfs(TreeNode root,boolean isleft)
    {
        if(root==null) return;
        if(isleft&&root.left==null&&root.right==null)
        {
            sum+=root.val;
        }
        dfs(root.left,true);
        dfs(root.right,false);
    }
}
/**
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */
