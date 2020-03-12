package JavaCode.random_records.N1301_1400;

/**
 * author:fangjie
 * time:2020/3/12
 */
public class N1360_number_of_days_between_two_dates {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(getToStartDat(date1)-getToStartDat(date2));
    }

    private int getToStartDat(String date) {
        String[] split=date.split("-");
        int year=Integer.parseInt(split[0]);
        int month=Integer.parseInt(split[1]);
        int day=Integer.parseInt(split[2]);

        int res=day-1;
        while (month!=0)
        {
            month--;
            res+=MONTHS[month];
            if(month==2&&isLeapYear(year))res++;
        }
        while (--year>=1971)
        {
            res+=isLeapYear(year)?366:365;
        }
        return res;
    }

    private final static int[] MONTHS={0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private boolean isLeapYear(int year)
    {
        return (year%400)==0||(year%100!=0&&year%4==0);
    }
}
/*
请你编写一个程序来计算两个日期之间隔了多少天。

日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。

 

示例 1：

输入：date1 = "2019-06-29", date2 = "2019-06-30"
输出：1
示例 2：

输入：date1 = "2020-01-15", date2 = "2019-12-31"
输出：15
 

提示：

给定的日期是 1971 年到 2100 年之间的有效日期。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-days-between-two-dates
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
