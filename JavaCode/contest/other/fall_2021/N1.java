package JavaCode.contest.other.fall_2021;


import java.util.HashMap;
import java.util.Map;

/**
 * @author mikusugar
 */
public class N1 {

    public int minimumSwitchingTimes(int[][] source, int[][] target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] s : source) {
            for (int k : s) {
                map.put(k, map.getOrDefault(k, 0) + 1);
            }
        }
        int res = 0;
        for (int[] t : target) {
            for (int k : t) {
                if (map.containsKey(k)) {
                    final Integer cnt = map.get(k);
                    if (cnt == 1) map.remove(k);
                    else map.put(k, cnt - 1);
                } else res++;
            }
        }
        return res;
    }
}
/*
在 「力扣挑战赛」 开幕式的压轴节目 「无人机方阵」中，每一架无人机展示一种灯光颜色。 无人机方阵通过两种操作进行颜色图案变换：

调整无人机的位置布局
切换无人机展示的灯光颜色
给定两个大小均为 N*M 的二维数组 source 和 target 表示无人机方阵表演的两种颜色图案，由于无人机切换灯光颜色的耗能很大，请返回从 source 到 target 最少需要多少架无人机切换灯光颜色。

注意： 调整无人机的位置布局时无人机的位置可以随意变动。

示例 1：

输入：source = [[1,3],[5,4]], target = [[3,1],[6,5]]

输出：1

解释：
最佳方案为
将 [0,1] 处的无人机移动至 [0,0] 处；
将 [0,0] 处的无人机移动至 [0,1] 处；
将 [1,0] 处的无人机移动至 [1,1] 处；
将 [1,1] 处的无人机移动至 [1,0] 处，其灯光颜色切换为颜色编号为 6 的灯光；
因此从source 到 target 所需要的最少灯光切换次数为 1。
 */
