package JavaCode.contest.n127;

public class N3 {
    public int minDominoRotations(int[] A, int[] B) {
        int res1=0;
        int res2=0;
        int res3=0;
        int res4=0;
        int a=A[0];
        int b=B[0];
        for (int i=1;i<A.length;i++)
        {
           if(A[i]==a)continue;
           else
           {
               if(B[i]==a)res1++;
               else
               {
                   res1=Integer.MAX_VALUE;
                   break;
               }
           }
        }
        res2=a==b?0:1;
        for (int i=1;i<A.length;i++)
        {
            if(A[i]==b)continue;
            else
            {
                if(B[i]==b)res2++;
                else
                {
                    res2=Integer.MAX_VALUE;
                    break;
                }
            }
        }
        for (int i=1;i<A.length;i++)
        {
            if(B[i]==b)continue;
            else
            {
                if(A[i]==b)res3++;
                else
                {
                    res3=Integer.MAX_VALUE;
                    break;
                }
            }
        }
        res4=a==b?0:1;
        for (int i=1;i<A.length;i++)
        {
            if(B[i]==a)continue;
            else
            {
                if(A[i]==a)res4++;
                else
                {
                    res4=Integer.MAX_VALUE;
                    break;
                }
            }
        }
        if(res1==Integer.MAX_VALUE&&res2==Integer.MAX_VALUE&&res3==Integer.MAX_VALUE&&res4==Integer.MAX_VALUE)
        {
            return -1;
        }
        return Math.min(Math.min(res1,res2),Math.min(res3,res4));
    }
}
