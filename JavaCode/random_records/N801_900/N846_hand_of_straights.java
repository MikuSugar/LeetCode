package JavaCode.random_records.N801_900;

import java.util.Map;
import java.util.TreeMap;

public class N846_hand_of_straights {
    public boolean isNStraightHand(int[] hand, int W) {
        if(hand.length%W!=0)return false;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for (int i:hand)
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        while (!map.isEmpty())
        {
            int s=map.firstKey();
            for (int i=s;i<s+W;i++)
            {
                int cnt=map.getOrDefault(i,-1);
                if(cnt!=-1)
                {
                    cnt--;
                    if(cnt==0)map.remove(i);
                    else map.put(i,cnt);
                }
                else return false;
            }
        }
        return true;
    }
}
/**
 * https://leetcode-cn.com/problems/hand-of-straights/
 * 爱丽丝有一手（hand）由整数数组给定的牌。
 *
 * 现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。
 *
 * 如果她可以完成分组就返回 true，否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：hand = [1,2,3,6,2,3,4,7,8], W = 3
 * 输出：true
 * 解释：爱丽丝的手牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
 * 示例 2：
 *
 * 输入：hand = [1,2,3,4,5], W = 4
 * 输出：false
 * 解释：爱丽丝的手牌无法被重新排列成几个大小为 4 的组。
 */
