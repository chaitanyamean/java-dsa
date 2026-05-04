import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for (String s : strs) {
            char[] characters = s.toCharArray();
            Arrays.sort(characters);
            String sortedS = new String(characters);

            res.putIfAbsent(sortedS, new ArrayList<>());
            res.get(sortedS).add(s);
        }

        return new ArrayList<>(res.values());
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        // [[eat, tea, ate], [tan, nat], [bat]]

        System.out.println(sol.groupAnagrams(new String[]{""}));
        // [[""]]

        System.out.println(sol.groupAnagrams(new String[]{"a"}));
        // [[a]]
    }
}
