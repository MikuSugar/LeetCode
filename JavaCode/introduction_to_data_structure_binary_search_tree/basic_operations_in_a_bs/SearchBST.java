package JavaCode.introduction_to_data_structure_binary_search_tree.basic_operations_in_a_bs;

import JavaCode.introduction_to_data_structure_binary_search_tree.TreeNode;

public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {

        while (root!=null)
        {
            if(root.val==val) return root;
            else if(root.val<val) root=root.right;
            else root=root.left;
        }
        return null;
    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/65/basic-operations-in-a-bst/174/
 * Search in a Binary Search Tree
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 *
 * 例如，
 *
 * 给定二叉搜索树:
 *
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * 和值: 2
 * 你应该返回如下子树:
 *
 *       2
 *      / \
 *     1   3
 * 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
 */
