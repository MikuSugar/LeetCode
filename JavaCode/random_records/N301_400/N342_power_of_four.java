package JavaCode.random_records.N301_400;

public class N342_power_of_four {
    public boolean isPowerOfFour(int num) {
        if(num<4&&num!=1)return false;
        if(num==1)return true;
        if(num%4!=0)return false;
        return isPowerOfFour(num/4);
    }
}
/**
 * https://leetcode-cn.com/problems/power-of-four/
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 16
 * 输出: true
 * 示例 2:
 *
 * 输入: 5
 * 输出: false
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 */
