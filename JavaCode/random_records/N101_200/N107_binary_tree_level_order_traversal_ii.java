package JavaCode.random_records.N101_200;

import JavaCode.data_structure_binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N107_binary_tree_level_order_traversal_ii {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        dfs(res,0,root);
        Collections.reverse(res);
        return res;
    }

    private void dfs(List<List<Integer>> res, int level, TreeNode root) {
        if(root==null)return;
        if(res.size()==level)res.add(new ArrayList<>());
        List<Integer> list=res.get(level);
        list.add(root.val);
        dfs(res,level+1,root.left);
        dfs(res,level+1,root.right);
    }
}
/**
 *给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
