package JavaCode.contest.other.fall_2021_2;

import utils.Parse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mikusugar
 */
public class N3 {

    public static void main(String[] args) {
        //finalCnt = [1,16], totalNum = 21, edges = [[0,1],[1,2]], plans = [[2,1],[1,0],[3,0]]
        System.out.println(Arrays.toString(new N3().volunteerDeployment(
                Parse.toIntArr("[1,16]"),
                21,
                Parse.toIntTwoArr("[[0,1],[1,2]]"),
                Parse.toIntTwoArr("[[2,1],[1,0],[3,0]]")
        )));
    }

    public int[] volunteerDeployment(int[] finalCnt, long totalNum, int[][] edges, int[][] plans) {

        List<Integer>[] g = new List[finalCnt.length + 1];
        for (int i = 0; i <= finalCnt.length; i++) {
            g[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        String[] expe = new String[finalCnt.length + 1];
        expe[0] = "x";
        for (int i = 0; i < finalCnt.length; i++) {
            expe[i + 1] = finalCnt[i] + "";
        }

        for (int i = plans.length - 1; i >= 0; i--) {
            int idx = plans[i][1];
            int num = plans[i][0];
            if (num == 1) {
                expe[idx] = expe[idx] + "+" + expe[idx];
            } else if (num == 2) {
                for (int nidx : g[idx]) {
                    expe[nidx] = expe[nidx] + "-" + help(expe[idx]);
                }
            } else {
                for (int nidx : g[idx]) {
                    expe[nidx] = expe[nidx] + "+" + expe[idx];
                }
            }
        }
        StringBuilder e = new StringBuilder();
        for (String ex : expe) {
            e.append(ex).append("+");
        }
        e.deleteCharAt(e.length() - 1);
        e.append("=").append(totalNum);

        //System.out.println(e.toString());

        int x = solveEquation(e.toString());

        int[] res = new int[finalCnt.length + 1];
        res[0] = x;

        //System.out.println(x);

        for (int i = 0; i < finalCnt.length; i++) {
            res[i + 1] = finalCnt[i];
        }

        for (int i = plans.length - 1; i >= 0; i--) {
            int idx = plans[i][1];
            int num = plans[i][0];
            if (num == 1) {
                res[idx] = 2 * res[idx];
            } else if (num == 2) {
                for (int nidx : g[idx]) {
                    res[nidx] = res[nidx] - res[idx];
                }
            } else {
                for (int nidx : g[idx]) {
                    res[nidx] = res[nidx] + res[idx];
                }
            }
        }

        return res;


    }

    private String help(String s) {
        final char[] strs = s.toCharArray();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == '-') strs[i] = '+';
            else if (strs[i] == '+') strs[i] = '-';
        }
        return new String(strs);
    }

    public int solveEquation(String equation) {
        String[] s1 = equation.split("=");
        String[] left = s1[0].replace("-", "+-").split("\\+");
        String[] right = s1[1].replace("-", "+-").split("\\+");
        long x_cnt = 0;
        long sum = 0;
        for (String s : left) {
            if (s.length() == 0) continue;
            if (s.equals("x")) x_cnt++;
            else if (s.equals("-x")) x_cnt--;
            else if (s.charAt(s.length() - 1) == 'x') {
                x_cnt += Long.parseLong(s.substring(0, s.length() - 1));
            } else sum += Long.parseLong(s);
        }
        for (String s : right) {
            if (s.length() == 0) continue;
            if (s.equals("x")) x_cnt--;
            else if (s.equals("-x")) x_cnt++;
            else if (s.charAt(s.length() - 1) == 'x') {
                x_cnt -= Long.parseLong(s.substring(0, s.length() - 1));
            } else sum -= Long.parseLong(s);
        }
        return (int) (-sum / x_cnt);
    }


}
/*
「力扣挑战赛」有 n 个比赛场馆（场馆编号从 0 开始），场馆之间的通道分布情况记录于二维数组 edges 中，edges[i]= [x, y] 表示第 i 条通道连接场馆 x 和场馆 y(即两个场馆相邻)。初始每个场馆中都有一定人数的志愿者（不同场馆人数可能不同），后续 m 天每天均会根据赛事热度进行志愿者人数调配。调配方案分为如下三种：

将编号为 idx 的场馆内的志愿者人数减半；
将编号为 idx 的场馆相邻的场馆的志愿者人数都加上编号为 idx 的场馆的志愿者人数；
将编号为 idx 的场馆相邻的场馆的志愿者人数都减去编号为 idx 的场馆的志愿者人数。
所有的调配信息记录于数组 plans 中，plans[i] = [num,idx] 表示第 i 天对编号 idx 的场馆执行了第 num 种调配方案。
在比赛结束后对调配方案进行复盘时，不慎将第 0 个场馆的最终志愿者人数丢失，只保留了初始所有场馆的志愿者总人数 totalNum ，以及记录了第 1 ~ n-1 个场馆的最终志愿者人数的一维数组 finalCnt。请你根据现有的信息求出初始每个场馆的志愿者人数，并按场馆编号顺序返回志愿者人数列表。

注意：

测试数据保证当某场馆进行第一种调配时，该场馆的志愿者人数一定为偶数；
测试数据保证当某场馆进行第三种调配时，该场馆的相邻场馆志愿者人数不为负数；
测试数据保证比赛开始时每个场馆的志愿者人数都不超过 10^9；
测试数据保证给定的场馆间的道路分布情况中不会出现自环、重边的情况。
示例 1：

image.png
输入：
finalCnt = [1,16], totalNum = 21, edges = [[0,1],[1,2]], plans = [[2,1],[1,0],[3,0]]

输出：[5,7,9]

解释：
image.png

示例 2 ：

输入：
finalCnt = [4,13,4,3,8], totalNum = 54, edges = [[0,3],[1,3],[4,3],[2,3],[2,5]], plans = [[1,1],[3,3],[2,5],[1,0]]

输出：[10,16,9,4,7,8]

提示：

2 <= n <= 5*10^4
1 <= edges.length <= min((n * (n - 1)) / 2, 5*10^4)
0 <= edges[i][0], edges[i][1] < n
1 <= plans.length <= 10
1 <= plans[i][0] <=3
0 <= plans[i][1] < n
finalCnt.length = n-1
0 <= finalCnt[i] < 10^9
0 <= totalNum < 5*10^13
 */
