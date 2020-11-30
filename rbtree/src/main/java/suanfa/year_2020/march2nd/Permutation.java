package suanfa.year_2020.march2nd;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther eleme
 * @time 2020/6/2 10:23 上午
 * @desc
 */
public class Permutation {

    public static void main(String[] args) {
        Permutation client = new Permutation();
        String[] abcs = client.permutation("abc");

        System.out.println(JSONObject.toJSONString(abcs));

    }

    public String[] permutation(String S) {
        List<String> res = new ArrayList<>();
        boolean[] visited = new boolean[S.length()];
        permutationHelper(S, 0, res, visited, "");

        String[] strings = res.toArray(new String[0]);
        return strings;
    }

    public void permutationHelper(String S, int start, List<String> res, boolean[] visited, String out) {
        if (out.length() == S.length()) {
            res.add(new String(out));
            return;
        }
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            out += chars[i];
            permutationHelper(S, start + 1, res, visited, out);
            out = out.substring(0, out.length() - 1);
            visited[i] = false;
        }
    }
}
