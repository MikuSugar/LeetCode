package JavaCode.random_records.N701_800;

import java.util.ArrayList;
import java.util.List;


public class N728_self_dividing_numbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res=new ArrayList<>();
        for (int i=left;i<=right;i++)
        {
            if(check(i))res.add(i);
        }
        return res;
    }

    private boolean check(int i) {
        int num=i;
        while (i!=0)
        {
            int temp=i%10;
            if(temp==0||num%temp!=0)return false;
            i/=10;
        }
        return true;
    }
}
/**
 * https://leetcode-cn.com/problems/self-dividing-numbers/
 * 自除数 是指可以被它包含的每一位数除尽的数。
 *
 * 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 *
 * 还有，自除数不允许包含 0 。
 *
 * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 *
 * 示例 1：
 *
 * 输入：
 * 上边界left = 1, 下边界right = 22
 * 输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 */
