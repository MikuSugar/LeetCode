package JavaCode.n_ary_tree.traversal;

import JavaCode.n_ary_tree.Node;

import java.util.ArrayList;
import java.util.List;

public class NAryTreePreorderTraversal {

    private List<Integer> list;
    public List<Integer> preorder(Node root) {
        list=new ArrayList<>();
        dfs(root);
        return list;
    }

    private void dfs(Node root)
    {
        if(root==null) return;
        list.add(root.val);
        for (Node node:root.children)
        {
            dfs(node);
        }
    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/n-ary-tree/159/traversal/620/
 * N-ary Tree Preorder Traversal
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *     1
 *   / | \
 *  /  |  \
 *  3  2   4
 * / \
 * 5  6
 * 返回其前序遍历: [1,3,5,6,2,4]。
 *
 *
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 */
