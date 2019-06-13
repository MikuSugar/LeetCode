package JavaCode.random_records.N601_700;

import JavaCode.data_structure_binary_tree.TreeNode;

public class N654_maximum_binary_tree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(0,nums.length-1,nums);
    }

    private TreeNode dfs(int left, int right, int[] nums) {
        if(right<left)return null;
        int max=Integer.MIN_VALUE;
        int idx=-1;
        for (int i=left;i<=right;i++)
        {
            if(nums[i]>max)
            {
                max=nums[i];
                idx=i;
            }
        }
        TreeNode node=new TreeNode(max);
        node.left=dfs(left,idx-1,nums);
        node.right=dfs(idx+1,right,nums);
        return node;
    }
}
/**
 *给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 *
 * Example 1:
 *
 * 输入: [3,2,1,6,0,5]
 * 输入: 返回下面这棵树的根节点：
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 * 注意:
 *
 * 给定的数组的大小在 [1, 1000] 之间。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
