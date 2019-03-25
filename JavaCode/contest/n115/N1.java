package JavaCode.contest.n115;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new N1().prisonAfterNDays(new int[]{0,1,0,1,1,0,0,1},100001)));
    }

    public int[] prisonAfterNDays(int[] cells, int N) {

        List<int[]> list=new ArrayList<>();
        boolean[] book=new boolean[cells.length];
        int[] one;
        help(cells,book,list);
        one=Arrays.copyOf(cells,8);
        for (int i=1;i<N;i++)
        {
            help(cells,book,list);
            if(check(one,cells))
            {
                return list.get((N-1)%i);
            }
        }
        return cells;
    }

    private boolean check(int[] one, int[] cells) {
        for (int i=0;i<8;i++)
        {
            if (cells[i]!=one[i])return false;
        }
        return true;
    }

    private void help(int[] cells, boolean[] book,List<int[]> list) {
        book[0]=cells[0]==1;
        book[cells.length-1]=cells[cells.length-1]==1;

        for (int i=1;i<cells.length-1;i++)
        {
            if((cells[i-1]==0&&cells[i+1]==0)||(cells[i-1]==1&&cells[i+1]==1))
            {
                book[i]=cells[i]==0;
            }
            else
            {
                book[i]=cells[i]==1;
            }
        }
        for (int i=0;i<cells.length;i++)
        {
            if(book[i])
            {
                cells[i]=cells[i]==1?0:1;
            }
            book[i]=false;
        }
        list.add(Arrays.copyOf(cells,8));
    }
}
/**
 * 957. N 天后的牢房  显示英文描述
 * 用户通过次数 99
 * 用户尝试次数 187
 * 通过次数 102
 * 提交次数 516
 * 题目难度 Medium
 * 8 间牢房排成一排，每间牢房不是有人住就是空着。
 *
 * 每天，无论牢房是被占用或空置，都会根据以下规则进行更改：
 *
 * 如果一间牢房的两个相邻的房间都被占用或都是空的，那么该牢房就会被占用。
 * 否则，它就会被空置。
 * （请注意，由于监狱中的牢房排成一行，所以行中的第一个和最后一个房间无法有两个相邻的房间。）
 *
 * 我们用以下方式描述监狱的当前状态：如果第 i 间牢房被占用，则 cell[i]==1，否则 cell[i]==0。
 *
 * 根据监狱的初始状态，在 N 天后返回监狱的状况（和上述 N 种变化）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：cells = [0,1,0,1,1,0,0,1], N = 7
 * 输出：[0,0,1,1,0,0,0,0]
 * 解释：
 * 下表概述了监狱每天的状况：
 * Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
 * Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
 * Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
 * Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
 * Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
 * Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
 * Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
 * Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
 *
 * 示例 2：
 *
 * 输入：cells = [1,0,0,1,0,0,1,0], N = 1000000000
 * 输出：[0,0,1,1,1,1,1,0]
 *
 *
 * 提示：
 *
 * cells.length == 8
 * cells[i] 的值为 0 或 1
 * 1 <= N <= 10^9
 */
