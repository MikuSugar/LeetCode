package JavaCode.contest.fall_2019;


/**
 * author:fangjie
 * time:2019/9/24
 */
public class N2 {
    public int[] fraction(int[] cont) {
        if(cont.length==0)return new int[]{cont[0],1};
        int[] res=slove(0,cont);
        int gcd=gcd(res[0], res[1]);
        res[0]/=gcd;
        res[1]/=gcd;
        return res;

    }
    private int gcd(int a,int b)
    {
        if(a%b==0)return b;
        return gcd(b,a%b);
    }

    private int[] slove(int idx, int[] cont) {
        if(idx==cont.length)return new int[]{0,0};
        int[] slove=slove(idx+1, cont);
        return add(cont[idx],new int[]{slove[1],slove[0]});
    }

    private int[] add(int a1,int[] a2)
    {
        if(a2[0]==0)return new int[]{a1,1};
        return new int[]{a1*a2[1]+a2[0],a2[1]};
    }
}
/**
 *有一个同学在学习分式。他需要将一个连分数化成最简分数，你能帮助他吗？
 *
 *
 *
 * 连分数是形如上图的分式。在本题中，所有系数都是大于等于0的整数。
 *
 *
 *
 * 输入的cont代表连分数的系数（cont[0]代表上图的a0，以此类推）。返回一个长度为2的数组[n, m]，使得连分数的值等于n / m，且n, m最大公约数为1。
 *
 *
 *
 * 示例 1：
 *
 * 输入：cont = [3, 2, 0, 2]
 * 输出：[13, 4]
 * 解释：原连分数等价于3 + (1 / (2 + (1 / (0 + 1 / 2))))。注意[26, 8], [-13, -4]都不是正确答案。
 * 示例 2：
 *
 * 输入：cont = [0, 0, 3]
 * 输出：[3, 1]
 * 解释：如果答案是整数，令分母为1即可。
 * 限制：
 *
 * cont[i] >= 0
 * 1 <= cont的长度 <= 10
 * cont最后一个元素不等于0
 * 答案的n, m的取值都能被32位int整型存下（即不超过2 ^ 31 - 1）。
 */
