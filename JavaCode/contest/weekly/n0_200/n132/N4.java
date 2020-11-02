package JavaCode.contest.weekly.n0_200.n132;

import JavaCode.data_structure_binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class N4 {

    public static void main(String[] args) {
        new N4().recoverFromPreorder("1-2--3--4-5--6--7");
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    private int cur;
    public TreeNode recoverFromPreorder(String S) {
        this.cur=0;
        List<int[]> list=new ArrayList<>();
        while (cur<S.length())
        {
            list.add(hlep(S));
        }
        return dfs(0,list);
    }

    private TreeNode dfs( int target, List<int[]> list) {
        for (int i=0;i<list.size();i++)
        {
            int[] a=list.get(i);
            if(a[0]==target)
            {
                int val=a[1];
                list.remove(i);
                TreeNode root=new TreeNode(val);
                root.left=dfs(target+1,list);
                root.right=dfs(target+1,list);
                return root;
            }
            else if(a[0]<target)
            {
                return null;
            }
        }
        return null;
    }


    private int[] hlep(String s) {
        int cnt=0;
        while (s.charAt(cur)=='-')
        {
            cur++;
            cnt++;
        }
        int start=cur;
        while (Character.isDigit(s.charAt(cur)))
        {
            cur++;
            if(cur==s.length())break;
        }
        int val=Integer.parseInt(s.substring(start,cur));
        return new int[]{cnt,val};
    }
}
/**
 * 5031. 从先序遍历还原二叉树  显示英文描述
 * 用户通过次数 3
 * 用户尝试次数 3
 * 通过次数 3
 * 提交次数 4
 * 题目难度 Hard
 * 我们从二叉树的根节点 root 开始进行深度优先搜索。
 *
 * 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
 *
 * 如果节点只有一个子节点，那么保证该子节点为左子节点。
 *
 * 给出遍历输出 S，还原树并返回其根节点 root。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入："1-2--3--4-5--6--7"
 * 输出：[1,2,5,3,4,6,7]
 * 示例 2：
 *
 *
 *
 * 输入："1-2--3---4-5--6---7"
 * 输出：[1,2,5,3,null,6,null,4,null,7]
 * 示例 3：
 *
 *
 *
 * 输入："1-401--349---90--88"
 * 输出：[1,401,null,349,88,90]
 *
 *
 * 提示：
 *
 * 原始树中的节点数介于 1 和 1000 之间。
 * 每个节点的值介于 1 和 10 ^ 9 之间。
 */
