package JavaCode.data_structure_binary_tree.conclusion;


import JavaCode.data_structure_binary_tree.TreeLinkNode;

public class Connect {

    /**
     * Definition for binary tree with next pointer.
     * public class TreeLinkNode {
     *     int val;
     *     TreeLinkNode left, right, next;
     *     TreeLinkNode(int x) { val = x; }
     * }
     */
    public void connect(TreeLinkNode root) {
        if(root==null) return;
        TreeLinkNode p=root.next;
        while (p!=null)
        {
            if(p.left!=null)
            {
                p=p.left;
                break;
            }
            if(p.right!=null)
            {
                p=p.right;
                break;
            }
            p=p.next;
        }
        if(root.right!=null) root.right.next=p;
        if(root.left!=null)root.left.next=root.right!=null?root.right:p;
        connect(root.right);
        connect(root.left);
    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/4/conclusion/18/
 * 每个节点的右向指针 II
 * 给定一个二叉树
 *
 * struct TreeLinkNode {
 *   TreeLinkNode *left;
 *   TreeLinkNode *right;
 *   TreeLinkNode *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 说明:
 *
 * 你只能使用额外常数空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * 示例:
 *
 * 给定二叉树，
 *
 *      1
 *    /  \
 *   2    3
 *  / \    \
 * 4   5    7
 * 调用你的函数后，该二叉树变为：
 *
 *      1 -> NULL
 *    /  \
 *   2 -> 3 -> NULL
 *  / \    \
 * 4-> 5 -> 7 -> NULL
 */
