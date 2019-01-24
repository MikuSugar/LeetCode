package JavaCode.queue_stack.stack_and_dfs;

import java.util.Stack;

public class FindTargetSumWays {

    class Node{
        int cnt;
        int sum;
        public Node(int cnt,int sum)
        {
            this.cnt=cnt;
            this.sum=sum;
        }
    }

    public int findTargetSumWays(int[] nums, int S) {
        if(nums.length==0) return 0;
        Stack<Node> stack=new Stack<>();

        stack.push(new Node(0,nums[0]));
        stack.push(new Node(0,-nums[0]));
        int ans=0;

        while (!stack.isEmpty())
        {
            Node node=stack.pop();
            if(node.cnt==nums.length-1&&node.sum==S) ans++;
            else if(node.cnt<nums.length-1)
            {
                stack.push(new Node(node.cnt+1,node.sum+nums[node.cnt+1]));
                stack.push(new Node(node.cnt+1,node.sum-nums[node.cnt+1]));
            }
        }

        return ans;
    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/queue-stack/219/stack-and-dfs/885/
 *   目标和
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 示例 1:
 *
 * 输入: nums: [1, 1, 1, 1, 1], S: 3
 * 输出: 5
 * 解释:
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * 一共有5种方法让最终目标和为3。
 * 注意:
 *
 * 数组的长度不会超过20，并且数组中的值全为正数。
 * 初始的数组的和不会超过1000。
 * 保证返回的最终结果为32位整数。
 */
