package JavaCode.contest.weekly.n201_300.n213;

import utils.Parse;

import java.util.*;

/**
 * author: fangjie
 * email: syfangjie@live.cn
 * date: 2020/11/1 10:50 上午
 */
public class N3 {
    //TODO: rejudge error
    public static void main(String[] args) {
        System.out.println(new N3().furthestBuilding(Parse.toIntArr("[4,2,7,6,9,14,12]"),5,1));
    }
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pb=new PriorityQueue<>((o1, o2)->Integer.compare(o2,o1));
        PriorityQueue<Integer> pl=new PriorityQueue<>(Integer::compare);

        for (int i=0;i<heights.length;i++)
        {
            if(i==heights.length-1)return i;
            if(heights[i+1]<=heights[i])continue;
            int d=heights[i+1]-heights[i];
            if(bricks>=d)
            {
                pb.add(d);
                bricks-=d;
            }
            else if(ladders>0)
            {
                pl.add(d);
                ladders--;
            }
            else
            {
                int[] res=magic(pb,pl);
                bricks+=res[0];
                ladders+=res[1];
                if(bricks>=d)
                {
                    pb.add(d);
                    bricks-=d;
                }
                else if(ladders>0)
                {
                    pl.add(d);
                    ladders--;
                }
                else return i;
            }
        }
        return -1;
    }

    private int[] magic(PriorityQueue<Integer> pb, PriorityQueue<Integer> pl) {
        int[] res=new int[]{0,0};
        if(pl.isEmpty())return res;
        while (!pb.isEmpty())
        {
            int cur=pb.poll();
            if(pl.isEmpty()||cur<pl.peek()) return res;
            res[1]--;
            while (!pl.isEmpty()&&cur>=pl.peek())
            {
                int poll=pl.poll();
                cur-=poll;
                pb.add(poll);
                res[1]++;
            }
            res[0]=cur;
        }
        return res;
    }
}
/*
给你一个整数数组 heights ，表示建筑物的高度。另有一些砖块 bricks 和梯子 ladders 。

你从建筑物 0 开始旅程，不断向后面的建筑物移动，期间可能会用到砖块或梯子。

当从建筑物 i 移动到建筑物 i+1（下标 从 0 开始 ）时：

如果当前建筑物的高度 大于或等于 下一建筑物的高度，则不需要梯子或砖块
如果当前建筑的高度 小于 下一个建筑的高度，您可以使用 一架梯子 或 (h[i+1] - h[i]) 个砖块
如果以最佳方式使用给定的梯子和砖块，返回你可以到达的最远建筑物的下标（下标 从 0 开始 ）。


示例 1：


输入：heights = [4,2,7,6,9,14,12], bricks = 5, ladders = 1
输出：4
解释：从建筑物 0 出发，你可以按此方案完成旅程：
- 不使用砖块或梯子到达建筑物 1 ，因为 4 >= 2
- 使用 5 个砖块到达建筑物 2 。你必须使用砖块或梯子，因为 2 < 7
- 不使用砖块或梯子到达建筑物 3 ，因为 7 >= 6
- 使用唯一的梯子到达建筑物 4 。你必须使用砖块或梯子，因为 6 < 9
无法越过建筑物 4 ，因为没有更多砖块或梯子。
示例 2：

输入：heights = [4,12,2,7,3,18,20,3,19], bricks = 10, ladders = 2
输出：7
示例 3：

输入：heights = [14,3,19,3], bricks = 17, ladders = 0
输出：3


提示：

1 <= heights.length <= 105
1 <= heights[i] <= 106
0 <= bricks <= 109
0 <= ladders <= heights.length

 */
