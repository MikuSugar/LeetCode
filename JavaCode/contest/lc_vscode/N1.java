package JavaCode.contest.lc_vscode;


public class N1 {
    public static void main(String[] args) {
        System.out.println(new N1().leastMinutes(2));
    }
    public int leastMinutes(int n) {
        if (n <= 2) return n;
        int s = 1;
        int res = 0;
        while (s * 2 < n) {
            res++;
            s *= 2;
        }
        res += n / s;
        if(n%s!=0)res++;
        return res;
    }

}
