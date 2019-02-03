package JavaCode.data_structure_binary_tree.traverse_a_tree;

import JavaCode.data_structure_binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PreorderTraversal {

    private List<Integer> list;
    public List<Integer> preorderTraversal(TreeNode root) {
        list=new ArrayList<>();
        dfs(root);
        return list;
    }


    void dfs(TreeNode root)
    {
        if(root==null) return;
        list.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/2/traverse-a-tree/1/
 *  二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
