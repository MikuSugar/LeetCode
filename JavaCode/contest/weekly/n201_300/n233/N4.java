package JavaCode.contest.weekly.n201_300.n233;

/**
 * author: fangjie
 * email: syfangjie@live.cn
 * date: 2021/3/21 10:21 上午
 */
public class N4 {
    public int countPairs(int[] nums, int low, int high) {
        //TODO
        return 0;
    }

    static class Trie{

        Node root;

        Trie(){
            this.root=new Node();
        }

        void insert(int num){
            Node cur=this.root;
            boolean flag=false;
            for (int i=30;i>=0;i--)
            {
                int pos=num>>i&1;
                if(cur.next[pos]!=null){
                    cur.next[pos]=new Node();
                }
                if(!flag&&pos==1){
                    flag=true;
                    cur.next[pos].count++;
                }
                cur=cur.next[pos];
            }
        }

        void query(int num,int high){

        }

    }

    static class Node{
        Node[] next;
        int count;
        Node(){
            this.next=new Node[2];
            this.count=0;
        }
    }

}
/*
给你一个整数数组 nums （下标 从 0 开始 计数）以及两个整数：low 和 high ，请返回 漂亮数对 的数目。

漂亮数对 是一个形如 (i, j) 的数对，其中 0 <= i < j < nums.length 且 low <= (nums[i] XOR nums[j]) <= high 。



示例 1：

输入：nums = [1,4,2,7], low = 2, high = 6
输出：6
解释：所有漂亮数对 (i, j) 列出如下：
    - (0, 1): nums[0] XOR nums[1] = 5
    - (0, 2): nums[0] XOR nums[2] = 3
    - (0, 3): nums[0] XOR nums[3] = 6
    - (1, 2): nums[1] XOR nums[2] = 6
    - (1, 3): nums[1] XOR nums[3] = 3
    - (2, 3): nums[2] XOR nums[3] = 5
示例 2：

输入：nums = [9,8,4,2,1], low = 5, high = 14
输出：8
解释：所有漂亮数对 (i, j) 列出如下：
​​​​​    - (0, 2): nums[0] XOR nums[2] = 13
    - (0, 3): nums[0] XOR nums[3] = 11
    - (0, 4): nums[0] XOR nums[4] = 8
    - (1, 2): nums[1] XOR nums[2] = 12
    - (1, 3): nums[1] XOR nums[3] = 10
    - (1, 4): nums[1] XOR nums[4] = 9
    - (2, 3): nums[2] XOR nums[3] = 6
    - (2, 4): nums[2] XOR nums[4] = 5


提示：

1 <= nums.length <= 2 * 104
1 <= nums[i] <= 2 * 104
1 <= low <= high <= 2 * 104
 */
