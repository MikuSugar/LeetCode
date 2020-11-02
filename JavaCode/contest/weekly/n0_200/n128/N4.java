package JavaCode.contest.weekly.n0_200.n128;

public class N4 {


    private int cnt;
    private int N;
    public int numDupDigitsAtMostN(int N) {
        this.cnt=0;
        this.N =N;
        dfs(Integer.toString(N).length(),new StringBuilder(),new boolean[10]);
        return N-this.cnt;
    }

    private void dfs(int len,StringBuilder sb,boolean[] book) {
        if(!check(len,sb))return;

        for (int i=0;i<10;i++)
        {
            if(book[i])continue;
            book[i]=true;
            sb.append(i);
            dfs(len,sb,book);
            sb.deleteCharAt(sb.length()-1);
            book[i]=false;
        }
    }

    private boolean check(int len, StringBuilder sb) {
        if(sb.length()==0||(sb.length()==1&&sb.toString().equals("0"))) return true;
        if(sb.charAt(sb.length()-1)=='0')return true;
        if(sb.length()>len)return false;

        if(sb.length()<len)
        {
            this.cnt++;
            return true;
        }
        else
        {
            int temp = Integer.parseInt(sb.reverse().toString());
            sb.reverse();
            if (temp > this.N) return false;
            this.cnt++;
            return true;
        }
    }
}
/**
 *  1015. 至少有 1 位重复的数字  显示英文描述
 *
 * 给定正整数 N，返回小于等于 N 且具有至少 1 位重复数字的正整数。
 *
 * 示例 1：
 *
 * 输入：20
 * 输出：1
 * 解释：具有至少 1 位重复数字的正数（<= 20）只有 11 。
 * 示例 2：
 *
 * 输入：100
 * 输出：10
 * 解释：具有至少 1 位重复数字的正数（<= 100）有 11，22，33，44，55，66，77，88，99 和 100 。
 * 示例 3：
 *
 * 输入：1000
 * 输出：262
 */
