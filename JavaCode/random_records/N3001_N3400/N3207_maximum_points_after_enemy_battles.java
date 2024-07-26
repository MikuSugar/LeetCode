package JavaCode.random_records.N3001_N3400;

import utils.CheckUtil;
import utils.Parse;

/**
 * @author mikusugar
 * @version 1.0, 2024/7/26 下午3:58
 * @description N3207_maximum_points_after_enemy_battles
 */
public class N3207_maximum_points_after_enemy_battles {
    public static void main(String[] args) {
        CheckUtil.check(0L, new N3207_maximum_points_after_enemy_battles().maximumPoints(
                Parse.toIntArr("[1,2,3]"), 0
        ));
        CheckUtil.check(5L, new N3207_maximum_points_after_enemy_battles().maximumPoints(
                Parse.toIntArr("[2]"), 10
        ));
        CheckUtil.check(3L, new N3207_maximum_points_after_enemy_battles().maximumPoints(
                Parse.toIntArr("[3,2,2]"), 2
        ));
    }

    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        int min = enemyEnergies[0];
        long sum = currentEnergy;
        for (int enemyEnergy : enemyEnergies) {
            min = Math.min(min, enemyEnergy);
            sum += enemyEnergy;
        }
        if (currentEnergy < min) {
            return 0;
        }
        return (sum - min) / min;
    }
}
/*
给你一个下标从 0 开始的整数数组 enemyEnergies ，它表示一个下标从 0 开始的敌人能量数组。

同时给你一个整数 currentEnergy ，它表示你一开始拥有的能量值总量。

你一开始的分数为 0 ，且一开始所有的敌人都未标记。

你可以通过以下操作 之一 任意次（也可以 0 次）来得分：

选择一个 未标记 且满足 currentEnergy >= enemyEnergies[i] 的敌人 i 。在这个操作中：
你会获得 1 分。
你的能量值减少 enemyEnergies[i] ，也就是说 currentEnergy = currentEnergy - enemyEnergies[i] 。
如果你目前 至少 有 1 分，你可以选择一个 未标记 的敌人 i 。在这个操作中：
你的能量值增加 enemyEnergies[i] ，也就是说 currentEnergy = currentEnergy + enemyEnergies[i] 。
敌人 i 被标记 。
请你返回通过以上操作，最多 可以获得多少分。



示例 1：

输入：enemyEnergies = [3,2,2], currentEnergy = 2

输出：3

解释：

通过以下操作可以得到最大得分 3 分：

对敌人 1 使用第一种操作：points 增加 1 ，currentEnergy 减少 2 。所以 points = 1 且 currentEnergy = 0 。
对敌人 0 使用第二种操作：currentEnergy 增加 3 ，敌人 0 被标记。所以 points = 1 ，currentEnergy = 3 ，被标记的敌人包括 [0] 。
对敌人 2 使用第一种操作：points 增加 1 ，currentEnergy 减少 2 。所以 points = 2 且 currentEnergy = 1 ，被标记的敌人包括[0] 。
对敌人 2 使用第二种操作：currentEnergy 增加 2 ，敌人 2 被标记。所以 points = 2 ，currentEnergy = 3 且被标记的敌人包括 [0, 2] 。
对敌人 1 使用第一种操作：points 增加 1 ，currentEnergy 减少 2 。所以 points = 3 ，currentEnergy = 1 ，被标记的敌人包括 [0, 2] 。
示例 2：

输入：enemyEnergies = [2], currentEnergy = 10

输出：5

解释：

通过对敌人 0 进行第一种操作 5 次，得到最大得分。



提示：

1 <= enemyEnergies.length <= 10^5
1 <= enemyEnergies[i] <= 10^9
0 <= currentEnergy <= 10^9
 */
