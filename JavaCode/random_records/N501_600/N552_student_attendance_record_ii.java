package JavaCode.random_records.N501_600;

public class N552_student_attendance_record_ii
{

    private static int Mod=(int) 1e9+7;
    public int checkRecord(int n) {
        if(n==1)return 3;

        int[] lastA=new int[n];//以A结尾
        int[] lastL=new int[n];//以L结尾
        int[] lastP=new int[n];//以P结尾
        lastA[0]=1;
        lastA[1]=2;
        lastA[2]=4;
        lastP[0]=1;
        lastL[0]=1;
        lastL[1]=3;
        for (int i=1;i<n;i++)
        {
            lastA[i-1]%=Mod;
            lastP[i-1]%=Mod;
            lastL[i-1]%=Mod;

            lastA[i-1]%=Mod;
            lastP[i-1]%=Mod;
            lastL[i-1]%=Mod;

            lastP[i]=((lastA[i-1]+lastP[i-1])%Mod+lastL[i-1])%Mod;
            if(i>1)lastL[i]=((lastA[i-1]+lastP[i-1])%Mod+(lastA[i-2]+lastP[i-2])%Mod)%Mod;
            if(i>2)lastA[i]=((lastA[i-1]+lastA[i-2])%Mod+lastA[i-3])%Mod;
        }
        return ((lastA[n-1]+lastL[n-1])%Mod+lastP[n-1])%Mod;
    }
}
/**
 * 给定一个正整数 n，返回长度为 n 的所有可被视为可奖励的出勤记录的数量。 答案可能非常大，你只需返回结果mod 109 + 7的值。
 *
 * 学生出勤记录是只包含以下三个字符的字符串：
 *
 * 'A' : Absent，缺勤
 * 'L' : Late，迟到
 * 'P' : Present，到场
 * 如果记录不包含多于一个'A'（缺勤）或超过两个连续的'L'（迟到），则该记录被视为可奖励的。
 *
 * 示例 1:
 *
 * 输入: n = 2
 * 输出: 8
 * 解释：
 * 有8个长度为2的记录将被视为可奖励：
 * "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
 * 只有"AA"不会被视为可奖励，因为缺勤次数超过一次。
 * 注意：n 的值不会超过100000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/student-attendance-record-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
