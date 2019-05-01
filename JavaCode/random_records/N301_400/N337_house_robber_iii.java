package JavaCode.random_records.N301_400;

import JavaCode.data_structure_binary_tree.TreeNode;

public class N337_house_robber_iii {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public int rob(TreeNode root) {
        int[] res_max=help(root);
        return Math.max(res_max[0],res_max[1]);
    }

    /**
     * @param root
     * @return 两种情况的最大值 【0】不偷当前节点的最大值 【1】偷当前节点的最大值
     */
    private int[] help(TreeNode root) {
        if(root==null)return new int[]{0,0};
        int[] l_max=help(root.left);
        int[] r_max=help(root.right);
        int[] res_max=new int[2];
        res_max[0]=Math.max(l_max[0],l_max[1])+Math.max(r_max[0],r_max[1]);
        res_max[1]=l_max[0]+r_max[0]+root.val;
        return res_max;
    }
}
/**
 * https://leetcode-cn.com/problems/house-robber-iii/
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 示例 1:
 *
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 *
 * 输入: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 */
