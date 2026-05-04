import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.hasDuplicate(new int[]{1, 2, 3, 1}));  // true
        System.out.println(sol.hasDuplicate(new int[]{1, 2, 3, 4}));  // false
        System.out.println(sol.hasDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2})); // true
    }
}
