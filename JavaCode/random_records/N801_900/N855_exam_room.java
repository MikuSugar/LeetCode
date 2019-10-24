package JavaCode.random_records.N801_900;

import java.util.TreeSet;

/**
 * author:fangjie
 * time:2019/10/24
 */
public class N855_exam_room {
    class ExamRoom {
        private TreeSet<Integer> set;
        private final int N;
        public ExamRoom(int N) {
            set=new TreeSet<>();
            this.N=N;
        }

        public int seat() {
            int id=0;
            if(set.isEmpty())
            {
                set.add(0);
                return 0;
            }
            int maxLen=set.first();
            int pre=-1;
            for (int cur:set)
            {
                if(pre!=-1)
                {
                    int t=(cur-pre)/2;
                    if(t>maxLen)
                    {
                        maxLen=t;
                        id=pre+maxLen;
                    }
                }
                pre=cur;
            }
            if(N-1-set.last()>maxLen)id=N-1;
            set.add(id);
            return id;
        }

        public void leave(int p) {
            set.remove(p);
        }
    }

/*
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
}
/*
在考场里，一排有 N 个座位，分别编号为 0, 1, 2, ..., N-1 。

当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，那么学生就坐在 0 号座位上。)

返回 ExamRoom(int N) 类，它有两个公开的函数：其中，函数 ExamRoom.seat() 会返回一个 int （整型数据），代表学生坐的位置；函数 ExamRoom.leave(int p) 代表坐在座位 p 上的学生现在离开了考场。每次调用 ExamRoom.leave(p) 时都保证有学生坐在座位 p 上。


示例：

输入：["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
输出：[null,0,9,4,2,null,5]
解释：
ExamRoom(10) -> null
seat() -> 0，没有人在考场里，那么学生坐在 0 号座位上。
seat() -> 9，学生最后坐在 9 号座位上。
seat() -> 4，学生最后坐在 4 号座位上。
seat() -> 2，学生最后坐在 2 号座位上。
leave(4) -> null
seat() -> 5，学生最后坐在 5 号座位上。
提示：
1 <= N <= 10^9
在所有的测试样例中 ExamRoom.seat() 和 ExamRoom.leave() 最多被调用 10^4 次。
保证在调用 ExamRoom.leave(p) 时有学生正坐在座位 p 上。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/exam-room
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
