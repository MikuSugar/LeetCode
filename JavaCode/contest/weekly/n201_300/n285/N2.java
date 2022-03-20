package JavaCode.contest.weekly.n201_300.n285;

/**
 * @author mikusugar
 */
public class N2 {

    public static void main(String[] args) {
        System.out.println(new N2().countCollisions("SRSRLLRSLLRSRSRLRRRRLLRRLSRR"));
    }

    public int countCollisions(String directions) {
        char[] strs = directions.toCharArray();
        strs = clean(strs);
        return solve(strs);
    }

    private char[] clean(char[] strs) {
        final StringBuilder sb = new StringBuilder();
        sb.append(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            if (strs[i] == 'S' && strs[i - 1] == 'S') continue;
            sb.append(strs[i]);
        }
        return sb.toString().toCharArray();
    }

    private int solve(char[] strs) {
        int res = 0;
        int p = 1;
        while (p < strs.length) {
            char pre = 'L';
            if (p > 0) pre = strs[p - 1];
            char cur = strs[p];
            if (cur == 'S') {
                if (pre == 'R') {
                    res++;
                    strs[p - 1] = 'S';
                    p--;
                    continue;
                }
            } else if (cur == 'L') {
                if (pre == 'R') {
                    res += 2;
                    strs[p] = 'S';
                    strs[p - 1] = 'S';
                    p--;
                    continue;
                } else if (pre == 'S') {
                    res += 1;
                    strs[p] = 'S';
                    continue;
                }
            }
            p++;
        }
        return res;
    }
}
/*
在一条无限长的公路上有 n 辆汽车正在行驶。汽车按从左到右的顺序按从 0 到 n - 1 编号，每辆车都在一个 独特的 位置。

给你一个下标从 0 开始的字符串 directions ，长度为 n 。directions[i] 可以是 'L'、'R' 或 'S' 分别表示第 i 辆车是向 左 、向 右 或者 停留 在当前位置。每辆车移动时 速度相同 。

碰撞次数可以按下述方式计算：

当两辆移动方向 相反 的车相撞时，碰撞次数加 2 。
当一辆移动的车和一辆静止的车相撞时，碰撞次数加 1 。
碰撞发生后，涉及的车辆将无法继续移动并停留在碰撞位置。除此之外，汽车不能改变它们的状态或移动方向。

返回在这条道路上发生的 碰撞总次数 。



示例 1：

输入：directions = "RLRSLL"
输出：5
解释：
将会在道路上发生的碰撞列出如下：
- 车 0 和车 1 会互相碰撞。由于它们按相反方向移动，碰撞数量变为 0 + 2 = 2 。
- 车 2 和车 3 会互相碰撞。由于 3 是静止的，碰撞数量变为 2 + 1 = 3 。
- 车 3 和车 4 会互相碰撞。由于 3 是静止的，碰撞数量变为 3 + 1 = 4 。
- 车 4 和车 5 会互相碰撞。在车 4 和车 3 碰撞之后，车 4 会待在碰撞位置，接着和车 5 碰撞。碰撞数量变为 4 + 1 = 5 。
因此，将会在道路上发生的碰撞总次数是 5 。
示例 2：

输入：directions = "LLRR"
输出：0
解释：
不存在会发生碰撞的车辆。因此，将会在道路上发生的碰撞总次数是 0 。


提示：

1 <= directions.length <= 105
directions[i] 的值为 'L'、'R' 或 'S'
 */
