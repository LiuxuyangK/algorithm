package suanfa.march1th;

import java.util.ArrayList;
import java.util.LinkedList;
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


//    另外还有两种很好的方法：
//    https://leetcode.com/problems/letter-combinations-of-a-phone-number/discuss/8064/My-java-solution-with-FIFO-queue

    public List<String> letterCombinations1(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if (digits.isEmpty()) return ans;
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length() == i) {
                String t = ans.remove();
                for (char s : mapping[x].toCharArray())
                    ans.add(t + s);
            }
        }
        return ans;
    }

    public List<String> letterCombinations2(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if (digits.isEmpty()) return ans;
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        while (ans.peek().length() != digits.length()) {
            String remove = ans.remove();
            String map = mapping[digits.charAt(remove.length()) - '0'];
            for (char c : map.toCharArray()) {
                ans.addLast(remove + c);
            }
        }
        return ans;
    }

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
