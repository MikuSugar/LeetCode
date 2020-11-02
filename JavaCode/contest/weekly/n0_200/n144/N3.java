package JavaCode.contest.weekly.n0_200.n144;

import JavaCode.data_structure_binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N3 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root==null)return null;
        Set<TreeNode> res=new HashSet<>();
        Set<Integer> set=new HashSet<>();
        for (int i:to_delete)
        {
            set.add(i);
        }
        dfs(root,null,root,res,set);
        List<TreeNode> ans=new ArrayList<>(res.size());
        ans.addAll(res);
        return ans;
    }

    private void dfs(TreeNode root, TreeNode father,TreeNode node, Set<TreeNode> res,Set<Integer> set) {
        if(node==null)
        {
            if(root!=null&&!set.contains(root.val))res.add(root);
            return;
        }
        if(set.contains(node.val))
        {
            dfs(node.left,null,node.left,res,set);
            dfs(node.right,null,node.right,res,set);
            if(father!=null)
            {
                if(father.right!=null&&father.right.val==node.val)
                {
                    father.right=null;
                }
                else father.left=null;
            }
            if(root!=null&&root.val!=node.val)res.add(root);
        }
        else
        {
            dfs(root,node,node.left,res,set);
            dfs(root,node,node.right,res,set);
        }
    }
}
/**
 *给出二叉树的根节点 root，树上每个节点都有一个不同的值。
 *
 * 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
 *
 * 返回森林中的每棵树。你可以按任意顺序组织答案。
 *
 *
 *
 * 示例：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * 输出：[[1,2,null,4],[6],[7]]
 * 提示：
 *
 * 树中的节点数最大为 1000。
 * 每个节点都有一个介于 1 到 1000 之间的值，且各不相同。
 * to_delete.length <= 1000
 * to_delete 包含一些从 1 到 1000、各不相同的值。
 */
