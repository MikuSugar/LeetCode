package JavaCode.random_records.N601_700;

import JavaCode.data_structure_binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class N655_print_binary_tree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public List<List<String>> printTree(TreeNode root) {
        int level=getLevel(root);
        int cul=(int) Math.pow(2,level)-1;
        List<List<String>> res=new ArrayList<>(level);
        for (int i=0;i<level;i++)
        {
            List<String> list=new ArrayList<>(cul);
            res.add(list);
            for (int j=0;j<cul;j++)
            {
                list.add("");
            }
        }
        dfs(root,0,cul-1,0,res);
        return res;
    }

    private void dfs(TreeNode root, int left, int right, int level,List<List<String>> res) {
        if(root==null)return;
        int mid=(left+right)/2;
        res.get(level).set(mid,Integer.toString(root.val));
        dfs(root.left,left,mid-1,level+1,res);
        dfs(root.right,mid+1,right,level+1,res);
    }

    private  int getLevel(TreeNode root) {
        if(root==null)return 0;
        return Math.max(getLevel(root.left),getLevel(root.right))+1;
    }
}
/**
 *
 * 在一个 m*n 的二维字符串数组中输出二叉树，并遵守以下规则：
 *
 * 行数 m 应当等于给定二叉树的高度。
 * 列数 n 应当总是奇数。
 * 根节点的值（以字符串格式给出）应当放在可放置的第一行正中间。根节点所在的行与列会将剩余空间划分为两部分（左下部分和右下部分）。你应该将左子树输出在左下部分，右子树输出在右下部分。左下和右下部分应当有相同的大小。即使一个子树为空而另一个非空，你不需要为空的子树输出任何东西，但仍需要为另一个子树留出足够的空间。然而，如果两个子树都为空则不需要为它们留出任何空间。
 * 每个未使用的空间应包含一个空的字符串""。
 * 使用相同的规则输出子树。
 * 示例 1:
 *
 * 输入:
 *      1
 *     /
 *    2
 * 输出:
 * [["", "1", ""],
 *  ["2", "", ""]]
 * 示例 2:
 *
 * 输入:
 *      1
 *     / \
 *    2   3
 *     \
 *      4
 * 输出:
 * [["", "", "", "1", "", "", ""],
 *  ["", "2", "", "", "", "3", ""],
 *  ["", "", "4", "", "", "", ""]]
 * 示例 3:
 *
 * 输入:
 *       1
 *      / \
 *     2   5
 *    /
 *   3
 *  /
 * 4
 * 输出:
 * [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 *  ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 *  ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 *  ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
 * 注意: 二叉树的高度在范围 [1, 10] 中。
 */
