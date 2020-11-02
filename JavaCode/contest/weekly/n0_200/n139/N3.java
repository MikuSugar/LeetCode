package JavaCode.contest.weekly.n0_200.n139;

import java.util.Stack;

public class N3 {

    public int[] addNegabinary(int[] arr1, int[] arr2) {
        Stack<Integer> stack=new Stack<>();
        int[] mina,maxa;
        if(arr1.length>arr2.length)
        {
            maxa=arr1;
            mina=arr2;
        }
        else
        {
            maxa=arr2;
            mina=arr1;
        }
        int len=mina.length;
        int t=0;
        for (int i=0;i<mina.length;i++)
        {
            int sum=mina[mina.length-1-i]+t+maxa[maxa.length-1-i];
            int m=mod(sum);
            stack.add(m);
            t=(sum-m)/(-2);
        }
        for (int i=maxa.length-len-1;i>=0;i--)
        {
            int sum=t+maxa[i];
            int m=mod(sum);
            stack.add(m);
            t=(sum-m)/(-2);
        }
        while (t!=0)
        {
            int m=mod(t);
            stack.add(m);
            t=(t-m)/-2;
        }

        //去前置0；
        while (stack.size()>1&&stack.peek()==0)
        {
            stack.pop();
        }

        int[] res=new int[stack.size()];
        for (int i=0;i<res.length;i++)
        {
            res[i]=stack.pop();
        }
        return res;
    }

    private int mod(int n)
    {
        if(n<0)
        {
            return n-(n/-2+1)*-2;
        }
        return n%(-2);
    }
}
/**
 *给出基数为 -2 的两个数 arr1 和 arr2，返回两数相加的结果。
 *
 * 数字以 数组形式 给出：数组由若干 0 和 1 组成，按最高有效位到最低有效位的顺序排列。例如，arr = [1,1,0,1] 表示数字 (-2)^3 + (-2)^2 + (-2)^0 = -3。数组形式 的数字也同样不含前导零：以 arr 为例，这意味着要么 arr == [0]，要么 arr[0] == 1。
 *
 * 返回相同表示形式的 arr1 和 arr2 相加的结果。两数的表示形式为：不含前导零、由若干 0 和 1 组成的数组。
 *
 *
 *
 * 示例：
 *
 * 输入：arr1 = [1,1,1,1,1], arr2 = [1,0,1]
 * 输出：[1,0,0,0,0]
 * 解释：arr1 表示 11，arr2 表示 5，输出表示 16 。
 *
 *
 * 提示：
 *
 * 1 <= arr1.length <= 1000
 * 1 <= arr2.length <= 1000
 * arr1 和 arr2 都不含前导零
 * arr1[i] 为 0 或 1
 * arr2[i] 为 0 或 1
 */
