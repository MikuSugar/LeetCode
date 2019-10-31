package JavaCode.random_records.N901_1000;

import JavaCode.data_structure_binary_tree.TreeNode;

/**
 * author:fangjie
 * time:2019/10/31
 */
public class N965_univalued_binary_tree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public boolean isUnivalTree(TreeNode root) {
        return dfs(root.left,root.val)&&dfs(root.right,root.val);
    }

    private boolean dfs(TreeNode node, int val) {
        if(node==null)return true;
        if(node.val!=val)return false;
        return dfs(node.left,val)&&dfs(node.right,val);
    }
}
/*
如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。

只有给定的树是单值二叉树时，才返回 true；否则返回 false。

 

示例 1：



输入：[1,1,1,1,1,null,1]
输出：true
示例 2：



输入：[2,2,2,5,2]
输出：false
 

提示：

给定树的节点数范围是 [1, 100]。
每个节点的值都是整数，范围为 [0, 99] 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/univalued-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
