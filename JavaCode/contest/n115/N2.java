package JavaCode.contest.n115;

import JavaCode.data_structure_binary_tree.TreeNode;

public class N2 {

    private int h;
    private boolean flag;
    public boolean isCompleteTree(TreeNode root) {
        if (root==null) return true;
        this.h=getDepth(root);
        System.out.println(h);
        return dfs(root,1);
    }

    private boolean dfs(TreeNode root,int level) {
        if (root==null)
        {
            if(level==h+1)
            {
                return !flag;
            }
            else if(level==h)
            {
                flag=true;
                return true;
            }
            else return false;
        }
        return dfs(root.left,level+1)&&dfs(root.right,level+1);
    }

    private int getDepth(TreeNode root)
    {
        if(root==null)return 0;
        return Math.max(getDepth(root.left)+1,getDepth(root.right)+1);
    }
}
/**
 * 958. 二叉树的完全性检验  显示英文描述
 * 用户通过次数 119
 * 用户尝试次数 157
 * 通过次数 123
 * 提交次数 378
 * 题目难度 Medium
 * 给定一个二叉树，确定它是否是一个完全二叉树。
 *
 * 百度百科中对完全二叉树的定义如下：
 *
 * 若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：第 h 层可能包含 1~ 2h 个节点。）
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：[1,2,3,4,5,6]
 * 输出：true
 * 解释：最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。
 * 示例 2：
 *
 *
 *
 * 输入：[1,2,3,4,5,null,7]
 * 输出：false
 * 解释：值为 7 的结点没有尽可能靠向左侧。
 *
 *
 * 提示：
 *
 * 树中将会有 1 到 100 个结点。
 */
