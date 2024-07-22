package JavaCode.random_records.N2201_N2400;

import JavaCode.data_structure_binary_tree.TreeNode;

import java.util.*;


/**
 * @author mikusugar
 * @version 1.0, 2024/4/30 下午5:01
 * @description N2385_amount_of_time_for_binary_tree_to_be_infected
 */
public class N2385_amount_of_time_for_binary_tree_to_be_infected {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    private int time;

    private BitSet book;

    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        convert2Graph(root, graph);
        this.time = 0;
        book = new BitSet();
        dfs(graph, start, 0);
        return time;
    }

    private void dfs(Map<Integer, List<Integer>> graph, int cur, int level) {
        if (this.book.get(cur)) {
            return;
        }
        this.book.set(cur);
        this.time = Math.max(this.time, level);
        final List<Integer> next = graph.getOrDefault(cur, Collections.emptyList());
        next.forEach(n -> dfs(graph, n, level + 1));
    }

    private void convert2Graph(TreeNode node, Map<Integer, List<Integer>> graph) {
        if (node == null) return;
        final List<Integer> next = graph.computeIfAbsent(node.val, k -> new ArrayList<>(3));
        if (node.left != null) {
            next.add(node.left.val);
            graph.computeIfAbsent(node.left.val, k -> new ArrayList<>(3)).add(node.val);
            convert2Graph(node.left, graph);
        }
        if (node.right != null) {
            next.add(node.right.val);
            graph.computeIfAbsent(node.right.val, k -> new ArrayList<>(3)).add(node.val);
            convert2Graph(node.right, graph);
        }
    }


}
/*
给你一棵二叉树的根节点 root ，二叉树中节点的值 互不相同 。另给你一个整数 start 。在第 0 分钟，感染 将会从值为 start 的节点开始爆发。

每分钟，如果节点满足以下全部条件，就会被感染：

节点此前还没有感染。
节点与一个已感染节点相邻。
返回感染整棵树需要的分钟数。



示例 1：


输入：root = [1,5,3,null,4,10,6,9,2], start = 3
输出：4
解释：节点按以下过程被感染：
- 第 0 分钟：节点 3
- 第 1 分钟：节点 1、10、6
- 第 2 分钟：节点5
- 第 3 分钟：节点 4
- 第 4 分钟：节点 9 和 2
感染整棵树需要 4 分钟，所以返回 4 。
示例 2：


输入：root = [1], start = 1
输出：0
解释：第 0 分钟，树中唯一一个节点处于感染状态，返回 0 。


提示：

树中节点的数目在范围 [1, 105] 内
1 <= Node.val <= 105
每个节点的值 互不相同
树中必定存在值为 start 的节点
https://leetcode.cn/problems/amount-of-time-for-binary-tree-to-be-infected
 */
