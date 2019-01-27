package JavaCode.array_and_string.two_pointer_technique;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        int[] t={5,25,75};
        System.out.println(Arrays.toString(new TwoSum().twoSum(t,100)));
    }

    public int[] twoSum(int[] numbers, int target) {
        int head=0;
        int tail=numbers.length-1;
        while (head<tail)
        {
            int s=numbers[head]+numbers[tail];
            if(s==target) return new int[]{head+1,tail+1};
            else if(s>target) tail--;
            else if(s<target) head++;
        }
        return new int[]{};
    }
}
/**
 * https://leetcode-cn.com/explore/learn/card/array-and-string/201/two-pointer-technique/785/
 * 两数之和 II - 输入有序数组
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
