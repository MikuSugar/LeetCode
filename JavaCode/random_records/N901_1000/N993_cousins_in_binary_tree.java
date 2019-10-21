package JavaCode.random_records.N901_1000;

import JavaCode.data_structure_binary_tree.TreeNode;

/**
 * author:fangjie
 * time:2019/10/21
 */
public class N993_cousins_in_binary_tree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] fx=find(root,x,-1);
        int[] fy=find(root,y,-1);
        if(fx[0]==fy[0])return false;
        return fx[1]==fy[1];
    }

    private int[] find(TreeNode root, final int find, int pre) {
        if(root==null)return null;
        if(root.val==find)return new int[]{pre,1};
        int[] f=find(root.left, find, root.val);
        if(f==null)f=find(root.right,find,root.val);
        if(f==null)return f;
        f[1]++;
        return f;
    }
}
/**
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 *
 * 如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
 *
 * 我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
 *
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 * 示例 2：
 *
 *
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 * 示例 3：
 *
 *
 *
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 *  
 *
 * 提示：
 *
 * 二叉树的节点数介于 2 到 100 之间。
 * 每个节点的值都是唯一的、范围为 1 到 100 的整数。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cousins-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
