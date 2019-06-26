package JavaCode.recursion_i.conclusion;

import JavaCode.data_structure_binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        if(n==0)return new ArrayList<>();
        return dfs(1,n);
    }

    private List<TreeNode> dfs(int start, int end) {
        List<TreeNode> res=new ArrayList<>();
        if(start>end)
        {
            res.add(null);
            return res;
        }
        for (int i=start;i<=end;i++)
        {
            List<TreeNode> left=dfs(start,i-1);
            List<TreeNode> right=dfs(i+1,end);
            for (TreeNode l:left)
            {
                for (TreeNode r:right)
                {
                    TreeNode root=new TreeNode(i);
                    root.left=l;
                    root.right=r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
/**
 * 不同的二叉搜索树 II
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
