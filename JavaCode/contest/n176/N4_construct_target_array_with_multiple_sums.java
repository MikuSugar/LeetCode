package JavaCode.contest.n176;

import java.util.*;

/**
 * author:fangjie
 * time:2020/3/9
 */
public class N4_construct_target_array_with_multiple_sums {
    public static void main(String[] args) {
        System.out.println(new N4_construct_target_array_with_multiple_sums().isPossible(new int[]{9,3,5}));
    }
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2,o1);
            }
        });
        long sum=0;
        for (int i:target)
        {
            sum+=i;
            pq.add(i);
        }
        while (true)
        {
            int cur=pq.poll();
            sum-=cur;
            if(cur==1||sum==1)return true;
            if(cur<sum||sum==0||cur%sum==0)return false;
            cur%=sum;
            sum+=cur;
            pq.add(cur);
        }
    }
}
/*
给你一个整数数组 target 。一开始，你有一个数组 A ，它的所有元素均为 1 ，你可以执行以下操作：

令 x 为你数组里所有元素的和
选择满足 0 <= i < target.size 的任意下标 i ，并让 A 数组里下标为 i 处的值为 x 。
你可以重复该过程任意次
如果能从 A 开始构造出目标数组 target ，请你返回 True ，否则返回 False 。

 

示例 1：

输入：target = [9,3,5]
输出：true
解释：从 [1, 1, 1] 开始
[1, 1, 1], 和为 3 ，选择下标 1
[1, 3, 1], 和为 5， 选择下标 2
[1, 3, 5], 和为 9， 选择下标 0
[9, 3, 5] 完成
示例 2：

输入：target = [1,1,1,2]
输出：false
解释：不可能从 [1,1,1,1] 出发构造目标数组。
示例 3：

输入：target = [8,5]
输出：true
 

提示：

N == target.length
1 <= target.length <= 5 * 10^4
1 <= target[i] <= 10^9

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/construct-target-array-with-multiple-sums
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
