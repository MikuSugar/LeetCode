package JavaCode.contest.weekly.n0_200.n135;

import JavaCode.data_structure_binary_tree.TreeNode;

public class N2 {
    private int sum;
    public TreeNode bstToGst(TreeNode root) {
        if(root==null)return null;
        sum=0;
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if(root==null)return;
        dfs(root.right);
        sum+=root.val;
        root.val=sum;
        dfs(root.left);
    }

}
/**
 *给出二叉搜索树的根节点，该二叉树的节点值各不相同，修改二叉树，使每个节点 node 的新值等于原树的值之和，这个值应该大于或等于 node.val。
 *
 * 提醒一下，二叉搜索树满足下列约束条件：
 *
 * 节点的左子树仅包含键小于节点键的节点。
 * 节点的右子树仅包含键大于节点键的节点。
 * 左右子树也必须是二叉搜索树。
 *
 *
 * 示例：
 *
 *
 *
 * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 *
 *
 * 提示：
 *
 * 树中的节点数介于 1 和 100 之间。
 * 每个节点的值介于 0 和 100 之间。
 * 给定的树为二叉搜索树。
 */
