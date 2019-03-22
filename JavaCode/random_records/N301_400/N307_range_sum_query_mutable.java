package JavaCode.random_records.N301_400;

public class N307_range_sum_query_mutable {


    public static void main(String[] args) {
        int[] t={1,3,5};
        NumArray numArray = new NumArray(t);
        System.out.println(numArray.sumRange(0,2));
        numArray.update(1,2);
        System.out.println(numArray.sumRange(0,2));
    }

    //线段树
    static class NumArray {


        //获取左子树的节点序号
        private int getLindex(int x){ return x<<1;}
        //获取右子树的节点序号
        private int getRindex(int x){ return x<<1|1;}

        private Node[] nodes;
        int[] nums;

        public NumArray(int[] nums) {
            if(nums==null||nums.length==0)return;
            this.nodes=new Node[4*nums.length+1];
            this.nums=nums;
            build(1,0,nums.length-1);
        }

        private void build(int node, int left, int right)
        {
            if(left==right)
            {
                nodes[node]=new Node(left,right,nums[left]);
                return;
            }
            build(getLindex(node),left,(left+right)>>1);
            build(getRindex(node),((left+right>>1)+1),right);
            nodes[node]=new Node(left,right,nodes[getLindex(node)].sum+nodes[getRindex(node)].sum);
        }

        public void update(int i, int val) {
            int dif=nums[i]-val;
            nums[i]=val;
            update(1,i,dif);
        }

        private void update(int node, int index ,int dif)
        {
            if(index<nodes[node].left||index>nodes[node].right)return;
            nodes[node].sum-=dif;
            if(index==nodes[node].left&&index==nodes[node].right) return;

            int mid=(nodes[node].left+nodes[node].right)>>1;
            if(index<=mid)
            {
                update(getLindex(node),index,dif);
            }
            else
            {
                update(getRindex(node),index,dif);
            }

        }

        public int sumRange(int i, int j) {
            return getSum(1,i,j);
        }

        private int getSum(int node, int left, int right) {
            if(nodes[node].left==left&&nodes[node].right==right)
            {
                return nodes[node].sum;
            }
            int mid=(nodes[node].left+nodes[node].right)>>1;
            if(left>mid) return getSum(getRindex(node),left,right);
            else if(right<=mid) return getSum(getLindex(node),left,right);
            else
            {
                return getSum(getLindex(node),left,mid)+getSum(getRindex(node),mid+1,right);
            }
        }

        class Node
        {
            int left;
            int right;
            int sum;

            public Node(int left, int right, int sum) {
                this.left = left;
                this.right = right;
                this.sum = sum;
            }
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
}
/**
 * https://leetcode-cn.com/problems/range-sum-query-mutable/
 *  给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。
 *
 * 示例:
 *
 * Given nums = [1, 3, 5]
 *
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * 说明:
 *
 * 数组仅可以在 update 函数下进行修改。
 * 你可以假设 update 函数与 sumRange 函数的调用次数是均匀分布的。
 */
