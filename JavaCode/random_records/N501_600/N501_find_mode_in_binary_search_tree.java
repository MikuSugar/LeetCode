package JavaCode.random_records.N501_600;

import JavaCode.data_structure_binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class N501_find_mode_in_binary_search_tree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    private TreeNode pre;
    private int max;
    private int count;
    public int[] findMode(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        max=0;
        count=1;
        dfs(root,list);
        int[] res=new int[list.size()];
        for (int i=0;i<res.length;i++)
        {
            res[i]=list.get(i);
        }
        return res;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if(root==null)return;
        dfs(root.left,list);
        if(pre!=null)
        {
            if(pre.val==root.val)
            {
                count++;
            }
            else count=1;
        }
        if (count>max)
        {
            max=count;
            list.clear();
            list.add(root.val);
        }
        else if(count==max)
        {
            list.add(root.val);
        }
        pre=root;
        dfs(root.right,list);
    }
}
/**
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 */
