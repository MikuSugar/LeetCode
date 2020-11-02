package JavaCode.contest.weekly.n0_200.n131;

import JavaCode.data_structure_binary_tree.TreeNode;

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

    static int M=(int)Math.pow(10,9)+7;
    private int sum;
    public int sumRootToLeaf(TreeNode root) {
        this.sum=0;
        dfs("",root);
        return sum;
    }

    private void dfs(String s, TreeNode root) {
        if(root==null)return;
        s+=root.val;
        dfs(s,root.right);
        dfs(s,root.left);
        if(root.left==null&&root.right==null)
        {
            sum=(sum+help(s))%M;
        }
    }

    private int help(String s) {
        long sum=0;
        for (int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(c=='1')
            {
                sum=sum+(long) (Math.pow(2,s.length()-1-i)%M);
                sum%=M;
            }
        }
        return (int) sum;
    }


}
/**
 * 5017. 从根到叶的二进制数之和  显示英文描述
 * 用户通过次数 12
 * 用户尝试次数 22
 * 通过次数 12
 * 提交次数 34
 * 题目难度 Easy
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 *
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 *
 * 以 10^9 + 7 为模，返回这些数字之和。
 *
 *
 *
 * 示例：
 *
 *
 *
 * 输入：[1,0,1,0,1,0,1]
 * 输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 *
 *
 * 提示：
 *
 * 树中的结点数介于 1 和 1000 之间。
 * node.val 为 0 或 1 。
 */
