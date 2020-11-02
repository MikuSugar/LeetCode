package JavaCode.contest.weekly.n0_200.n145;

import JavaCode.data_structure_binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root==null)return root;
        List<List<TreeNode>> level=new ArrayList<>();
        dfs(root,0,level);
        List<TreeNode> last = level.get(level.size() - 1);
        if(last.size()==1)
        {
            return last.get(0);
        }
        TreeNode res=last.get(0);
        for (int i=1;i<last.size();i++)
        {
            res=search(root,res,last.get(i));
        }
        return res;
    }

    private void dfs(TreeNode root, int level,List<List<TreeNode>> list)
    {
        if(root==null)return;
        if (list.size()==level)
        {
            list.add(new ArrayList<>());
        }
        list.get(level).add(root);
        dfs(root.left,level+1,list);
        dfs(root.right,level+1,list);

    }

    private TreeNode search(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q) return root;

        TreeNode left= search(root.left,p,q);
        TreeNode right= search(root.right,p,q);

        if(left!=null&&right!=null)return root;
        else if(left!=null) return left;
        else if(right!=null) return right;
        return null;
    }
}
/**
 *给你一个有根节点的二叉树，找到它最深的叶节点的最近公共祖先。
 *
 * 回想一下：
 *
 * 叶节点 是二叉树中没有子节点的节点
 * 树的根节点的 深度 为 0，如果某一节点的深度为 d，那它的子节点的深度就是 d+1
 * 如果我们假定 A 是一组节点 S 的 最近公共祖先，s 中的每个节点都在以 A 为根节点的子树中，且 A 的深度达到此条件下可能的最大值。
 *
 *
 * 示例 1：
 *
 * 输入：root = [1,2,3]
 * 输出：[1,2,3]
 * 示例 2：
 *
 * 输入：root = [1,2,3,4]
 * 输出：[4]
 * 示例 3：
 *
 * 输入：root = [1,2,3,4,5]
 * 输出：[2,4,5]
 *
 *
 * 提示：
 *
 * 给你的树中将有 1 到 1000 个节点。
 * 树中每个节点的值都在 1 到 1000 之间。
 */
