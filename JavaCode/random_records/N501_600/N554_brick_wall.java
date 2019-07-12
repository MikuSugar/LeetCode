package JavaCode.random_records.N501_600;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N554_brick_wall {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer,Integer> map=new HashMap<>();
        for (List<Integer> b:wall)
        {
            int len=0;
            for (int i:b)
            {
                len+=i;
                map.put(len,map.getOrDefault(len,0)+1);
            }
            map.put(len,0);
        }
        int res=0;
        for (int i:map.values())
        {
            res=Math.max(res,i);
        }
        return wall.size()-res;
    }
}
/**
 * 你的面前有一堵方形的、由多行砖块组成的砖墙。 这些砖块高度相同但是宽度不同。你现在要画一条自顶向下的、穿过最少砖块的垂线。
 *
 * 砖墙由行的列表表示。 每一行都是一个代表从左至右每块砖的宽度的整数列表。
 *
 * 如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你需要找出怎样画才能使这条线穿过的砖块数量最少，并且返回穿过的砖块数量。
 *
 * 你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
 *
 *  
 *
 * 示例：
 *
 * 输入: [[1,2,2,1],
 *       [3,1,2],
 *       [1,3,2],
 *       [2,4],
 *       [3,1,2],
 *       [1,3,1,1]]
 *
 * 输出: 2
 *
 * 解释:
 *
 *  
 *
 * 提示：
 *
 * 每一行砖块的宽度之和应该相等，并且不能超过 INT_MAX。
 * 每一行砖块的数量在 [1,10,000] 范围内， 墙的高度在 [1,10,000] 范围内， 总的砖块数量不超过 20,000。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/brick-wall
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
