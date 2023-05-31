package JavaCode.random_records.N2401_N2600;

import utils.Parse;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

/**
 * @author mikusugar
 * @version 1.0, 2023/3/27 15:37
 * @description N2453_destroy_sequential_targets
 */
public class N2453_destroy_sequential_targets {

    public static void main(String[] args) throws IOException {
        System.out.println(new N2453_destroy_sequential_targets().destroyTargets(
                Parse.toIntArr("[3,7,8,1,1,5]"), 2));
        System.out.println(new N2453_destroy_sequential_targets().destroyTargets(
                Parse.toIntArr("[1,3,5,2,4,6]"), 2));
        System.out.println(new N2453_destroy_sequential_targets().destroyTargets(
                Parse.toIntArr("[6,2,5]"), 100));

        final String arrStr = Files.readString(new File("src/JavaCode/random_records/N2401_N2600/2453.txt").toPath());
        System.out.println(new N2453_destroy_sequential_targets().destroyTargets(
                Parse.toIntArr(arrStr), 1));
    }

    //(a-b)%p=(a%p-b%p)%p
    public int destroyTargets(int[] nums, int space) {
        int max = 0;
        int res = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            final int i = (num + space) % space;
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int num : nums) {
            final int cur = (num + space) % space;
            int count = map.getOrDefault(cur, 0);
            if (count > max) {
                max = count;
                res = num;
            } else if (count == max) {
                res = Math.min(res, num);
            }
        }
        return res;

    }
}
/*
给你一个下标从 0 开始的数组 nums ，它包含若干正整数，表示数轴上你需要摧毁的目标所在的位置。同时给你一个整数 space 。

你有一台机器可以摧毁目标。给机器 输入 nums[i] ，这台机器会摧毁所有位置在 nums[i] + c * space 的目标，其中 c 是任意非负整数。你想摧毁 nums 中 尽可能多 的目标。

请你返回在摧毁数目最多的前提下，nums[i] 的 最小值 。

 

示例 1：

输入：nums = [3,7,8,1,1,5], space = 2
输出：1
解释：如果我们输入 nums[3] ，我们可以摧毁位于 1,3,5,7,9,... 这些位置的目标。
这种情况下， 我们总共可以摧毁 5 个目标（除了 nums[2]）。
没有办法摧毁多于 5 个目标，所以我们返回 nums[3] 。
示例 2：

输入：nums = [1,3,5,2,4,6], space = 2
输出：1
解释：输入 nums[0] 或者 nums[3] 都会摧毁 3 个目标。
没有办法摧毁多于 3 个目标。
由于 nums[0] 是最小的可以摧毁 3 个目标的整数，所以我们返回 1 。
示例 3：

输入：nums = [6,2,5], space = 100
输出：2
解释：无论我们输入哪个数字，都只能摧毁 1 个目标。输入的最小整数是 nums[1] 。
 

提示：

1 <= nums.length <= 105
1 <= nums[i] <= 109
1 <= space <= 109


来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/destroy-sequential-targets
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
