package JavaCode.random_records.N1101_1200;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class N1116_print_zero_even_odd {
    class ZeroEvenOdd {
        private int n;
        private Semaphore s,s1,s2;
        public ZeroEvenOdd(int n) {
            this.n = n;
            s=new Semaphore(1);
            s1=new Semaphore(0);
            s2=new Semaphore(0);
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i=0;i<n;i++)
            {
                s.acquire();
                printNumber.accept(0);
                if(i%2!=0)
                {
                    s1.release();
                }
                else
                {
                    s2.release();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i=2;i<=n;i+=2)
            {
                s1.acquire();
                printNumber.accept(i);
                s.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i=1;i<=n;i+=2)
            {
                s2.acquire();
                printNumber.accept(i);
                s.release();
            }
        }
    }
}
/**
 *Suppose you are given the following code:
 *
 * class ZeroEvenOdd {
 *   public ZeroEvenOdd(int n) { ... }      // constructor
 *   public void zero(printNumber) { ... }  // only output 0's
 *   public void even(printNumber) { ... }  // only output even numbers
 *   public void odd(printNumber) { ... }   // only output odd numbers
 * }
 * The same instance of ZeroEvenOdd will be passed to three different threads:
 *
 * Thread A will call zero() which should only output 0's.
 * Thread B will call even() which should only ouput even numbers.
 * Thread C will call odd() which should only output odd numbers.
 * Each of the thread is given a printNumber method to output an integer. Modify the given program to output the series 010203040506... where the length of the series must be 2n.
 *
 *  
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: "0102"
 * Explanation: There are three threads being fired asynchronously. One of them calls zero(), the other calls even(), and the last one calls odd(). "0102" is the correct output.
 * Example 2:
 *
 * Input: n = 5
 * Output: "0102030405"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/print-zero-even-odd
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
