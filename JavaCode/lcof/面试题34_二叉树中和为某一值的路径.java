package JavaCode.lcof;

import JavaCode.data_structure_binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * author:fangjie
 * time:2020/2/13
 */
public class 面试题34_二叉树中和为某一值的路径 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res=new ArrayList<>();
        dfs(sum,root,res,new ArrayList<>());
        return res;
    }

    private void dfs(int sum, TreeNode root, List<List<Integer>> res,List<Integer> list) {
        if(root==null)return;
        sum-=root.val;
        list.add(root.val);
        if(sum==0&&root.left==null&&root.right==null)
        {
            res.add(new ArrayList<>(list));
        }
        else
        {
            dfs(sum,root.left,res,list);
            dfs(sum,root.right,res,list);
        }
        list.remove(list.size()-1);
    }
}
/*
输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。

 

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]
 

提示：

节点总数 <= 10000
注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
