package JavaCode.contest.weekly.n0_200.n176;

import java.util.ArrayList;
import java.util.List;

/**
 * author:fangjie
 * time:2020/2/17
 */
public class N2_product_of_the_last_k_numbers { }
/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
class ProductOfNumbers {

    private List<Integer> list;
    public ProductOfNumbers() {
        list=new ArrayList<>(100);
    }

    public void add(int num) {
        if(num==0)list.clear();
        else if(list.isEmpty())list.add(num);
        else list.add(list.get(list.size()-1)*num);
    }

    public int getProduct(int k) {
        if(k>list.size())return 0;
        if(k==list.size())return list.get(list.size()-1);
        return list.get(list.size()-1)/list.get(list.size()-1-k);
    }
}
/*
请你实现一个「数字乘积类」ProductOfNumbers，要求支持下述两种方法：

1. add(int num)

将数字 num 添加到当前数字列表的最后面。
2. getProduct(int k)

返回当前数字列表中，最后 k 个数字的乘积。
你可以假设当前列表中始终 至少 包含 k 个数字。
题目数据保证：任何时候，任一连续数字序列的乘积都在 32-bit 整数范围内，不会溢出。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/product-of-the-last-k-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
