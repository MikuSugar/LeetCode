package JavaCode.contest.weekly.n0_200.n150;

import JavaCode.data_structure_binary_tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

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
    public int maxLevelSum(TreeNode root) {
        if(root==null)return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int res=1,level=0,max=Integer.MIN_VALUE;
        while (!queue.isEmpty())
        {
            level++;
            int sum=0;
            int size = queue.size();
            for (int i=0;i<size;i++)
            {
                TreeNode poll = queue.poll();
                sum+=poll.val;
                if(poll.left!=null)queue.add(poll.left);
                if(poll.right!=null)queue.add(poll.right);
            }
            if(sum>max)
            {
                max=sum;
                res=level;
            }
        }
        return res;
    }
}
/**
 *给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 *
 * 请你找出层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
 *
 *
 *
 * 示例：
 *
 *
 *
 * 输入：[1,7,0,7,-8,null,null]
 * 输出：2
 * 解释：
 * 第 1 层各元素之和为 1，
 * 第 2 层各元素之和为 7 + 0 = 7，
 * 第 3 层各元素之和为 7 + -8 = -1，
 * 所以我们返回第 2 层的层号，它的层内元素之和最大。
 *
 *
 * 提示：
 *
 * 树中的节点数介于 1 和 10^4 之间
 * -10^5 <= node.val <= 10^5
 */
