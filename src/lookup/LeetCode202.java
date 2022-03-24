package lookup;

import java.util.HashSet;
import java.util.Set;

/**
 * happy num
 */
public class LeetCode202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            int sum = 0;
            while (n > 0) {
                sum += (n%10) * (n%10);
                n /= 10;
            }
            if (set.contains(sum)) break;
            set.add(sum);
            n = sum;
        }
        return n == 1;
    }
}
