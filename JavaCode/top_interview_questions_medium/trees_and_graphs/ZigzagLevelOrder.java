package JavaCode.top_interview_questions_medium.trees_and_graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZigzagLevelOrder
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

        private List<List<Integer>> list;
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            list=new ArrayList<>();
            dfs(root,1);

            for(int i=0;i<list.size();i++)
            {
                if(i%2!=0)
                {
                    Collections.reverse(list.get(i));
                }
            }

            return list;
        }

        void dfs(TreeNode root,int level)
        {
           if(root!=null)
           {
               if(level<=list.size())
               {
                   list.get(level-1).add(root.val);
               }
               else
               {
                   List<Integer> list1=new ArrayList<>();
                   list1.add(root.val);
                   list.add(list1);
               }
               dfs(root.left,level+1);
               dfs(root.right,level+1);
           }
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/32/trees-and-graphs/86/
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
