package JavaCode.random_records.N301_400;

import java.util.Arrays;
import java.util.Comparator;

public class N354_russian_doll_envelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes==null||envelopes.length<2)
        {
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0])
                {
                    return o2[1]-o1[1];
                }
                return o1[0]-o2[0];
            }
        });

        int[] dp=new int[envelopes.length];
        int res=0;
        for (int[] e:envelopes)
        {
            int idx=Arrays.binarySearch(dp,0,res,e[1]);
            idx=idx<0?-(idx+1):idx;
            dp[idx]=e[1];
            if(idx==res)
            {
                res++;
            }
        }
        return res;
    }
}
/**
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 * 示例:
 *
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/russian-doll-envelopes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
