package JavaCode.random_records.N501_600;

public class N551_student_attendance_record_i
{
    public boolean checkRecord(String s) {
        boolean isA=false;
        char pre='P';
        char ppre='P';
        for (char c:s.toCharArray())
        {
            if(c=='A')
            {
                if(isA)return false;
                isA=true;
            }
            else if(c=='L'&&pre=='L'&&ppre=='L')
            {
                return false;
            }
            ppre=pre;
            pre=c;
        }
        return true;
    }
}
/**
 * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
 *
 * 'A' : Absent，缺勤
 * 'L' : Late，迟到
 * 'P' : Present，到场
 * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
 *
 * 你需要根据这个学生的出勤记录判断他是否会被奖赏。
 *
 * 示例 1:
 *
 * 输入: "PPALLP"
 * 输出: True
 * 示例 2:
 *
 * 输入: "PPALLL"
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/student-attendance-record-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
