package JavaCode.contest.biweekly.biweekly_n10;

import java.util.*;

/**
 * author:fangjie
 * time:2019/10/5
 */
public class N3 {
    private static List<Integer> number;
    static {
        number=new ArrayList<>(4000);
        number.add(0);
        for (int i=1;i<10;i++)
        {
            dfs(i+"",number);
        }
        Collections.sort(number);
    }

    private static void dfs(String s, List<Integer> number) {
        long i=Long.parseLong(s);
        if(i>2*1e9)return;
        number.add((int) i);
        long last=i%10,t;
        if(last>0)
        {
            t=last-1;
            dfs(s+t,number);
        }
        if(last<9)
        {   t=last+1;
            dfs(s+t,number);
        }
    }

    public List<Integer> countSteppingNumbers(int low, int high) {
        int start=Collections.binarySearch(number,low);
        List<Integer> res=new ArrayList<>();
        if(start==number.size())return res;
        if(start<0)start=-start-1;
        int end=Collections.binarySearch(number,high);
        if(end<0)end=-end-2;
        return number.subList(start,end<number.size()?end+1:number.size());
    }
}
/**
 *如果一个整数上的每一位数字与其相邻位上的数字的绝对差都是 1，那么这个数就是一个「步进数」。
 *
 * 例如，321 是一个步进数，而 421 不是。
 *
 * 给你两个整数，low 和 high，请你找出在 [low, high] 范围内的所有步进数，并返回 排序后 的结果。
 *
 *
 *
 * 示例：
 *
 * 输入：low = 0, high = 21
 * 输出：[0,1,2,3,4,5,6,7,8,9,10,12,21]
 *
 *
 * 提示：
 *
 * 0 <= low <= high <= 2 * 10^9
 */
