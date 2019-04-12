package JavaCode.random_records.N801_900;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class N897_increasing_order_search_tree {

    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> list=new ArrayList<>();
        dfs(root,list);
        return build(list);
    }

    private TreeNode build(List<TreeNode> list) {
        if(list.size()==0)return null;
        for (int i=0;i<list.size()-1;i++)
        {
            list.get(i).left=null;
            list.get(i).right=list.get(i+1);
        }
        TreeNode tail = list.get(list.size() - 1);
        tail.right=null;
        tail.left=null;
        return list.get(0);
    }

    private void dfs(TreeNode root, List<TreeNode> list) {
        if(root==null)return;
        dfs(root.left,list);
        list.add(root);
        dfs(root.right,list);
    }
}
/**
 * https://leetcode-cn.com/problems/increasing-order-search-tree/
 * 给定一个树，按中序遍历重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 *
 *
 *
 * 示例 ：
 *
 * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 *  /        / \
 * 1        7   9
 *
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 *                  9
 */
