package JavaCode.n_ary_tree.recursion;

import JavaCode.n_ary_tree.Node;

public class MaximumDepthOfNAryTree {
    public int maxDepth(Node root) {
        if(root==null) return 0;
        int max=0;
        for (Node node:root.children)
        {
            max=Math.max(max,maxDepth(node));
        }
        return max+1;
    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/n-ary-tree/160/recursion/624/
 * Maximum Depth of N-ary Tree
 * 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 */
