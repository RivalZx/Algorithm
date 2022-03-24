package lookup;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode290 {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        char[] chars = pattern.toCharArray();
        String[] s1 = s.split(" ");
        if (chars.length != s1.length) return false;

        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i]) && !map.containsValue(s1[i])) {
                map.put(chars[i], s1[i]);
            } else if (!map.containsKey(chars[i]) || !map.containsValue(s1[i])) {
                return false;
            } else if (!map.get(chars[i]).equals(s1[i])){
                return false;
            }
        }
        return true;
    }
}
