package JavaCode.contest.weekly.n201_300.n282;

import utils.Parse;

import java.util.Arrays;

/**
 * @author mikusugar
 */
public class N3 {

    public static void main(String[] args) {
        System.out.println(new N3().minimumTime(
                Parse.parseToIntArray("[10,7,4,2]"), 7
        ));
    }

    public long minimumTime(int[] time, int totalTrips) {
        if (time.length == 1) return (long) totalTrips * time[0];
        Arrays.sort(time);
        long right = (long) totalTrips * time[0];
        long left = 1;
        long res = right;
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = getSum(time, mid, totalTrips);
            if (sum >= totalTrips) {
                res = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        return res;

    }

    private long getSum(int[] time, long m, int total) {
        long res = 0;
        for (int i : time) {
            res += m / i;
            if (res >= total) {
                return res;
            }
        }
        return res;
    }
}
