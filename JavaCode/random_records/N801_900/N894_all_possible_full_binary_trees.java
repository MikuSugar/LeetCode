package JavaCode.random_records.N801_900;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N894_all_possible_full_binary_trees {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    private Map<Integer,List<TreeNode>> map=new HashMap<>();
    public List<TreeNode> allPossibleFBT(int N) {
        if(map.containsKey(N))return map.get(N);
        List<TreeNode> res=new ArrayList<>();
        if(N==1)
        {
            res.add(new TreeNode(0));
        }
        else if(N%2==1)
        {
            for (int left_cnt=0;left_cnt<N;left_cnt++)
            {
                int right_cnt=N-left_cnt-1;
                for (TreeNode left:allPossibleFBT(left_cnt))
                {
                    for (TreeNode right:allPossibleFBT(right_cnt))
                    {
                        TreeNode node=new TreeNode(0);
                        node.left=left;
                        node.right=right;
                        res.add(node);
                    }
                }
            }
        }
        map.put(N,res);
        return res;
    }


}
/**
 * 满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
 *
 * 返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。
 *
 * 答案中每个树的每个结点都必须有 node.val=0。
 *
 * 你可以按任何顺序返回树的最终列表。
 *
 *
 *
 * 示例：
 *
 * 输入：7
 * 输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 * 解释：
 *
 *
 *
 * 提示：
 *
 * 1 <= N <= 20
 */
