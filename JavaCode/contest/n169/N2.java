package JavaCode.contest.n169;

import JavaCode.data_structure_binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * author:fangjie
 * time:2019/12/31
 */
public class N2 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1=new ArrayList<>(2500);
        List<Integer> list2=new ArrayList<>(2500);
        dfs(list1,root1);
        dfs(list2,root2);
        return merge(list1,list2);
    }

    private List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> res=new ArrayList<>(list1.size()+list2.size());
        int idx1=0,idx2=0;
        while (idx1<list1.size()&&idx2<list2.size())
        {
            if(list1.get(idx1)<list2.get(idx2)) res.add(list1.get(idx1++));
            else res.add(list2.get(idx2++));
        }
        while (idx1<list1.size())res.add(list1.get(idx1++));
        while (idx2<list2.size())res.add(list2.get(idx2++));
        return res;
    }

    private void dfs(List<Integer> list, TreeNode node) {
        if(node==null)return;
        dfs(list,node.left);
        list.add(node.val);
        dfs(list,node.right);
    }

}
/*
给你 root1 和 root2 这两棵二叉搜索树。

请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.

 

示例 1：



输入：root1 = [2,1,4], root2 = [1,0,3]
输出：[0,1,1,2,3,4]
示例 2：

输入：root1 = [0,-10,10], root2 = [5,1,7,0,2]
输出：[-10,0,0,1,2,5,7,10]
示例 3：

输入：root1 = [], root2 = [5,1,7,0,2]
输出：[0,1,2,5,7]
示例 4：

输入：root1 = [0,-10,10], root2 = []
输出：[-10,0,10]
示例 5：



输入：root1 = [1,null,8], root2 = [8,1]
输出：[1,1,8,8]
 

提示：

每棵树最多有 5000 个节点。
每个节点的值在 [-10^5, 10^5] 之间。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
