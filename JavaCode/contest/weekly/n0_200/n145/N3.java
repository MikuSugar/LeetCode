package JavaCode.contest.weekly.n0_200.n145;

public class N3 {

    public int longestWPI(int[] hours) {
        int[] sum=new int[hours.length+1];
        sum[0]=0;
        for (int i=0;i<hours.length;i++)
        {
            sum[i+1]=sum[i]+(hours[i]>=9?1:-1);
        }
        int res=0;
        for (int i=0;i<hours.length;i++)
        {
            for (int j=i+1;j<=hours.length;j++)
            {
                if(sum[j]-sum[i]>0)
                {
                    res=Math.max(j-i,res);
                }
            }
        }
        return res;
    }
}
/**
 *这里有一份工作时间表 hours，上面给出了某一位员工每天的工作小时数。
 *
 * 我们认为当一天中的工作小时数严格大于 8，这一天就是 劳累的一天。
 *
 * 表现良好时间段 意味着在这段时间内，劳累的天数严格大于不劳累的天数。
 *
 * 返回最长的表现良好时间段的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：hours = [9,9,6,0,6,6,9]
 * 输出：3
 * 解释：最长的表现良好时间段是 [9,9,6]。
 *
 *
 * 提示：
 *
 * 1 <= hours.length <= 10000
 * 0 <= hours[i] <= 16
 */
