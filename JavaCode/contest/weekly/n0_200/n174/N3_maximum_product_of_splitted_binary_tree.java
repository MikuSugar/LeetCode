package JavaCode.contest.weekly.n0_200.n174;

import JavaCode.data_structure_binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * author:fangjie
 * time:2020/2/2
 */
public class N3_maximum_product_of_splitted_binary_tree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    public int maxProduct(TreeNode root) {
        final int MOD=(int) (1e9+7);
        List<Long> list=new ArrayList<>(25000);
        long sum=getSum(root,list);
        long res=-1;
        for (long s1:list)
        {
            res=Math.max(res,s1*(sum-s1));
        }
        return (int) (res%MOD);
    }

    private long getSum(TreeNode root, List<Long> list) {
        if(root==null)return 0L;
        long sum=root.val+getSum(root.left,list)+getSum(root.right,list);
        list.add(sum);
        return sum;
    }
}
/*
给你一棵二叉树，它的根为 root 。请你删除 1 条边，使二叉树分裂成两棵子树，且它们子树和的乘积尽可能大。

由于答案可能会很大，请你将结果对 10^9 + 7 取模后再返回。

 

示例 1：



输入：root = [1,2,3,4,5,6]
输出：110
解释：删除红色的边，得到 2 棵子树，和分别为 11 和 10 。它们的乘积是 110 （11*10）
示例 2：



输入：root = [1,null,2,3,4,null,null,5,6]
输出：90
解释：移除红色的边，得到 2 棵子树，和分别是 15 和 6 。它们的乘积为 90 （15*6）
示例 3：

输入：root = [2,3,9,10,7,8,6,5,4,11,1]
输出：1025
示例 4：

输入：root = [1,1]
输出：1
 

提示：

每棵树最多有 50000 个节点，且至少有 2 个节点。
每个节点的值在 [1, 10000] 之间。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-product-of-splitted-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
