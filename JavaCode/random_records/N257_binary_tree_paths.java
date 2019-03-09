package JavaCode.random_records;

import JavaCode.data_structure_binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class N257_binary_tree_paths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res=new ArrayList<>();
        dfs(root,new StringBuilder(),res);
        return res;
    }


    //方法一
    private void dfs(TreeNode root,StringBuilder sb,List<String> res)
    {
        if (root==null) return;
        int len=sb.length();
        sb.append(root.val+"->");
        if(root.left==null&&root.right==null)
        {
            sb.deleteCharAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);
            res.add(sb.toString());
        }
        dfs(root.left,sb,res);
        dfs(root.right,sb,res);
        sb.delete(len,sb.length());
    }

    //方法二
    private void dfs(TreeNode root,ArrayList<Integer> list,List<String> res)
    {
        if(root==null) return;
        list.add(root.val);
        if(root.left==null&&root.right==null)
        {
            res.add(getString(list));
        }
        dfs(root.left,list,res);
        dfs(root.right,list,res);
        list.remove(list.size()-1);
    }

    private String getString(ArrayList<Integer> list)
    {
        if(list.size()==0) return "";
        StringBuilder sb=new StringBuilder();
        for (int i:list)
        {
            sb.append(i+"->");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
/**
 * https://leetcode-cn.com/problems/binary-tree-paths/
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
