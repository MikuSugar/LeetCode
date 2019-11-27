package JavaCode.random_records.N501_600;

import JavaCode.data_structure_binary_tree.TreeNode;

import java.util.*;

/**
 * author:fangjie
 * time:2019/11/27
 */
public class N508_most_frequent_subtree_sum {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer,Integer> map=new HashMap<>();
        getSum(root,map);
        int max=0;
        for (int i:map.values())max=Math.max(max,i);
        List<Integer> res=new LinkedList<>();
        for (Map.Entry<Integer,Integer> e:map.entrySet())
        {
            if(e.getValue()==max)res.add(e.getKey());
        }
        int[] ans=new int[res.size()];
        int idx=0;
        for (int i:res) ans[idx++]=i;
        return ans;
    }

    private int getSum(TreeNode root, Map<Integer, Integer> map) {
        if(root==null)return 0;
        int sum=root.val+getSum(root.left,map)+getSum(root.right,map);
        map.put(sum,map.getOrDefault(sum,0)+1);
        return sum;
    }
}
/*
给出二叉树的根，找出出现次数最多的子树元素和。一个结点的子树元素和定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。然后求出出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的元素（不限顺序）。

 

示例 1
输入:

  5
 /  \
2   -3
返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。

示例 2
输入:

  5
 /  \
2   -5
返回 [2]，只有 2 出现两次，-5 只出现 1 次。

 

提示： 假设任意子树元素和均可以用 32 位有符号整数表示。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/most-frequent-subtree-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
