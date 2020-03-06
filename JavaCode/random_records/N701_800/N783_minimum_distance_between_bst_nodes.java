package JavaCode.random_records.N701_800;

import JavaCode.data_structure_binary_tree.TreeNode;

/**
 * author:fangjie
 * time:2020/3/6
 */
public class N783_minimum_distance_between_bst_nodes {
    private int res=Integer.MAX_VALUE;
    private int pre=-1;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if(root==null)return;
        dfs(root.left);
        if(pre!=-1)res=Math.min(res,root.val-pre);
        pre=root.val;
        dfs(root.right);
    }
}
/*
给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。

示例：

输入: root = [4,2,6,1,3,null,null]
输出: 1
解释:
注意，root是树结点对象(TreeNode object)，而不是数组。

给定的树 [4,2,6,1,3,null,null] 可表示为下图:

          4
        /   \
      2      6
     / \
    1   3

最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
注意：

二叉树的大小范围在 2 到 100。
二叉树总是有效的，每个节点的值都是整数，且不重复。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
