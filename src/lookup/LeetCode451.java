package lookup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * 示例 1:
 *
 * 输入:
 * "tree"
 *
 * 输出:
 * "eert"
 *
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode451 {
    public String frequencySort(String s) {
        if (s == null || s.length() == 1) return s;
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++)
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);

        List<Character>[] buckets = new List[s.length() + 1];
        for (char c : map.keySet()) {
            int cnt = map.get(c);
            if (buckets[cnt] == null) {
                buckets[cnt] = new ArrayList<>();
            }
            buckets[cnt].add(c);
        }
        StringBuilder res = new StringBuilder();
        for (int i = buckets.length - 1; i > 0; i --) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    for (int j = 0; j < i; j++) {
                        res.append(c);
                    }
                }
            }
        }
        return res.toString();
    }
}
