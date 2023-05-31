package JavaCode.contest.weekly.n201_300.n283;

import utils.Parse;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mikusugar
 */
public class N4 {

    public static void main(String[] args) {
        System.out.println(new N4().replaceNonCoprimes(
                Parse.toIntArr("[6,4,3,2,7,6,2]")
        ));
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Node root = new Node(-1);
        Node node = new Node(nums[0]);
        root.next = node;
        node.pre = root;
        Node p = node;
        for (int i = 1; i < nums.length; i++) {
            Node cur = new Node(nums[i]);
            p.next = cur;
            cur.pre = p;
            p = cur;
        }

        p = node;
        while (p.next != null) {
            final int gcd = gcd(p.val, p.next.val);
            if (gcd > 1) {
                int lcm = p.val / gcd * p.next.val;
                final Node lcmNode = new Node(lcm);
                final Node pre = p.pre;
                final Node next = p.next.next;
                lcmNode.pre = pre;
                lcmNode.next = next;
                pre.next = lcmNode;
                if (next != null) next.pre = lcmNode;
                if (pre != root) p = pre;
                else p = lcmNode;
            } else {
                p = p.next;
            }
        }
        p = root.next;
        while (p != null) {
            res.add(p.val);
            p = p.next;
        }
        return res;

    }

    static class Node {
        Node pre;
        Node next;
        int val;

        Node(int val) {
            this.val = val;
        }
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
/*
给你一个整数数组 nums 。请你对数组执行下述操作：

从 nums 中找出 任意 两个 相邻 的 非互质 数。
如果不存在这样的数，终止 这一过程。
否则，删除这两个数，并 替换 为它们的 最小公倍数（Least Common Multiple，LCM）。
只要还能找出两个相邻的非互质数就继续 重复 这一过程。
返回修改后得到的 最终 数组。可以证明的是，以 任意 顺序替换相邻的非互质数都可以得到相同的结果。

生成的测试用例可以保证最终数组中的值 小于或者等于 108 。

两个数字 x 和 y 满足 非互质数 的条件是：GCD(x, y) > 1 ，其中 GCD(x, y) 是 x 和 y 的 最大公约数 。



示例 1 ：

输入：nums = [6,4,3,2,7,6,2]
输出：[12,7,6]
解释：
- (6, 4) 是一组非互质数，且 LCM(6, 4) = 12 。得到 nums = [12,3,2,7,6,2] 。
- (12, 3) 是一组非互质数，且 LCM(12, 3) = 12 。得到 nums = [12,2,7,6,2] 。
- (12, 2) 是一组非互质数，且 LCM(12, 2) = 12 。得到 nums = [12,7,6,2] 。
- (6, 2) 是一组非互质数，且 LCM(6, 2) = 6 。得到 nums = [12,7,6] 。
现在，nums 中不存在相邻的非互质数。
因此，修改后得到的最终数组是 [12,7,6] 。
注意，存在其他方法可以获得相同的最终数组。
示例 2 ：

输入：nums = [2,2,1,1,3,3,3]
输出：[2,1,1,3]
解释：
- (3, 3) 是一组非互质数，且 LCM(3, 3) = 3 。得到 nums = [2,2,1,1,3,3] 。
- (3, 3) 是一组非互质数，且 LCM(3, 3) = 3 。得到 nums = [2,2,1,1,3] 。
- (2, 2) 是一组非互质数，且 LCM(2, 2) = 2 。得到 nums = [2,1,1,3] 。
现在，nums 中不存在相邻的非互质数。
因此，修改后得到的最终数组是 [2,1,1,3] 。
注意，存在其他方法可以获得相同的最终数组。


提示：

1 <= nums.length <= 105
1 <= nums[i] <= 105
生成的测试用例可以保证最终数组中的值 小于或者等于 108 。
 */
