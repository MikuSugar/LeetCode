package JavaCode.n_ary_tree.traversal;

import JavaCode.n_ary_tree.Node;

import java.util.ArrayList;
import java.util.List;

public class LevelOrder {

    private List<List<Integer>> result;

    public List<List<Integer>> levelOrder(Node root) {
        result=new ArrayList<>();
        dfs(root,0);
        return result;
    }

    void dfs(Node root,int level)
    {
        if(root==null) return;
        if(level==result.size())
        {
            List<Integer> list=new ArrayList<>();
            list.add(root.val);
            result.add(list);
        }
        else
        {
            result.get(level).add(root.val);
        }

        for (Node node:root.children)
        {
            dfs(node,level+1);
        }
    }

}
/**
 * https://leetcode-cn.com/explore/learn/card/n-ary-tree/159/traversal/622/
 * N叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 */
