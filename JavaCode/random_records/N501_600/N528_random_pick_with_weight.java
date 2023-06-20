package JavaCode.random_records.N501_600;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class N528_random_pick_with_weight {
    class Solution {
        private int size;
        private TreeMap<Integer,Integer> map;
        private Random random;
        public Solution(int[] w) {
            map=new TreeMap<>();
            for (int i=0;i<w.length;i++)
            {
                size+=w[i];
                map.put(size-1,i);
            }
            random=new Random();
        }

        public int pickIndex() {
            int r=random.nextInt(size);
            Map.Entry<Integer, Integer> e = map.ceilingEntry(r);
            return e.getValue();
        }
    }

/**
 * Your n2342 object will be instantiated and called as such:
 * n2342 obj = new n2342(w);
 * int param_1 = obj.pickIndex();
 */
}
/**
 * 给定一个正整数数组 w ，其中 w[i] 代表位置 i 的权重，请写一个函数 pickIndex ，它可以随机地获取位置 i，选取位置 i 的概率与 w[i] 成正比。
 *
 * 说明:
 *
 * 1 <= w.length <= 10000
 * 1 <= w[i] <= 10^5
 * pickIndex 将被调用不超过 10000 次
 * 示例1:
 *
 * 输入:
 * ["n2342","pickIndex"]
 * [[[1]],[]]
 * 输出: [null,0]
 * 示例2:
 *
 * 输入:
 * ["n2342","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * [[[1,3]],[],[],[],[],[]]
 * 输出: [null,0,1,1,1,0]
 * 输入语法说明：
 *
 * 输入是两个列表：调用成员函数名和调用的参数。n2342 的构造函数有一个参数，即数组 w。pickIndex 没有参数。输入参数是一个列表，即使参数为空，也会输入一个 [] 空列表。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/random-pick-with-weight
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
