package JavaCode.introduction_to_data_structure_binary_search_tree.conclusion;

public class KthLargest {

    /**
     * 数据封装类 二叉数
     */
    class Node
    {
        int val;
        int count;
        Node left;
        Node right;
        public Node(int val,int count)
        {
            this.val=val;
            this.count=count;
        }
    }

    Node insertNode(Node root,int val)
    {
        if(root==null) return new Node(val,1);

        if(root.val<=val)
        {
            root.right=insertNode(root.right,val);
        }
        else
        {
            root.left=insertNode(root.left,val);
        }
        root.count++;
        return root;
    }

    int findKth(Node root,int k)
    {
        int count=root.right==null?0:root.right.count;
        if(k==count+1)
        {
            temp_k=root.val;
            istemp_k=true;
            return root.val;
        }
        if(k>count)
        {
            return findKth(root.left,k-count-1);
        }
        else
        {
            return findKth(root.right,k);
        }
    }

    private Node root;
    private int k;
    private int temp_k;
    private boolean istemp_k;

    public KthLargest(int k, int[] nums) {
        temp_k=0;
        istemp_k=false;
        root=null;
        this.k=k;
        for (int i:nums)
        {
            root=insertNode(root,i);
        }

    }

    public int add(int val) {
        if(istemp_k&&val>temp_k) istemp_k=false;
        root=insertNode(root,val);

        if(istemp_k)return temp_k;
        return findKth(root,k);
    }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 *
 * https://leetcode-cn.com/explore/learn/card/introduction-to-data-structure-binary-search-tree/66/conclusion/183/
 * Kth Largest Element in a Stream
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 *
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 *
 * 示例:
 *
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * 说明:
 * 你可以假设 nums 的长度≥ k-1 且k ≥ 1。
 */
