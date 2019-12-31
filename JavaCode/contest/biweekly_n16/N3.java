package JavaCode.contest.biweekly_n16;

import JavaCode.data_structure_binary_tree.TreeNode;

/**
 * author:fangjie
 * time:2019/12/30
 */
public class N3 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    private int[] res;
    public int deepestLeavesSum(TreeNode root) {
        res=new int[]{0,-1};
        dfs(root,0);
        return res[0];
    }

    private void dfs(TreeNode root,int level) {
        if(root==null)return;
        if(root.left==null&&root.right==null)
        {
            if(level>res[1])
            {
                res[0]=root.val;
                res[1]=level;
            }
            else if(level==res[1])
            {
                res[0]+=root.val;
            }
            return;
        }
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
}
/*
给你一棵二叉树，请你返回层数最深的叶子节点的和。

 

示例：



输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
输出：15
 

提示：

树中节点数目在 1 到 10^4 之间。
每个节点的值在 1 到 100 之间。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/deepest-leaves-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
