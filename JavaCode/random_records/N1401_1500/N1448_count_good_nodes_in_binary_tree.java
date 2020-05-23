package JavaCode.random_records.N1401_1500;

import JavaCode.data_structure_binary_tree.TreeNode;

/**
 * @Author:fangjie
 * @Date:2020/5/23 5:03 下午
 */
public class N1448_count_good_nodes_in_binary_tree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    public int goodNodes(TreeNode root) {
       return slove(root,root.val);
    }

    private int slove(TreeNode root, int max) {
        if(root==null)return 0;
        int res=0;
        if(max<=root.val)
        {
            res++;
            max=root.val;
        }
        res+=slove(root.left,max);
        res+=slove(root.right,max);
        return res;
    }
}
/*
给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。

「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。

 

示例 1：



输入：root = [3,1,4,3,null,1,5]
输出：4
解释：图中蓝色节点为好节点。
根节点 (3) 永远是个好节点。
节点 4 -> (3,4) 是路径中的最大值。
节点 5 -> (3,4,5) 是路径中的最大值。
节点 3 -> (3,1,3) 是路径中的最大值。
示例 2：



输入：root = [3,3,null,4,2]
输出：3
解释：节点 2 -> (3, 3, 2) 不是好节点，因为 "3" 比它大。
示例 3：

输入：root = [1]
输出：1
解释：根节点是好节点。
 

提示：

二叉树中节点数目范围是 [1, 10^5] 。
每个节点权值的范围是 [-10^4, 10^4] 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-good-nodes-in-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
