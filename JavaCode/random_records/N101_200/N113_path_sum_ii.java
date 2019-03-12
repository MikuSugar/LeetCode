package JavaCode.random_records.N101_200;

import JavaCode.data_structure_binary_tree.TreeNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N113_path_sum_ii {

    private List<List<Integer>> res;
    private int sum;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.res=new ArrayList<>();
        this.sum=sum;
        dfs(0,root,new ArrayList<>());
        return res;
    }

    private void dfs(int s, TreeNode root, ArrayList<Integer> list)
    {
        if(root==null) return;
        s+=root.val;
        list.add(root.val);
        if(s==this.sum&&root.left==null&&root.right==null)
        {
            this.res.add((ArrayList<Integer>)list.clone());
        }
        else
        {
            dfs(s,root.left,list);
            dfs(s,root.right,list);
        }
        list.remove(list.size()-1);
    }
}
/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
