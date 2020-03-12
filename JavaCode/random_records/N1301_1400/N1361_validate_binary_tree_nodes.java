package JavaCode.random_records.N1301_1400;

import java.util.Arrays;

/**
 * author:fangjie
 * time:2020/3/12
 */
public class N1361_validate_binary_tree_nodes {
    public static void main(String[] args) {

        //4
        //[1,2,0,-1]
        //[-1,-1,-1,-1]
        System.out.println(new N1361_validate_binary_tree_nodes()
        .validateBinaryTreeNodes(4,new int[]{1,2,0,-1},new int[]{-1,-1,-1,-1}));
    }
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        boolean[] book=new boolean[n];
        Node[] nodes=new Node[n];
        for (int i=0;i<n;i++)
        {
            nodes[i]=new Node(i);
        }

        for (int i=0;i<n;i++)
        {
            if(leftChild[i]!=-1)
            {
                nodes[i].left=nodes[leftChild[i]];
                book[leftChild[i]]=true;
            }
            if(rightChild[i]!=-1)
            {
                nodes[i].right=nodes[rightChild[i]];
                book[rightChild[i]]=true;
            }
        }
        Node root=null;
        for (int i=0;i<n;i++)
        {
            if(!book[i])
            {
                if(root==null)root=nodes[i];
                else return false;
            }
        }
        if (root==null)return false;
        Arrays.fill(book,false);
        if(!check(root,book))return false;
        for (boolean isOk:book)
        {
            if(!isOk)return false;
        }
        return true;
    }

    private boolean check(Node root, boolean[] book) {
        if(root==null)return true;
        if(book[root.idx])return false;
        book[root.idx]=true;
        return check(root.left,book)&&check(root.right,book);
    }

    private class Node{
        Node left;
        Node right;
        int idx;

        public Node(int idx)
        {
            this.idx=idx;
        }
        @Override
        public boolean equals(Object o) {
            if (this==o) return true;
            if (o==null||getClass()!=o.getClass()) return false;
            Node node=(Node) o;
            return idx==node.idx;
        }

        @Override
        public int hashCode() {
            return idx;
        }
    }
}
/*
二叉树上有 n 个节点，按从 0 到 n - 1 编号，其中节点 i 的两个子节点分别是 leftChild[i] 和 rightChild[i]。

只有 所有 节点能够形成且 只 形成 一颗 有效的二叉树时，返回 true；否则返回 false。

如果节点 i 没有左子节点，那么 leftChild[i] 就等于 -1。右子节点也符合该规则。

注意：节点没有值，本问题中仅仅使用节点编号。

 

示例 1：



输入：n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
输出：true
示例 2：



输入：n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1]
输出：false
示例 3：



输入：n = 2, leftChild = [1,0], rightChild = [-1,-1]
输出：false
示例 4：



输入：n = 6, leftChild = [1,-1,-1,4,-1,-1], rightChild = [2,-1,-1,5,-1,-1]
输出：false
 

提示：

1 <= n <= 10^4
leftChild.length == rightChild.length == n
-1 <= leftChild[i], rightChild[i] <= n - 1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/validate-binary-tree-nodes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
