package JavaCode.contest.biweekly_n10;

import JavaCode.data_structure_binary_tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * author:fangjie
 * time:2019/10/5
 */


public class N2 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Set<Integer> set=new HashSet<>();
        dfs1(root1,set);
        return dfs2(root2,target,set);
    }

    private boolean dfs2(TreeNode root, int target, Set<Integer> set) {
        if(root==null)return false;
        if(set.contains(target-root.val))return true;
        return dfs2(root.left,target,set)||dfs2(root.right,target,set);
    }

    private void dfs1(TreeNode root, Set<Integer> set) {
        if(root==null)return;
        set.add(root.val);
        dfs1(root.left,set);
        dfs1(root.right,set);
    }
}
/**
 *给出两棵二叉搜索树，请你从两棵树中各找出一个节点，使得这两个节点的值之和等于目标值 Target。
 *
 * 如果可以找到返回 True，否则返回 False。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root1 = [2,1,4], root2 = [1,0,3], target = 5
 * 输出：true
 * 解释：2 加 3 和为 5 。
 * 示例 2：
 *
 *
 *
 * 输入：root1 = [0,-10,10], root2 = [5,1,7,0,2], target = 18
 * 输出：false
 *
 *
 * 提示：
 *
 * 每棵树上最多有 5000 个节点。
 * -10^9 <= target, node.val <= 10^9
 */
