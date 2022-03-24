package recursion;

import java.util.ArrayList;
import java.util.List;

public class LeetCode17 {
    final String[] letterMap = {
            "", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz", // 9
    };
    List<String> res = new ArrayList<>();

    private void findCombination(String digits, int index, String s){
        if (index == digits.length()){
            res.add(s);
            return;
        }
        char c = digits.charAt(index);
        if (c < '0' || c > '9' || c == '1')
            return;
        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digits, index + 1, s + letters.charAt(i));
        }
    }
    public List<String> letterCombinations(String digits) {
        if ("".equals(digits))
            return res;
        findCombination(digits, 0, "");
        return res;
    }

}
