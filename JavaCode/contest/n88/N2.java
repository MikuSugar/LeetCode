package JavaCode.contest.n88;

public class N2 {


    public int maxDistToClosest(int[] seats) {
        int[]pair=new int[]{0,0};

        int start=0;
        int cur=0;
        while (cur<seats.length)
        {
            if(seats[cur]!=0)
            {
                int dif=cur-start;
                if(start==0||cur==seats.length)dif*=2;
                if(dif>pair[0])
                {
                    pair[0]=dif;
                    pair[1]=start;
                }
                cur++;
                start=cur;
            }
            else
            {
                cur++;
            }
        }
        if(seats[seats.length-1]==0)
        {
            int dif=(cur-start)*2;
            if(dif>pair[0])return cur-start;
        }

        if(pair[1]==0)return pair[0]/2;
        return (pair[0]+1)/2;
    }
}
/**
 * 849. 到最近的人的最大距离  显示英文描述
 * 用户通过次数 84
 * 用户尝试次数 97
 * 通过次数 84
 * 提交次数 215
 * 题目难度 Easy
 * 在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。
 *
 * 至少有一个空座位，且至少有一人坐在座位上。
 *
 * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
 *
 * 返回他到离他最近的人的最大距离。
 *
 * 示例 1：
 *
 * 输入：[1,0,0,0,1,0,1]
 * 输出：2
 * 解释：
 * 如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
 * 如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
 * 因此，他到离他最近的人的最大距离是 2 。
 * 示例 2：
 *
 * 输入：[1,0,0,0]
 * 输出：3
 * 解释：
 * 如果亚历克斯坐在最后一个座位上，他离最近的人有 3 个座位远。
 * 这是可能的最大距离，所以答案是 3 。
 * 提示：
 *
 * 1 <= seats.length <= 20000
 * seats 中只含有 0 和 1，至少有一个 0，且至少有一个 1。
 */
