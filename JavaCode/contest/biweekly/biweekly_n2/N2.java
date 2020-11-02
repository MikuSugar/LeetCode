package JavaCode.contest.biweekly.biweekly_n2;

import java.util.*;

public class N2 {

    public int[][] highFive(int[][] items) {
        PriorityQueue<Integer>[] queues=new PriorityQueue[1005];
        for (int[] item:items)
        {
            if(queues[item[0]]==null)
            {
                queues[item[0]]=new PriorityQueue<>();
            }
            PriorityQueue<Integer> queue = queues[item[0]];
            queue.add(item[1]);
            if(queue.size()>5)queue.poll();
        }
        List<int[]> res=new ArrayList<>();

        for (int i=0;i<queues.length;i++)
        {
            if(queues[i]==null)continue;
            int sum=0;
            while (!queues[i].isEmpty())
            {
                sum+=queues[i].poll();
            }
            res.add(new int[]{i,sum/5});
        }
        res.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int[][] ans=new int[res.size()][2];
        for (int i=0;i<res.size();i++)
        {
            ans[i]=res.get(i);
        }
        return ans;
    }
}
/**
 *给你一个不同学生的分数列表，请按 学生的 id 顺序 返回每个学生 最高的五科 成绩的 平均分。
 *
 * 对于每条 items[i] 记录， items[i][0] 为学生的 id，items[i][1] 为学生的分数。平均分请采用整数除法计算。
 *
 *
 *
 * 示例：
 *
 * 输入：[[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
 * 输出：[[1,87],[2,88]]
 * 解释：
 * id = 1 的学生平均分为 87。
 * id = 2 的学生平均分为 88.6。但由于整数除法的缘故，平均分会被转换为 88。
 *
 *
 * 提示：
 *
 * 1 <= items.length <= 1000
 * items[i].length == 2
 * 学生的 ID 在 1 到 1000 之间
 * 学生的分数在 1 到 100 之间
 * 每个学生至少有五个分数
 */
