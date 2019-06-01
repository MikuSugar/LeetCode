package JavaCode.contest.biweekly_n1;

public class N4 {

    public int digitsCount(int d, int low, int high) {
        if(d!=0) return fun1(high,d)-fun1(low-1,d);
        else return fun0(high)-fun0(low-1);
    }
    int fun1(int n,int d)
    {
        if(n<0) return 0;
        int high,low,curr,tmp,i = 1;
        high = n;
        int sum = 0;
        while(high!=0){
            high = n/(int)Math.pow(10, i);// 获取第i位的高位
            tmp = n%(int)Math.pow(10, i);
            curr = tmp/(int)Math.pow(10, i-1);// 获取第i位
            low = tmp%(int)Math.pow(10, i-1);// 获取第i位的低位
            if(curr==d){
                sum+= high*(int)Math.pow(10, i-1)+low+1;
            }else if(curr<d){
                sum+=high*(int)Math.pow(10, i-1);
            }else{
                sum+=(high+1)*(int)Math.pow(10, i-1);
            }
            i++;
        }
        return sum;
    }
    int fun0(int num)
    {
        if(num<0)return 0;
        int base = 1;
        int sum = 0;
        int n = num;
        while (n != 0) {
            sum += base * (n / 10 - 1);
            int cur = n % 10;
            if (cur == 0) {
                sum += num % base + 1;
            } else if (cur > 0) {
                sum += base;
            }
            base *= 10;
            n = n / 10;
        }
        return sum;
    }

}
/**
 *给定一个在 0 到 9 之间的整数 d，和两个正整数 low 和 high 分别作为上下界。返回 d 在 low 和 high 之间的整数中出现的次数，包括边界 low 和 high。
 *
 *
 *
 * 示例 1：
 *
 * 输入：d = 1, low = 1, high = 13
 * 输出：6
 * 解释：
 * 数字 d=1 在 1,10,11,12,13 中出现 6 次。注意 d=1 在数字 11 中出现两次。
 * 示例 2：
 *
 * 输入：d = 3, low = 100, high = 250
 * 输出：35
 * 解释：
 * 数字 d=3 在 103,113,123,130,131,...,238,239,243 出现 35 次。
 *
 *
 * 提示：
 *
 * 0 <= d <= 9
 * 1 <= low <= high <= 2×10^8
 */
