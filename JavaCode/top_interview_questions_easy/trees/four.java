package JavaCode.top_interview_questions_easy.trees;

import java.util.ArrayList;
import java.util.List;

public class four {
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

        private List<List<Integer>> list;
        public List<List<Integer>> levelOrder(TreeNode root) {
            list=new ArrayList<>();
            if(root==null)
            {
                return list;
            }
            dfs(root,1);
            return list;
        }

        void dfs(TreeNode root,int level)
        {
            if(root==null)
            {
                return;
            }
            if(list.size()<level)
            {
                List<Integer> list1=new ArrayList<>();
                list1.add(root.val);
                list.add(list1);
            }
            else
            {
                List<Integer> list1=list.get(level-1);
                list1.add(root.val);
            }
            dfs(root.left,level+1);
            dfs(root.right,level+1);
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/7/trees/50/
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
