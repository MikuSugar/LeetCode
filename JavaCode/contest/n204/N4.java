package JavaCode.contest.n204;

import utils.Parse;

/**
 * author: fangjie
 * email: syfangjie@live.cn
 * date: 2020/8/30 10:23 上午
 */
public class N4 {
    public static void main(String[] args) {
        System.out.println(new N4().numOfWays(Parse.parseToIntArray("[3,4,5,1,2]")));
    }

    private final static long[][] dp;
    private final static int MOD=(int) (1e9+7);
    static {
        dp=new long[1001][1001];
        dp[0][0]=1L;
        for (int i=1; i<dp.length; i++) {
            dp[i][0]=1L;
            for (int j=1; j<dp.length; j++) {
                dp[i][j]=(dp[i-1][j-1]+dp[i-1][j])%MOD;
            }
        }
    }

    public int numOfWays(int[] nums) {
        if (nums.length==1) return 0;
        Node root=new Node(0);
        for (int i : nums) insert(root, i);
        dfs(root);
        return (root.res-1+MOD)%MOD;
    }

    private void dfs(Node node) {
        if (node==null) return;
        dfs(node.left);
        dfs(node.right);
        int lSize=node.left!=null ? node.left.size : 0;
        int rSize=node.right!=null ? node.right.size : 0;
        int lRes=node.left!=null ? node.left.res : 1;
        int rRes=node.right!=null ? node.right.res : 1;
        node.res=(int) (dp[lSize+rSize][lSize]%MOD*lRes%MOD*rRes%MOD);
    }

    private void insert(Node root, int value) {
        if(root==null)return;
        root.size++;
        if(value<root.value){
            if(root.left==null)root.left=new Node(value);
            else insert(root.left,value);
        }
        else {
            if(root.right==null)root.right=new Node(value);
            else insert(root.right,value);
        }
    }

    static class Node {
        Node left, right;
        int value, size, res;

        public Node(int value) {
            this.value=value;
            this.size=1;
            this.res=0;
        }
    }

}
/*
给你一个数组 nums 表示 1 到 n 的一个排列。我们按照元素在 nums 中的顺序依次插入一个初始为空的二叉查找树（BST）。请你统计将 nums 重新排序后，统计满足如下条件的方案数：重排后得到的二叉查找树与 nums 原本数字顺序得到的二叉查找树相同。

比方说，给你 nums = [2,1,3]，我们得到一棵 2 为根，1 为左孩子，3 为右孩子的树。数组 [2,3,1] 也能得到相同的 BST，但 [3,2,1] 会得到一棵不同的 BST 。

请你返回重排 nums 后，与原数组 nums 得到相同二叉查找树的方案数。

由于答案可能会很大，请将结果对 10^9 + 7 取余数。

 

示例 1：



输入：nums = [2,1,3]
输出：1
解释：我们将 nums 重排， [2,3,1] 能得到相同的 BST 。没有其他得到相同 BST 的方案了。
示例 2：



输入：nums = [3,4,5,1,2]
输出：5
解释：下面 5 个数组会得到相同的 BST：
[3,1,2,4,5]
[3,1,4,2,5]
[3,1,4,5,2]
[3,4,1,2,5]
[3,4,1,5,2]
示例 3：



输入：nums = [1,2,3]
输出：0
解释：没有别的排列顺序能得到相同的 BST 。
示例 4：



输入：nums = [3,1,2,5,4,6]
输出：19
示例  5：

输入：nums = [9,4,2,1,3,6,5,7,8,14,11,10,12,13,16,15,17,18]
输出：216212978
解释：得到相同 BST 的方案数是 3216212999。将它对 10^9 + 7 取余后得到 216212978。
 

提示：

1 <= nums.length <= 1000
1 <= nums[i] <= nums.length
nums 中所有数 互不相同 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-ways-to-reorder-array-to-get-same-bst
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
