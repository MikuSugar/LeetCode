package JavaCode.introduction_to_data_structure_binary_search_tree.basic_operations_in_a_bs;

import JavaCode.introduction_to_data_structure_binary_search_tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
       if(root==null) return null;
       if(root.val>key) root.left=deleteNode(root.left,key);
       else if(root.val<key) root.right=deleteNode(root.right,key);
       else
       {
           if(root.left==null)return root.right;
           if(root.right==null) return root.left;
           TreeNode temp=root;
           root=foundmin(temp.right);
           root.right=deletemin(temp.right);
           root.left=temp.left;
       }

       return root;
    }

    /**
     * 找以root为根的最小的节点
     * @param root
     * @return
     */
    TreeNode foundmin(TreeNode root)
    {
        if(root.left==null) return root;
        return foundmin(root.left);
    }

    /**
     * 删除以root为根的最小的节点
     * @param root
     * @return
     */
    TreeNode deletemin(TreeNode root)
    {
        if(root==null) return null;
        if(root.left!=null) root.left=deletemin(root.left);
        else return root.right;
        return root;
    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/65/basic-operations-in-a-bst/180/
 * Delete Node in a BST
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 *
 * 示例:
 *
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 *
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 *
 *     5
 *    / \
 *   4   6
 *  /     \
 * 2       7
 *
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 *
 *     5
 *    / \
 *   2   6
 *    \   \
 *     4   7
 */
