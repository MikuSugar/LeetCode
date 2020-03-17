package JavaCode.random_records.N1301_1400;

import JavaCode.data_structure_binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * author:fangjie
 * time:2020/3/17
 */
public class N1382_balance_a_binary_search_tree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        dfs(root,list);
        return buildTree(list,0,list.size()-1);
    }

    private TreeNode buildTree(List<Integer> list, int left, int right) {
        if(left>right)return null;
        int mid=(left+right)/2;
        TreeNode root=new TreeNode(list.get(mid));
        root.left=buildTree(list,left,mid-1);
        root.right=buildTree(list,mid+1,right);
        return root;
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if(node==null)return;
        dfs(node.left,list);
        list.add(node.val);
        dfs(node.right,list);
    }
}
/*
给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。

如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。

如果有多种构造方法，请你返回任意一种。

 

示例：



输入：root = [1,null,2,null,3,null,4,null,null]
输出：[2,1,3,null,null,null,4]
解释：这不是唯一的正确答案，[3,1,4,null,2,null,null] 也是一个可行的构造方案。
 

提示：

树节点的数目在 1 到 10^4 之间。
树节点的值互不相同，且在 1 到 10^5 之间。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/balance-a-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
