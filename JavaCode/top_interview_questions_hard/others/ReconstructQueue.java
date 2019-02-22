package JavaCode.top_interview_questions_hard.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {

        //首先按身高排序，身高相同人数大的在后面
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]) return o1[1]-o2[1];
                return o2[0]-o1[0];
            }
        });

        //插入排序，身高矮的插入身高高的前面不影响
        int len=people.length;
        List<int[]> temp=new ArrayList<>();
        for (int i=0;i<len;i++)
        {
            temp.add(people[i][1],new int[]{people[i][0],people[i][1]});
        }

        int[][] ans=new int[len][2];
        for(int i=0;i<len;i++)
        {
            ans[i][0]=temp.get(i)[0];
            ans[i][1]=temp.get(i)[1];
        }
        return ans;

    }
}
/**
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-hard/63/others/166/
 * Queue Reconstruction by Height
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 * 示例
 *
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
