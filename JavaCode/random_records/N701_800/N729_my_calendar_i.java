package JavaCode.random_records.N701_800;

public class N729_my_calendar_i {
    class MyCalendar {

        class Node
        {
            int start,end;
            Node left,right;
            public Node(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }

        Node root;

        public MyCalendar() {

        }

        public boolean book(int start, int end) {
            if(root==null)
            {
                root=new Node(start, end);
                return true;
            }
            return offer(root,start,end);
        }

        private boolean offer(Node node, int start, int end) {
            if(end<=node.start)
            {
                if(node.left==null)
                {
                    node.left=new Node(start,end);
                    return true;
                }
                else
                {
                    return offer(node.left,start,end);
                }
            }
            else if(start>=node.end)
            {
                if(node.right==null)
                {
                    node.right=new Node(start, end);
                    return true;
                }
                else
                {
                    return offer(node.right,start,end);
                }
            }
            return false;
        }
    }

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
}
/**
 * 实现一个 MyCalendar 类来存放你的日程安排。如果要添加的时间内没有其他安排，则可以存储这个新的日程安排。
 *
 * MyCalendar 有一个 book(int start, int end)方法。它意味着在 start 到 end 时间内增加一个日程安排，注意，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end。
 *
 * 当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生重复预订。
 *
 * 每次调用 MyCalendar.book方法时，如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true。否则，返回 false 并且不要将该日程安排添加到日历中。
 *
 * 请按照以下步骤调用 MyCalendar 类: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
 *
 * 示例 1:
 *
 * MyCalendar();
 * MyCalendar.book(10, 20); // returns true
 * MyCalendar.book(15, 25); // returns false
 * MyCalendar.book(20, 30); // returns true
 * 解释:
 * 第一个日程安排可以添加到日历中.  第二个日程安排不能添加到日历中，因为时间 15 已经被第一个日程安排预定了。
 * 第三个日程安排可以添加到日历中，因为第一个日程安排并不包含时间 20 。
 * 说明:
 *
 * 每个测试用例，调用 MyCalendar.book 函数最多不超过 100次。
 * 调用函数 MyCalendar.book(start, end)时， start 和 end 的取值范围为 [0, 10^9]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/my-calendar-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
