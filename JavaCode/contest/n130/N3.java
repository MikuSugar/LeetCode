package JavaCode.contest.n130;

import JavaCode.linked_list.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class N3 {


    private class Node
    {
        int val;
        int index;
        public Node(int val,int index)
        {
            this.val=val;
            this.index=index;
        }
    }

    public int[] nextLargerNodes(ListNode head) {
        PriorityQueue<Node> queue=new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.val-o2.val;
            }
        });
        List<Integer> res=new ArrayList<>();

        ListNode p=head;
        int cnt=0;
        while (p!=null)
        {
            res.add(0);
            int val=p.val;
            while (!queue.isEmpty())
            {
                Node node=queue.peek();
                if(val>node.val)
                {
                    res.set(node.index,val);
                    queue.poll();
                }
                else break;
            }
            queue.add(new Node(val,cnt));
            cnt++;
        }

        int[] result=new int[res.size()];
        for (int i=0;i<result.length;i++)
        {
            result[i]=res.get(i);
        }
        return result;
    }
}
/**
 * 1030. 链表中的下一个更大节点  显示英文描述
 * 用户通过次数 7
 * 用户尝试次数 14
 * 通过次数 7
 * 提交次数 14
 * 题目难度 Medium
 * 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
 *
 * 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。
 *
 * 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
 *
 * 注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为 2，第二个节点值为 1，第三个节点值为 5 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[2,1,5]
 * 输出：[5,5,0]
 * 示例 2：
 *
 * 输入：[2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 * 示例 3：
 *
 * 输入：[1,7,5,1,9,2,5,1]
 * 输出：[7,9,9,9,0,5,0,0]
 *
 *
 * 提示：
 *
 * 对于链表中的每个节点，1 <= node.val <= 10^9
 * 给定列表的长度在 [0, 10000] 范围内
 */
