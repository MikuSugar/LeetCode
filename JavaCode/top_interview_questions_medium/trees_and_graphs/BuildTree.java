package JavaCode.top_interview_questions_medium.trees_and_graphs;

import java.util.Map;

public class BuildTree
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
    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return fun0(preorder,inorder,0,0,preorder.length-1);
        }


        /**
         * 通过遍历中序遍历不断地将一棵树分为左子树和右子树
         * @param preorder 前序遍历数组
         * @param inorder 中序遍历数组
         * @param root_index 树的根节点
         * @param left_index 树的左子树最左+1
         * @param right_index 树的右子树最右
         * @return
         */
        TreeNode fun0(int[] preorder,int[] inorder,int root_index,int left_index,int right_index)
        {
            if(root_index>preorder.length-1||left_index>right_index)
            {
                return null;
            }
            TreeNode root=new TreeNode(preorder[root_index]);

            for(int i=left_index;i<=right_index;i++)
            {
                if(root.val==inorder[i])
                {
                    root.left=fun0(preorder,inorder,root_index+1,left_index,i-1);
                    root.right=fun0(preorder,inorder,root_index+i-left_index+1,i+1,right_index);
                    break;
                }
            }
            return root;
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/32/trees-and-graphs/87/
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
