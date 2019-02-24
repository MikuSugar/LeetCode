package JavaCode.hash_table.practical_application_design_the_key;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Definition for a binary tree node.
 */
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> list=new ArrayList<>();
        Map<String, Integer> map=new HashMap<>();
        dfs(root,list,map);
        return list;
    }

    String dfs(TreeNode node, List<TreeNode> list, Map<String,Integer> map)
    {
        if(node==null) return "#";
        String s=node.val+dfs(node.left,list,map)+","+dfs(node.right,list,map);

        if(map.containsKey(s))
        {
            if(map.get(s)==0)
            {
                list.add(node);
            }
            map.put(s,map.get(s)+1);
        }
        else
        {
            map.put(s,0);
        }
        return s;

    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/hash-table/206/practical-application-design-the-key/823/
 * 寻找重复的子树
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 *
 * 示例 1：
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * 下面是两个重复的子树：
 *
 *       2
 *      /
 *     4
 * 和
 *
 *     4
 * 因此，你需要以列表的形式返回上述重复子树的根结点。
 */
