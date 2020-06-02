package suanfa.may31;

import java.util.Stack;

/**
 * @auther eleme
 * @time 2020/5/31 11:08 下午
 * @desc
 */
public class DecodeString {

    public static void main(String[] args) {
        DecodeString client = new DecodeString();

        String s = client.decodeString("3[a2[c]]");
        System.out.println(
                s
        );
    }

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();

        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        int nums = 0;
        char[] chars = s.toCharArray();

        for (char aChar : chars) {

            if(Character.isAlphabetic(aChar)){
                sb.append(aChar);
            }

            if(Character.isDigit(aChar)){
                nums = nums * 10 + (aChar - '0');
            }

            if(aChar == '['){
                numStack.push(nums);
                stringStack.push(sb);
                nums = 0;
                sb = new StringBuilder();
            }else{
                int num = numStack.pop();
                StringBuilder tmp = stringStack.pop();
                for (int i = 0; i < num; ++i) {
                    tmp.append(sb);
                }
                sb = tmp;
            }
        }
        return sb.toString();
    }

    public String decodeString2(String s) {
        String t = "";
        String res = "";
        Stack<Integer> s_num = new Stack<Integer>();
        Stack<String> s_str = new Stack<String>();
        int cnt = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                cnt = 10 * cnt + chars[i] - '0';
            }else if (chars[i] == '[') {
                s_num.push(cnt);
                s_str.push(t);
                cnt = 0;
                t = "";
            }else if (chars[i] == ']') {
                int k = s_num.pop();
                String str = t;
                for (int j = 0; j < k; ++j)
                    res += str;
                t = res;
            }else{
                t += chars[i];
            }
        }

        return res;
    }
}
