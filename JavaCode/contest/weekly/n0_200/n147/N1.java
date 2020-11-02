package JavaCode.contest.weekly.n0_200.n147;

public class N1 {
    public static void main(String[] args) {
        System.out.println(new N1().tribonacci(4));
    }
    static int[] book;
    static
    {
        book=new int[38+1];
        book[0]=0;
        book[1]=1;
        book[2]=1;
        for (int i=3;i<book.length;i++)
        {
            book[i]=book[i-1]+book[i-2]+book[i-3];
        }
    }
    public int tribonacci(int n) {
        return book[n];
    }
}
/**
 *泰波那契序列 Tn 定义如下：
 *
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 *
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 *
 * 输入：n = 25
 * 输出：1389537
 */
