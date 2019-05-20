package JavaCode.random_records.N801_900;

import java.util.Arrays;
import java.util.Comparator;

public class N826_most_profit_assigning_work {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int p[][]=new int[difficulty.length][2];
        for (int i=0;i<difficulty.length;i++)
        {
            p[i][0]=profit[i];
            p[i][1]=difficulty[i];
        }
        //按工作难度排序
        Arrays.sort(p, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]-o1[0];
            }
        });
        
        int res=0;
        Arrays.sort(worker);
        int index=0;//工作指针
        for (int i=worker.length-1;i>=0;i--)
        {
            while (index<p.length&&worker[i]<p[index][1])
            {
                index++;
            }
            if(index==p.length)break;
            res+=p[index][0];
        }
        return res;
    }
}
/**
 * 有一些工作：difficulty[i] 表示第i个工作的难度，profit[i]表示第i个工作的收益。
 *
 * 现在我们有一些工人。worker[i]是第i个工人的能力，即该工人只能完成难度小于等于worker[i]的工作。
 *
 * 每一个工人都最多只能安排一个工作，但是一个工作可以完成多次。
 *
 * 举个例子，如果3个工人都尝试完成一份报酬为1的同样工作，那么总收益为 $3。如果一个工人不能完成任何工作，他的收益为 $0 。
 *
 * 我们能得到的最大收益是多少？
 *
 * 示例：
 *
 * 输入: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
 * 输出: 100
 * 解释: 工人被分配的工作难度是 [4,4,6,6] ，分别获得 [20,20,30,30] 的收益。
 * 提示:
 *
 * 1 <= difficulty.length = profit.length <= 10000
 * 1 <= worker.length <= 10000
 * difficulty[i], profit[i], worker[i]  的范围是 [1, 10^5]
 */
