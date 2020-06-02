package suanfa.march1th;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther eleme
 * @time 2020/6/2 12:10 上午
 * @desc
 */
public class LetterCombinations {

    public static void main(String[] args) {
        NumIslands client = new NumIslands();


    }

    String[] numLetter = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        letterCombinations(digits.toCharArray(), 0, res, "");
        return res;
    }

    public void letterCombinations(char[] digits, int level, List<String> res, String out) {
        if (out.length() == digits.length) {
            res.add(out);
            return;
        }

        String str = numLetter[digits[level] - '0'];
        for (int i = 0; i < str.length(); ++i) {
            letterCombinations(digits, level + 1, res, out + str.charAt(i));
        }
    }


}
