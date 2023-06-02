package JavaCode.random_records.N1901_N2100;

import JavaCode.data_structure_binary_tree.TreeNode;

/**
 * @author mikusugar
 * @version 1.0, 2023/6/2 11:01
 * @description N2096_step_by_step_directions_from_a_binary_tree_node_to_another
 * /**
 * * Definition for a binary tree node.
 * * public class TreeNode {
 * *     int val;
 * *     TreeNode left;
 * *     TreeNode right;
 * *     TreeNode() {}
 * *     TreeNode(int val) { this.val = val; }
 * *     TreeNode(int val, TreeNode left, TreeNode right) {
 * *         this.val = val;
 * *         this.left = left;
 * *         this.right = right;
 * *     }
 * * }
 */
public class N2096_step_by_step_directions_from_a_binary_tree_node_to_another {
    private TreeNode minFather;

    public String getDirections(TreeNode root, int startValue, int destValue) {
        this.minFather = null;
        find(root, startValue, destValue);
        final StringBuilder left = new StringBuilder();
        findStartValue(minFather, startValue, left);
        final StringBuilder right = new StringBuilder();
        findDestValue(minFather, destValue, right);
        for (int i = right.length() - 1; i >= 0; i--) {
            left.append(right.charAt(i));
        }
        return left.toString();
    }

    private boolean findDestValue(TreeNode node, int destValue, StringBuilder res) {
        if (node == null) return false;
        if (node.val == destValue) {
            return true;
        }
        if (findDestValue(node.left, destValue, res)) {
            res.append("L");
            return true;
        } else if (findDestValue(node.right, destValue, res)) {
            res.append("R");
            return true;
        }
        return false;
    }

    private boolean findStartValue(TreeNode node, int startValue, StringBuilder res) {
        if (node == null) return false;
        if (node.val == startValue) return true;
        if (findStartValue(node.left, startValue, res)) {
            res.append("U");
            return true;
        } else if (findStartValue(node.right, startValue, res)) {
            res.append("U");
            return true;
        }
        return false;
    }

    private int find(TreeNode node, int startValue, int destValue) {
        if (node == null || minFather != null) return 0;
        int res = 0;
        if (node.val == startValue) {
            res++;
        } else if (node.val == destValue) {
            res++;
        }
        res += (find(node.left, startValue, destValue) + find(node.right, startValue, destValue));
        if (res == 2 && minFather == null) {
            minFather = node;
        }
        return res;
    }
}
/*
给你一棵 二叉树 的根节点 root ，这棵二叉树总共有 n 个节点。每个节点的值为 1 到 n 中的一个整数，且互不相同。给你一个整数 startValue ，表示起点节点 s 的值，和另一个不同的整数 destValue ，表示终点节点 t 的值。

请找到从节点 s 到节点 t 的 最短路径 ，并以字符串的形式返回每一步的方向。每一步用 大写 字母 'L' ，'R' 和 'U' 分别表示一种方向：

'L' 表示从一个节点前往它的 左孩子 节点。
'R' 表示从一个节点前往它的 右孩子 节点。
'U' 表示从一个节点前往它的 父 节点。
请你返回从 s 到 t 最短路径 每一步的方向。

 

示例 1：



输入：root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
输出："UURL"
解释：最短路径为：3 → 1 → 5 → 2 → 6 。
示例 2：



输入：root = [2,1], startValue = 2, destValue = 1
输出："L"
解释：最短路径为：2 → 1 。
 

提示：

树中节点数目为 n 。
2 <= n <= 105
1 <= Node.val <= n
树中所有节点的值 互不相同 。
1 <= startValue, destValue <= n
startValue != destValue

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/step-by-step-directions-from-a-binary-tree-node-to-another
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
