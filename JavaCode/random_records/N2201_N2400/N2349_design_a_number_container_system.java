package JavaCode.random_records.N2201_N2400;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author mikusugar
 * @version 1.0, 2023/3/20 16:37
 * @description design-a-number-container-system
 */
public class N2349_design_a_number_container_system {
    public static void main(String[] args) {
        final NumberContainers containers = new NumberContainers();
        System.out.println(containers.find(10));
        containers.change(2, 10);
        containers.change(1, 10);
        containers.change(3, 10);
        containers.change(5, 10);
        System.out.println(containers.find(10));
        containers.change(1, 20);
        System.out.println(containers.find(10));
    }
}

class NumberContainers {

    private final Map<Integer, Integer> idx2Number;

    private final Map<Integer, TreeSet<Integer>> number2Ids;

    public NumberContainers() {
        idx2Number = new HashMap<>(100000);
        number2Ids = new HashMap<>(100000);
    }

    public void change(int index, int number) {
        final Integer oldNumber = idx2Number.get(index);
        if (oldNumber != null) {
            number2Ids.get(oldNumber).remove(index);
        }
        idx2Number.put(index, number);

        TreeSet<Integer> set = number2Ids.computeIfAbsent(number, k -> new TreeSet<>());
        set.add(index);
    }

    public int find(int number) {
        final TreeSet<Integer> set = number2Ids.get(number);
        if (set == null || set.isEmpty()) {
            return -1;
        }
        return set.first();
    }
}

/*
  Your NumberContainers object will be instantiated and called as such:
  NumberContainers obj = new NumberContainers();
  obj.change(index,number);
  int param_2 = obj.find(number);
 */

/*
设计一个数字容器系统，可以实现以下功能：

在系统中给定下标处 插入 或者 替换 一个数字。
返回 系统中给定数字的最小下标。
请你实现一个 NumberContainers 类：

NumberContainers() 初始化数字容器系统。
void change(int index, int number) 在下标 index 处填入 number 。如果该下标 index 处已经有数字了，那么用 number 替换该数字。
int find(int number) 返回给定数字 number 在系统中的最小下标。如果系统中没有 number ，那么返回 -1 。
 

示例：

输入：
["NumberContainers", "find", "change", "change", "change", "change", "find", "change", "find"]
[[], [10], [2, 10], [1, 10], [3, 10], [5, 10], [10], [1, 20], [10]]
输出：
[null, -1, null, null, null, null, 1, null, 2]

解释：
NumberContainers nc = new NumberContainers();
nc.find(10); // 没有数字 10 ，所以返回 -1 。
nc.change(2, 10); // 容器中下标为 2 处填入数字 10 。
nc.change(1, 10); // 容器中下标为 1 处填入数字 10 。
nc.change(3, 10); // 容器中下标为 3 处填入数字 10 。
nc.change(5, 10); // 容器中下标为 5 处填入数字 10 。
nc.find(10); // 数字 10 所在的下标为 1 ，2 ，3 和 5 。因为最小下标为 1 ，所以返回 1 。
nc.change(1, 20); // 容器中下标为 1 处填入数字 20 。注意，下标 1 处之前为 10 ，现在被替换为 20 。
nc.find(10); // 数字 10 所在下标为 2 ，3 和 5 。最小下标为 2 ，所以返回 2 。
 

提示：

1 <= index, number <= 109
调用 change 和 find 的 总次数 不超过 105 次。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/design-a-number-container-system
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
