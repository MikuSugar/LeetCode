package JavaCode.contest.biweekly.biweekly_n11;

import java.util.Arrays;

/**
 * author:fangjie
 * time:2019/10/19
 */
public class N3 {
    public double probabilityOfHeads(double[] prob, int target) {
        double[][] dp=new double[target+1][prob.length+5];
        for (int i=0;i<dp.length;i++) Arrays.fill(dp[i],-1d);
        return slove(prob,target,0,dp);
    }

    private double slove(double[] prob, int target, int idx, double[][] dp) {
        if(idx==prob.length)
        {
            if(target==0)return 1;
            return 0;
        }
        if(dp[target][idx]!=-1d)return dp[target][idx];
        if(target==0)
        {
            return (1.0-prob[idx])*slove(prob,target,idx+1, dp);
        }
        if(target>prob.length-idx)return 0;
        double res=prob[idx]*slove(prob,target-1,idx+1, dp);
        res+=(1.0-prob[idx])*slove(prob,target,idx+1, dp);
        return dp[target][idx]=res;
    }
}
/**
 *你有一些不规则的硬币。第 i 枚硬币正面朝上的概率是 prob[i]。
 *
 * 请你抛掷每个硬币恰好一次，返回正面朝上的硬币数等于 target 的概率。
 *
 *
 *
 * 示例 1：
 *
 * 输入：prob = [0.4], target = 1
 * 输出：0.40000
 * 示例 2：
 *
 * 输入：prob = [0.5,0.5,0.5,0.5,0.5], target = 0
 * 输出：0.03125
 *
 *
 * 提示：
 *
 * 1 <= prob.length <= 1000
 * 0 <= prob[i] <= 1
 * 0 <= target <= prob.length
 * 如果答案与标准答案的误差在 10^-5 内，则被视为正确答案。
 */
