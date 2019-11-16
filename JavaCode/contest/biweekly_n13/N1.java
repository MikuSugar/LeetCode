package JavaCode.contest.biweekly_n13;

/**
 * author:fangjie
 * time:2019/11/16
 */
public class N1 {
    public String encode(int num) {
        if(num==0)return "";
        int level=getLevel(num+1);
        StringBuilder res=new StringBuilder();
        slove(level,num+1-((1<<(level-1))-1),res);
        return res.toString();
    }

    private void slove(int level, int i, StringBuilder res) {
        if(level==1)return;
        slove(level-1,(i+1)/2,res);
        res.append(String.valueOf((i+1)%2));
    }

    private int getLevel(int num) {
        int p=1,res=0;
        while (true)
        {
            if(p-1>=num)return res;
            res++;
            p<<=1;
        }
    }
}
/*
给你一个非负整数 num ，返回它的「加密字符串」。

加密的过程是把一个整数用某个未知函数进行转化，你需要从下表推测出该转化函数：





示例 1：

输入：num = 23
输出："1000"
示例 2：

输入：num = 107
输出："101100"


提示：

0 <= num <= 10^9
 */
