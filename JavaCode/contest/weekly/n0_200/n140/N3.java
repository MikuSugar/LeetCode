package JavaCode.contest.weekly.n0_200.n140;

import JavaCode.data_structure_binary_tree.TreeNode;


public class N3 {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return dfs(root,limit,0)<limit?null:root;
    }

    private int dfs(TreeNode root, int limit, int sum) {
        if(root==null)return sum;
        sum+=root.val;
        int left=dfs(root.left,limit,sum);
        int right=dfs(root.right,limit,sum);
        if(left<limit)root.left=null;
        if (right<limit)root.right=null;
        return Math.max(left,right);
    }
}
/**
 *给定二叉树的根 root，考虑所有从根到叶的路径：从根到任何叶的路径。 （叶节点是没有子节点的节点。）
 *
 * 如果交于节点 node 的每个根到叶路径的总和严格小于限制 limit，则该节点为不足节点。
 *
 * 同时删除所有不足节点，并返回生成的二叉树的根。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14], limit = 1
 *
 * 输出：[1,2,3,4,null,null,7,8,9,null,14]
 * 示例 2：
 *
 *
 * 输入：root = [5,4,8,11,null,17,4,7,1,null,null,5,3], limit = 22
 *
 * 输出：[5,4,8,11,null,17,4,7,null,null,null,5]
 * 示例 3：
 *
 *
 * 输入：root = [5,-6,-6], limit = 0
 * 输出：[]
 *
 *
 * 提示：
 *
 * 给定的树有 1 到 5000 个节点
 * -10^5 <= node.val <= 10^5
 * -10^9 <= limit <= 10^9
 *
 */
