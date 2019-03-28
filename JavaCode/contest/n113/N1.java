package JavaCode.contest.n113;

import java.util.ArrayList;
import java.util.List;

public class N1 {

    private String res;
    public String largestTimeFromDigits(int[] A) {
        res="";
        List<Integer> list=new ArrayList<>();
        dfs(list,A,new boolean[4]);
        return res;
    }

    private void dfs(List<Integer> list, int[] a, boolean[] book) {
        if(list.size()==4)
        {
            if(check(list))
            {
                help(list);
            }
            return;
        }
        for (int i=0;i<4;i++)
        {
            if(book[i])continue;
            book[i]=true;
            list.add(a[i]);
            dfs(list,a,book);
            list.remove(list.size()-1);
            book[i]=false;
        }
    }

    /**
     * 更新res
     * @param list
     */
    private void help(List<Integer> list) {
        String h=list.get(0)+""+list.get(1);
        String m=list.get(2)+""+list.get(3);
        if(res.equals(""))res=h+":"+m;
        else
        {
            String[] s=res.split(":");
            int t=Integer.parseInt(s[0])*60+Integer.parseInt(s[1]);
            int t1=Integer.parseInt(h)*60+Integer.parseInt(m);
            if(t1>t)res=h+":"+m;
        }
    }

    /**
     * 检查是否合法
     * @param list
     * @return
     */
    private boolean check(List<Integer> list) {
        if(list.get(0)>2)return false;
        if(list.get(0)==2&&list.get(1)>3)return false;
        if(list.get(2)>5)return false;
        return true;
    }
}
/**
 * 949. 给定数字能组成的最大时间  显示英文描述
 * 用户通过次数 125
 * 用户尝试次数 213
 * 通过次数 127
 * 提交次数 774
 * 题目难度 Easy
 * 给定一个由 4 位数字组成的数组，返回可以设置的符合 24 小时制的最大时间。
 *
 * 最小的 24 小时制时间是 00:00，而最大的是 23:59。从 00:00 （午夜）开始算起，过得越久，时间越大。
 *
 * 以长度为 5 的字符串返回答案。如果不能确定有效时间，则返回空字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4]
 * 输出："23:41"
 * 示例 2：
 *
 * 输入：[5,5,5,5]
 * 输出：""
 *
 *
 * 提示：
 *
 * A.length == 4
 * 0 <= A[i] <= 9
 */
