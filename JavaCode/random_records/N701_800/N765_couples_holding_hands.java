package JavaCode.random_records.N701_800;

/**
 * author:fangjie
 * time:2019/10/23
 */
public class N765_couples_holding_hands {
    public int minSwapsCouples(int[] row) {
        int res=0;
        int[] book=new int[row.length];
        for (int i=0;i<row.length;i++)
        {
            book[row[i]]=i;
        }
        for (int i=1;i<row.length;i+=2)
        {
            int find=find(row[i-1],row[i]);
            if(find==-1)continue;
            int j=book[find];
            swap(row,i,j);
            book[row[i]]=i;
            book[row[j]]=j;
            res++;
        }
        return res;
    }

    private int find(int i, int j) {
        if(i%2==0)
        {
            if(j==i+1)return -1;
            return i+1;
        }
        else
        {
            if(j+1==i)return -1;
            return i-1;
        }
    }
    private void swap(int[] nums,int i,int j)
    {
        nums[i]^=nums[j];
        nums[j]^=nums[i];
        nums[i]^=nums[j];
    }
}
/*
N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。 一次交换可选择任意两人，让他们站起来交换座位。

人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2N-2, 2N-1)。

这些情侣的初始座位  row[i] 是由最初始坐在第 i 个座位上的人决定的。

示例 1:

输入: row = [0, 2, 1, 3]
输出: 1
解释: 我们只需要交换row[1]和row[2]的位置即可。
示例 2:

输入: row = [3, 2, 0, 1]
输出: 0
解释: 无需交换座位，所有的情侣都已经可以手牵手了。
说明:

len(row) 是偶数且数值在 [4, 60]范围内。
可以保证row 是序列 0...len(row)-1 的一个全排列。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/couples-holding-hands
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
