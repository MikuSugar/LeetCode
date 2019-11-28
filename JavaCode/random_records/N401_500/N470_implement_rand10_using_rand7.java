package JavaCode.random_records.N401_500;

/**
 * author:fangjie
 * time:2019/11/28
 */
public class N470_implement_rand10_using_rand7 {
    class Solution extends SolBase {
        public int rand10() {
            int rand=rand7();
            while (rand==4)rand=rand7();
            int pre=rand<4?0:5;
            rand=rand7();
            while (rand>5)rand=rand7();
            return rand+pre;
        }
    }
}

//方便代码编写
class SolBase
{
    public int rand7()
    {
        return (int) (Math.random()*7);
    }
}
/*
已有方法 rand7 可生成 1 到 7 范围内的均匀随机整数，试写一个方法 rand10 生成 1 到 10 范围内的均匀随机整数。

不要使用系统的 Math.random() 方法。

 

示例 1:

输入: 1
输出: [7]
示例 2:

输入: 2
输出: [8,4]
示例 3:

输入: 3
输出: [8,1,10]
 

提示:

rand7 已定义。
传入参数: n 表示 rand10 的调用次数。
 

进阶:

rand7()调用次数的 期望值 是多少 ?
你能否尽量少调用 rand7() ?

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/implement-rand10-using-rand7
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
