package JavaCode.random_records.N201_300;

public class N233_number_of_digit_one
{
    public static void main(String[] args)
    {
        int a=1410065408;
        System.out.println(new N233_number_of_digit_one().countDigitOne(a));
    }
    public int countDigitOne(int n) {
        if(n<1) return 0;
        int res=0;
        long i=1;
        long cur;//当前位
        long after;//低位
        long before;//高位
        while ((n/i)!=0)
        {
            cur=(n/i)%10;
            before=n/(i*10);
            after=n-(n/i)*i;
            switch ((int)cur)
            {
                case 0:
                    res += before * i;
                    break;
                case 1:
                    res += before * i + after + 1;
                    break;
                default:
                    res += (before + 1) * i;
                    break;
            }
            i*=10;
        }
        return res;
    }
}
/**
 * https://leetcode-cn.com/problems/number-of-digit-one/
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 *
 * 示例:
 *
 * 输入: 13
 * 输出: 6
 * 解释: 数字 1 出现在以下数字中: 1, 10, 11, 12, 13 。
 */
