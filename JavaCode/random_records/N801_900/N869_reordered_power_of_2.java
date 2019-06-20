package JavaCode.random_records.N801_900;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class N869_reordered_power_of_2 {

    private static Set<String> set;
    static {
        set=new HashSet<>();
        set.add("1");
        int num=1;
        while (true)
        {
            num<<=1;
            char[] s=Integer.toString(num).toCharArray();
            if(s.length>10)break;
            Arrays.sort(s);
            set.add(new String(s));
        }
    }
    public boolean reorderedPowerOf2(int N) {
        char[] chars = Integer.toString(N).toCharArray();
        Arrays.sort(chars);
        String s = new String(chars);
        return set.contains(s);
    }
}
/**
 *给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
 *
 * 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：1
 * 输出：true
 * 示例 2：
 *
 * 输入：10
 * 输出：false
 * 示例 3：
 *
 * 输入：16
 * 输出：true
 * 示例 4：
 *
 * 输入：24
 * 输出：false
 * 示例 5：
 *
 * 输入：46
 * 输出：true
 *  
 *
 * 提示：
 *
 * 1 <= N <= 10^9
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reordered-power-of-2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
