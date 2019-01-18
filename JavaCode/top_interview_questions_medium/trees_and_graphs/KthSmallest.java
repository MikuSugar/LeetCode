package JavaCode.top_interview_questions_medium.trees_and_graphs;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class KthSmallest
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
        private TreeSet<Integer> set;
        public int kthSmallest(TreeNode root, int k)
        {
            set = new TreeSet<>();
            dfs(root);
            int i = 0;
            for (int s : set)
            {
                i++;
                if (i == k)
                {
                    return s;
                }
            }
            return -1;
        }

        void dfs(TreeNode root)
        {
            if(root==null) return;
            set.add(root.val);
            dfs(root.left);
            dfs(root.right);
        }
    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/32/trees-and-graphs/89/
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 3
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 */
