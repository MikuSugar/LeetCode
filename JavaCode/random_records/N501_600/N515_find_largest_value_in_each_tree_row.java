package JavaCode.random_records.N501_600;

import JavaCode.data_structure_binary_tree.TreeNode;

import java.util.*;

public class N515_find_largest_value_in_each_tree_row {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res=new LinkedList<>();
        if (root==null)return res;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            int size = queue.size();
            int max=Integer.MIN_VALUE;
            for (int i=0;i<size;i++)
            {
                TreeNode node = queue.poll();
                max=Math.max(node.val,max);
                if(node.left!=null)queue.add(node.left);
                if(node.right!=null)queue.add(node.right);
            }
            res.add(max);
        }
        return res;
    }
}
/**
 *您需要在二叉树的每一行中找到最大的值。
 *
 * 示例：
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * 输出: [1, 3, 9]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
