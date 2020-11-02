package JavaCode.contest.weekly.n0_200.n128;

import java.util.ArrayList;
import java.util.List;

public class N1 {
    public int bitwiseComplement(int N) {
        if(N==0)return 1;
        List<Integer> res=new ArrayList<>();
        help(res,N);
        int result=0;
        for(int i=0;i<res.size();i++)
        {
            if(res.get(i)==0)
            {
                result+=Math.pow(2,i);
            }
        }
        return result;
    }

    private void help(List<Integer> res,int n)
    {
        if(n==0) return;
        res.add(n%2);
        help(res,n/2);
    }
}
/**
 *  1012. 十进制整数的补码  显示英文描述
 * 每个非负整数 N 都有其二进制表示。例如， 5 可以被表示为二进制 "101"，11 可以用二进制 "1011" 表示，依此类推。注意，除 N = 0 外，任何二进制表示中都不含前导零。
 *
 * 二进制的补码表示是将每个 1 改为 0 且每个 0 变为 1。例如，二进制数 "101" 的二进制补码为 "010"。
 *
 * 给定十进制数 N，返回其二进制表示的补码所对应的十进制整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：5
 * 输出：2
 * 解释：5 的二进制表示为 "101"，其二进制补码为 "010"，也就是十进制中的 2 。
 * 示例 2：
 *
 * 输入：7
 * 输出：0
 * 解释：7 的二进制表示为 "111"，其二进制补码为 "000"，也就是十进制中的 0 。
 * 示例 3：
 *
 * 输入：10
 * 输出：5
 * 解释：10 的二进制表示为 "1010"，其二进制补码为 "0101"，也就是十进制中的 5 。
 *
 *
 * 提示：
 *
 * 0 <= N < 10^9
 */
