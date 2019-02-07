package JavaCode.n_ary_tree.traversal;

import JavaCode.n_ary_tree.Node;

import java.util.ArrayList;
import java.util.List;

public class NAryTreePostorderTraversal {
    private List<Integer> list;
    public List<Integer> postorder(Node root) {
        list=new ArrayList<>();
        dfs(root);
        return list;
    }

    private void dfs(Node root)
    {
        if(root==null) return;
        for(Node node:root.children)
        {
            dfs(node);
        }
        list.add(root.val);
    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/n-ary-tree/159/traversal/621/
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 */
