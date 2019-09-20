package JavaCode.random_records.N901_1000;

import java.util.Arrays;

/**
 * author:fangjie
 * time:2019/9/19
 */
public class N956_tallest_billboard {
    public static void main(String[] args) {
        System.out.println(new N956_tallest_billboard().tallestBillboard(new int[]{1,2,3,4,5,6}));
    }
    public int tallestBillboard(int[] rods) {
        int[][] book=new int[rods.length][5000*2+5];
        for (int i=0;i<rods.length;i++)
        {
            Arrays.fill(book[i],-1);
        }
        int slove=slove(0, 5000, rods, book);
        return slove;
    }

    private int slove(int idx, int sum, int[] rods, int[][] book) {
        if (idx == rods.length) return sum == 5000 ? 0 : Integer.MIN_VALUE>>1;
        if (book[idx][sum]!=-1)return book[idx][sum];
        int res= slove(idx+1,sum, rods,book);
        res= Math.max(res, slove( idx+1, sum-rods[idx],rods,book));
        res = Math.max(res, rods[idx] + slove(idx+1, sum+rods[idx],rods,book));
        return book[idx][sum]=res;
    }
}
/**
 * 你正在安装一个广告牌，并希望它高度最大。这块广告牌将有两个钢制支架，两边各一个。每个钢支架的高度必须相等。
 *
 * 你有一堆可以焊接在一起的钢筋 rods。举个例子，如果钢筋的长度为 1、2 和 3，则可以将它们焊接在一起形成长度为 6 的支架。
 *
 * 返回广告牌的最大可能安装高度。如果没法安装广告牌，请返回 0。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,2,3,6]
 * 输出：6
 * 解释：我们有两个不相交的子集 {1,2,3} 和 {6}，它们具有相同的和 sum = 6。
 * 示例 2：
 *
 * 输入：[1,2,3,4,5,6]
 * 输出：10
 * 解释：我们有两个不相交的子集 {2,3,5} 和 {4,6}，它们具有相同的和 sum = 10。
 * 示例 3：
 *
 * 输入：[1,2]
 * 输出：0
 * 解释：没法安装广告牌，所以返回 0。
 *  
 *
 * 提示：
 *
 * 0 <= rods.length <= 20
 * 1 <= rods[i] <= 1000
 * 钢筋的长度总和最多为 5000
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/tallest-billboard
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
