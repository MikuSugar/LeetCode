package JavaCode.contest.weekly.n201_300.n282;

/**
 * @author mikusugar
 */
public class N1 {
    public int prefixCount(String[] words, String pref) {
        int res = 0;
        for (String s:words){
            if(s.startsWith(pref))res++;
        }
        return res;
    }
}
