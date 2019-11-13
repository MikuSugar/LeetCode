package JavaCode.random_records.N501_600;

/**
 * author:fangjie
 * time:2019/11/13
 */
public class N507_base_7 {
    public String convertToBase7(int num) {
        if(num==0)return "0";
        String pre=num<0?"-":"";
        num=Math.abs(num);
        StringBuilder res=new StringBuilder();
        while (num>0)
        {
            res.append(num%7);
            num/=7;
        }
        return res.append(pre).reverse().toString();
    }
}
/*
给定一个整数，将其转化为7进制，并以字符串形式输出。

示例 1:

输入: 100
输出: "202"
示例 2:

输入: -7
输出: "-10"
注意: 输入范围是 [-1e7, 1e7] 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/base-7
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
