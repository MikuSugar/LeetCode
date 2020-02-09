package JavaCode.contest.biweekly_n19;

import java.util.*;

/**
 * author:fangjie
 * time:2020/2/9
 */
public class N4_jump_game_iv {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map=new HashMap<>();
        for (int i=0;i<arr.length;i++)
        {
            if(!map.containsKey(arr[i]))map.put(arr[i],new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        Queue<Integer> queue=new LinkedList<>();
        boolean[] book =new boolean[arr.length];
        Set<Integer> set=new HashSet<>();
        queue.add(0);
        int res=0;
        while (!queue.isEmpty())
        {
            int size=queue.size();
            while (size-->0)
            {
                int cur=queue.poll();
                if(book[cur])continue;
                book[cur]=true;
                if(cur==arr.length-1)return res;
                if(cur>0)queue.add(cur-1);
                queue.add(cur+1);
                if(set.contains(arr[cur]))continue;
                set.add(arr[cur]);
                for (int next:map.get(arr[cur]))
                {
                    if(book[next])continue;
                    queue.add(next);
                }
            }
            res++;
        }
        return -1;
    }
}
/*
给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。

每一步，你可以从下标 i 跳到下标：

i + 1 满足：i + 1 < arr.length
i - 1 满足：i - 1 >= 0
j 满足：arr[i] == arr[j] 且 i != j
请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。

注意：任何时候你都不能跳到数组外面。

 

示例 1：

输入：arr = [100,-23,-23,404,100,23,23,23,3,404]
输出：3
解释：那你需要跳跃 3 次，下标依次为 0 --> 4 --> 3 --> 9 。下标 9 为数组的最后一个元素的下标。
示例 2：

输入：arr = [7]
输出：0
解释：一开始就在最后一个元素处，所以你不需要跳跃。
示例 3：

输入：arr = [7,6,9,6,9,6,9,7]
输出：1
解释：你可以直接从下标 0 处跳到下标 7 处，也就是数组的最后一个元素处。
示例 4：

输入：arr = [6,1,9]
输出：2
示例 5：

输入：arr = [11,22,7,7,7,7,7,7,7,22,13]
输出：3
 

提示：

1 <= arr.length <= 5 * 10^4
-10^8 <= arr[i] <= 10^8

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/jump-game-iv
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
