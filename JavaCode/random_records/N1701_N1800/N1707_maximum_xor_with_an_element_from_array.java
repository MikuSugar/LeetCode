package JavaCode.random_records.N1701_N1800;

/**
 * author: fangjie
 * email: syfangjie@live.cn
 * date: 2021/3/26 2:03 下午
 */
public class N1707_maximum_xor_with_an_element_from_array {

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Trie trie=new Trie();
        for (int i:nums)trie.insert(i);
        int[] res=new int[queries.length];
        int idx=0;
        for (int[] q:queries){
            res[idx++]=trie.query(q[0],q[1]);
        }
        return res;
    }

    static class Trie {
        Node root;
        Trie() {
            root=new Node();
        }
        void insert(int num) {
            Node cur=root;
            for (int i=30; i>=0; i--) {
                int pos=num >> i&1;
                if (cur.next[pos]==null) {
                    cur.next[pos]=new Node();
                    cur.next[pos].min=num;
                } else cur.next[pos].min=Math.min(cur.next[pos].min, num);
                cur=cur.next[pos];
            }
        }

        int query(int num, int max) {
            Node cur=root;
            int res=0;
            for (int i=30; i>=0; i--) {
                int pos=num >> i&1;
                int rPos=pos^1;
                if (cur.next[rPos]!=null&&max>=cur.next[rPos].min) {
                    res+=1<<i;
                    cur=cur.next[rPos];
                } else if (cur.next[pos]!=null&&max>=cur.next[pos].min) cur=cur.next[pos];
                else return -1;
            }
            return res;
        }
    }

    static class Node {
        Node[] next;
        int min;
        Node() {
            this.min=Integer.MAX_VALUE;
            next=new Node[2];
        }
    }
}
/*
给你一个由非负整数组成的数组 nums 。另有一个查询数组 queries ，其中 queries[i] = [xi, mi] 。

第 i 个查询的答案是 xi 和任何 nums 数组中不超过 mi 的元素按位异或（XOR）得到的最大值。换句话说，答案是 max(nums[j] XOR xi) ，其中所有 j 均满足 nums[j] <= mi 。如果 nums 中的所有元素都大于 mi，最终答案就是 -1 。

返回一个整数数组 answer 作为查询的答案，其中 answer.length == queries.length 且 answer[i] 是第 i 个查询的答案。

 

示例 1：

输入：nums = [0,1,2,3,4], queries = [[3,1],[1,3],[5,6]]
输出：[3,3,7]
解释：
1) 0 和 1 是仅有的两个不超过 1 的整数。0 XOR 3 = 3 而 1 XOR 3 = 2 。二者中的更大值是 3 。
2) 1 XOR 2 = 3.
3) 5 XOR 2 = 7.
示例 2：

输入：nums = [5,2,4,6,6,3], queries = [[12,4],[8,1],[6,3]]
输出：[15,-1,5]
 

提示：

1 <= nums.length, queries.length <= 105
queries[i].length == 2
0 <= nums[j], xi, mi <= 109


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-xor-with-an-element-from-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
