package JavaCode.random_records.N601_700;

import JavaCode.data_structure_binary_tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class N653_two_sum_iv_input_is_a_bst
{
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set=new HashSet<>();//存储已经遍历过的值
        return dfs(root,k,set);
    }

    private boolean dfs(TreeNode root,int k,Set<Integer> set)
    {
        if(root==null) return false;
        if(set.contains(k-root.val)) return true;
        set.add(root.val);
        return dfs(root.left,k,set)||dfs(root.right,k,set);
    }
}
/**
 * https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * 案例 1:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * 输出: True
 *
 *
 * 案例 2:
 *
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * 输出: False
 */
