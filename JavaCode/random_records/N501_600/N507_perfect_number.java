package JavaCode.random_records.N501_600;

public class N507_perfect_number {
    public boolean checkPerfectNumber(int num) {
        if(num<6)return false;
        int res=1,size=(int)Math.sqrt(num);
        for (int i=2;i<=size;i++)
        {
            if(num%i==0)
            {
                res+=i;
                if(i!=num/i)res+=num/i;
            }
        }
        return res==num;
    }
}
/**
 * 对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。
 *
 * 给定一个 正整数 n， 如果他是完美数，返回 True，否则返回 False
 *
 *  
 *
 * 示例：
 *
 * 输入: 28
 * 输出: True
 * 解释: 28 = 1 + 2 + 4 + 7 + 14
 *  
 *
 * 注意:
 *
 * 输入的数字 n 不会超过 100,000,000. (1e8)
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
