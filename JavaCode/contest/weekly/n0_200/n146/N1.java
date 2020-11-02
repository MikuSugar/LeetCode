package JavaCode.contest.weekly.n0_200.n146;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class N1 {

    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String,Integer> map=new HashMap<>();
        for (int[] d:dominoes)
        {
            String key=getKey(d);
            map.put(key,map.getOrDefault(key,-1)+1);
        }
        int res=0;
        for (int i:map.values())
        {
            if(i==0)continue;
            res+=i*(i+1)/2;
        }
        return res;
    }

    private String getKey(int[] d) {
        Arrays.sort(d);
        return Arrays.toString(d);
    }
}
/**
 *  5130. 等价多米诺骨牌对的数量  显示英文描述
 * 用户通过次数 0
 * 用户尝试次数 0
 * 通过次数 0
 * 提交次数 0
 * 题目难度 Easy
 * 给你一个由一些多米诺骨牌组成的列表 dominoes。
 *
 * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 *
 * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
 *
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 *
 *
 *
 * 示例：
 *
 * 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= dominoes.length <= 40000
 * 1 <= dominoes[i][j] <= 9
 */
