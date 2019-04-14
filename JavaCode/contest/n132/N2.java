package JavaCode.contest.n132;

import JavaCode.data_structure_binary_tree.TreeNode;

import java.util.ArrayList;

public class N2 {
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
    public int maxAncestorDiff(TreeNode root) {
        this.res=0;
        dfs(root,new ArrayList<TreeNode>());
        return res;
    }

    private void dfs(TreeNode root, ArrayList<TreeNode> nodes) {
        if(root==null)return;
        for (TreeNode node:nodes)
        {
            res=Math.max(res,Math.abs(node.val-root.val));
        }
        nodes.add(root);
        dfs(root.left,nodes);
        dfs(root.right,nodes);
        nodes.remove(nodes.size()-1);
    }
}
/**
 * 5030. 节点与其祖先之间的最大差值  显示英文描述
 * 用户通过次数 0
 * 用户尝试次数 0
 * 通过次数 0
 * 提交次数 0
 * 题目难度 Medium
 * 给定二叉树的根节点 root，找出存在于不同节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
 *
 * （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
 *
 *
 *
 * 示例：
 *
 *
 *
 * 输入：[8,3,10,1,6,null,14,null,null,4,7,13]
 * 输出：7
 * 解释：
 * 我们有大量的节点与其祖先的差值，其中一些如下：
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * 在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
 *
 *
 * 提示：
 *
 * 树中的节点数在 2 到 5000 之间。
 * 每个节点的值介于 0 到 100000 之间。
 */
