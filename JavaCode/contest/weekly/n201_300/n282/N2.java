package JavaCode.contest.weekly.n201_300.n282;

/**
 * @author mikusugar
 */
public class N2 {
    public int minSteps(String s, String t) {
        int[] book1 = new int[26];
        int[] book2 = new int[26];
        for (char c : s.toCharArray()) {
            book1[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            book2[c - 'a']++;
        }

        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += Math.abs(book1[i] - book2[i]);
        }
        return res;

    }
}
