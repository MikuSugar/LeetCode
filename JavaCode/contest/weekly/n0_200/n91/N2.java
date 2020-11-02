package JavaCode.contest.weekly.n0_200.n91;

import JavaCode.data_structure_binary_tree.TreeNode;

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
public class N2 {

    private class Node
    {
        int val;
        Node left;
        Node right;
        Node father;
        Node(int x)
        {
            val=x;
        }

        boolean flag;
    }

    private Node start;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res=new ArrayList<>();
        dfs(root,null,target);
        help(start,K,0,res);
        return res;
    }

    private void help(Node node, int k, int i, List<Integer> res) {
        if (node==null||node.flag)return;
        if(i>k)return;
        if(i==k)
        {
            res.add(node.val);
            return;
        }
        node.flag=true;
        help(node.father,k,i+1,res);
        help(node.left,k,i+1,res);
        help(node.right,k,i+1,res);
        node.flag=false;
    }

    private Node dfs(TreeNode root,Node pre,TreeNode target)
    {
        if(root==null) return null;
        Node node=new Node(root.val);
        if(root==target)
        {
            this.start=node;
        }
        node.father=pre;
        node.left=dfs(root.left,node,target);
        node.right=dfs(root.right,node,target);
        return node;
    }


}
/**
 * 863. 二叉树中所有距离为 K 的结点  显示英文描述
 * 用户通过次数 39
 * 用户尝试次数 59
 * 通过次数 39
 * 提交次数 174
 * 题目难度 Medium
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 *
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 *
 * 输出：[7,4,1]
 *
 * 解释：
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 *
 *
 *
 * 注意，输入的 "root" 和 "target" 实际上是树上的结点。
 * 上面的输入仅仅是对这些对象进行了序列化描述。
 *
 *
 * 提示：
 *
 * 给定的树是非空的，且最多有 K 个结点。
 * 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。
 * 目标结点 target 是树上的结点。
 * 0 <= K <= 1000.
 */
