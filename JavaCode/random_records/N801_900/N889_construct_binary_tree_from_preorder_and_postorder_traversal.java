package JavaCode.random_records.N801_900;

/*
 * @Author: fangjie
 * @Date: 2020/7/1 9:53 下午
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class N889_construct_binary_tree_from_preorder_and_postorder_traversal {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return slove(0,0,pre.length,pre,post);
    }

    private TreeNode slove(int l, int r, int n, int[] pre, int[] post) {
        if (n==0) return null;
        TreeNode node = new TreeNode(pre[l]);
        if (n==1) return node;

        int idx=1;
        for (;idx<n;idx++)
        {
            if (post[r+idx-1]==pre[l+1])break;
        }

        node.left = slove(l+1,r,idx,pre,post);
        node.right = slove(l+idx+1,r+idx,n-1-idx,pre,post);
        return node;
    }
}
