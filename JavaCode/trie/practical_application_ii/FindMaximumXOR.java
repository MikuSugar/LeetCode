package JavaCode.trie.practical_application_ii;

public class FindMaximumXOR {

    public static void main(String[] args) {
        int[] t={3,10,5,25,2,8};
        System.out.println(new FindMaximumXOR().findMaximumXOR(t));
    }

    public int findMaximumXOR(int[] nums) {
        Node root=new Node();
        for(int i:nums)
        {
            add(root,i);
        }
        int max=0;
        for(int i:nums)
        {
            max=Math.max(max,findMax(root,i));
        }
        return max;
    }

    class Node{
        Node[] child;
        public Node()
        {
            child=new Node[2];
        }
    }

    void add(Node root,int x)
    {
        for(int i=31;i>=0;i--)
        {
            int bit=(x>>i)&1;
            if(root.child[bit]==null)
            {
                root.child[bit]=new Node();
            }
            root=root.child[bit];
        }
    }

    int findMax(Node root,int x)
    {
        int res=0;
        x=~x;
        for(int i=31;i>=0;i--)
        {

            int bit=(x>>i)&1;
            res=res<<1;
            if(root.child[bit]!=null)
            {
                res++;
                root=root.child[bit];
            }
            else
            {
                root=root.child[bit==1?0:1];
            }

        }
        return res;
    }


}
/**
 * https://leetcode-cn.com/explore/learn/card/trie/168/practical-application-ii/651/
 * 数组中两个数的最大异或值
 * 给定一个非空数组，数组中元素为 a0, a1, a2, … , an-1，其中 0 ≤ ai < 231 。
 *
 * 找到 ai 和aj 最大的异或 (XOR) 运算结果，其中0 ≤ i,  j < n 。
 *
 * 你能在O(n)的时间解决这个问题吗？
 *
 * 示例:
 *
 * 输入: [3, 10, 5, 25, 2, 8]
 *
 * 输出: 28
 *
 * 解释: 最大的结果是 5 ^ 25 = 28.
 */
