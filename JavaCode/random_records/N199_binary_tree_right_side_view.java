package JavaCode.random_records;

import JavaCode.data_structure_binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class N199_binary_tree_right_side_view
{
    class Node
    {
        TreeNode val;
        int level;
        public Node(TreeNode val,int level)
        {
            this.val=val;
            this.level=level;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(new Node(root,0));
        while (!queue.isEmpty())
        {
            Node node=queue.poll();
            if(node.val==null)continue;
            if(node.level==res.size())
            {
                res.add(node.val.val);
            }
            else
            {
                res.set(node.level,node.val.val);
            }
            queue.offer(new Node(node.val.left,node.level+1));
            queue.offer(new Node(node.val.right,node.level+1));
        }
        return res;
    }
}
/**
 *
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */
