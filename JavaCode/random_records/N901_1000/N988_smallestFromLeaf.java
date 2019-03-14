package JavaCode.random_records.N901_1000;

import JavaCode.data_structure_binary_tree.TreeNode;


public class N988_smallestFromLeaf {

    public String smallestFromLeaf(TreeNode root) {
        if(root==null) return "";
        return dfs(root,"");
    }

    private String dfs(TreeNode root,String s)
    {
        if(root==null) return (char)('a'+30)+s;
        s=(char)('a'+root.val)+s;
        if(root.left==null&&root.right==null) return s;
        String left=dfs(root.left,s);
        String right=dfs(root.right,s);
        return left.compareTo(right)<=0?left:right;
    }
}
/**
 * https://leetcode-cn.com/problems/smallest-string-starting-from-leaf/
 * 给定一颗根结点为 root 的二叉树，书中的每个结点都有一个从 0 到 25 的值，分别代表字母 'a' 到 'z'：值 0 代表 'a'，值 1 代表 'b'，依此类推。
 *
 * 找出按字典序最小的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。
 *
 * （小贴士：字符串中任何较短的前缀在字典序上都是较小的：例如，在字典序上 "ab" 比 "aba" 要小。叶结点是指没有子结点的结点。）
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：[0,1,2,3,4,3,4]
 * 输出："dba"
 * 示例 2：
 *
 *
 *
 * 输入：[25,1,3,1,3,0,2]
 * 输出："adz"
 * 示例 3：
 *
 *
 *
 * 输入：[2,2,1,null,1,0,null,0]
 * 输出："abc"
 *
 *
 * 提示：
 *
 * 给定树的结点数介于 1 和 8500 之间。
 * 树中的每个结点都有一个介于 0 和 25 之间的值。
 */
