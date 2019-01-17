package JavaCode.top_interview_questions_medium.trees_and_graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal
{
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {

        private List<Integer> list;
        public List<Integer> inorderTraversal(TreeNode root) {
            list=new ArrayList<>();
            dfs(root);
            //fun(root);
            return list;
        }

        //递归
        void dfs(TreeNode root)
        {
           if(root==null) return;
           dfs(root.left);
           list.add(root.val);
           dfs(root.right);
        }

        //迭代
        void fun(TreeNode root)
        {
            Stack<TreeNode> stack=new Stack<>();
            TreeNode p=root;
            while (p!=null||!stack.isEmpty())
            {
                if(p!=null)
                {
                    stack.push(p);
                    p=p.left;
                }
                else
                {
                    p=stack.pop();
                    list.add(p.val);
                    p=p.right;
                }
            }
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/32/trees-and-graphs/85/
 * 给定一个二叉树，返回它的中序 遍历。
 * 示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
