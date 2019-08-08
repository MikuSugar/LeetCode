package JavaCode.random_records.N601_700;

import JavaCode.data_structure_binary_tree.TreeNode;


public class N687_longest_univalue_path {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    private int res;
    public int longestUnivaluePath(TreeNode root) {
        res=0;
        dfs(-1,root);
        return res;
    }

    private int dfs(int pre, TreeNode root) {
        if(root==null)return 0;
        int temp=0,sum=0;
        if(root.val==pre)
        {
            int l=dfs(pre,root.left);
            int r=dfs(pre,root.right);
            temp=Math.max(l,r)+1;
            sum=l+r;
        }
        else sum =dfs(root.val,root.left)+dfs(root.val,root.right);
        res=Math.max(res,sum);
        return temp;
    }
}
/**
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 *
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 *
 * 示例 1:
 *
 * 输入:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * 输出:
 *
 * 2
 * 示例 2:
 *
 * 输入:
 *
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * 输出:
 *
 * 2
 * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-univalue-path
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
