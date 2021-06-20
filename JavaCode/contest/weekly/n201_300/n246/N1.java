package JavaCode.contest.weekly.n201_300.n246;

public class N1 {
    public String largestOddNumber(String num) {
        final char[] strs = num.toCharArray();
        int idx=strs.length-1;
        while (idx>=0){
            int n=strs[idx]-'0';
            if(n%2!=0)return num.substring(0,idx+1);
            idx--;
        }
        return "";
    }
}
/*

 */
