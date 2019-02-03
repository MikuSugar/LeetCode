package JavaCode.data_structure_binary_tree.conclusion;

import JavaCode.data_structure_binary_tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BuildTree {

    private Map<Integer,Integer> inorderMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorderMap=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            inorderMap.put(inorder[i],i);
        }
        TreeNode root=fun(postorder,0,postorder.length-1,0,inorder.length-1);
        return root;

    }

    TreeNode fun(int[] postorder,int pl,int pr,int il,int ir)
    {
        if(il>ir||pl>pr) return null;
        TreeNode root=new TreeNode(postorder[pr]);
        int count=inorderMap.get(root.val);
        root.left=fun(postorder,pl,pl+count-il-1,il,count-1);
        root.right=fun(postorder,pl+count-il,pr-1,count+1,ir);
        return root;
    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/4/conclusion/15/
 * 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
