package JavaCode.contest.weekly.n0_200.n127;

import JavaCode.data_structure_binary_tree.TreeNode;


public class N4 {
    public TreeNode bstFromPreorder(int[] preorder) {
        return getRoot(0,preorder.length-1,preorder);
    }

    private TreeNode getRoot(int l,int r,int[] pre)
    {
        TreeNode root=new TreeNode(pre[l]);
        if(r>l)
        {
            int index=getindex(l,r,pre);
            if(index==-1)
            {
                root.left=getRoot(l+1,r,pre);
                root.right=null;
            }
            else if(index==l+1)
            {
                root.left=null;
                root.right=getRoot(l+1,r,pre);
            }
            else
            {
                root.left=getRoot(l+1,index-1,pre);
                root.right=getRoot(index,r,pre);
            }
        }
        return root;
    }

    private int getindex(int l,int r,int[] pre)
    {
        for (int i=l+1;i<=r;i++)
        {
            if (pre[i]>pre[l])
            {
                return i;
            }
        }
        return -1;
    }

}
/**
 * 先序遍历构造二叉树  显示英文描述
 * 用户通过次数 24
 * 用户尝试次数 27
 * 通过次数 25
 * 提交次数 30
 * 题目难度 Medium
 * 返回与给定先序遍历 preorder 相匹配的二叉搜索树（binary search tree）的根结点。
 *
 * (回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，对于 node.left 的任何后代，值总 < node.val，而 node.right 的任何后代，值总 > node.val。此外，先序遍历首先显示节点的值，然后遍历 node.left，接着遍历 node.right。）
 *
 *
 *
 * 示例：
 *
 * 输入：[8,5,1,7,10,12]
 * 输出：[8,5,10,1,7,null,12]
 */
