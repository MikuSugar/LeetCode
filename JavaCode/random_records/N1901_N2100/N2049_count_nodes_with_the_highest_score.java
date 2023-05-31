package JavaCode.random_records.N1901_N2100;

import utils.Parse;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mikusugar
 */
public class N2049_count_nodes_with_the_highest_score {


    public static void main(String[] args) {
        System.out.println(new N2049_count_nodes_with_the_highest_score().countHighestScoreNodes(
                Parse.toIntArr("[-1,3,3,5,7,6,0,0]")
        ));
    }

    public int countHighestScoreNodes(int[] parents) {

        //init
        Map<Integer, Node> map = new HashMap<>(parents.length * 2 + 5);
        for (int i = 0; i < parents.length; i++) {
            if (!map.containsKey(i)) map.put(i, new Node(i));
            if (parents[i] != -1 && !map.containsKey(parents[i])) map.put(parents[i], new Node(parents[i]));
            if (parents[i] != -1) {
                final Node p = map.get(parents[i]);
                if (p.left == null) p.left = map.get(i);
                else p.right = map.get(i);
            }
        }

        //pretreatment
        int[] book = new int[parents.length];
        dfs(map.get(0), book);

        //cal result
        Map<Long, Integer> res = new HashMap<>();
        long max = 0;
        for (int i = 0; i < book.length; i++) {
            long t = 1;
            int s = book.length - 1;
            final Node p = map.get(i);
            if (p.left != null) {
                t *= book[p.left.val];
                s -= book[p.left.val];
            }
            if (p.right != null) {
                t *= book[p.right.val];
                s -= book[p.right.val];
            }
            t *= Math.max(1, s);
            max = Math.max(max, t);
            if (t == max) {
                res.put(t, res.getOrDefault(t, 0) + 1);
            }
        }
        return res.get(max);
    }

    private int dfs(Node node, int[] book) {
        if (node == null) return 0;
        int res = 1;
        res += dfs(node.left, book);
        res += dfs(node.right, book);
        return book[node.val] = res;
    }

    private static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

}
/*
给你一棵根节点为 0 的 二叉树 ，它总共有 n 个节点，节点编号为 0 到 n - 1 。同时给你一个下标从 0 开始的整数数组 parents 表示这棵树，其中 parents[i] 是节点 i 的父节点。由于节点 0 是根，所以 parents[0] == -1 。

一个子树的 大小 为这个子树内节点的数目。每个节点都有一个与之关联的 分数 。求出某个节点分数的方法是，将这个节点和与它相连的边全部 删除 ，剩余部分是若干个 非空 子树，这个节点的 分数 为所有这些子树 大小的乘积 。

请你返回有 最高得分 节点的 数目 。

 

示例 1:



输入：parents = [-1,2,0,2,0]
输出：3
解释：
- 节点 0 的分数为：3 * 1 = 3
- 节点 1 的分数为：4 = 4
- 节点 2 的分数为：1 * 1 * 2 = 2
- 节点 3 的分数为：4 = 4
- 节点 4 的分数为：4 = 4
最高得分为 4 ，有三个节点得分为 4 （分别是节点 1，3 和 4 ）。
示例 2：



输入：parents = [-1,2,0]
输出：2
解释：
- 节点 0 的分数为：2 = 2
- 节点 1 的分数为：2 = 2
- 节点 2 的分数为：1 * 1 = 1
最高分数为 2 ，有两个节点分数为 2 （分别为节点 0 和 1 ）。
 

提示：

n == parents.length
2 <= n <= 105
parents[0] == -1
对于 i != 0 ，有 0 <= parents[i] <= n - 1
parents 表示一棵二叉树。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-nodes-with-the-highest-score
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
