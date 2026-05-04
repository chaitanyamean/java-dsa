import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> myMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (myMap.containsKey(complement)) {
                return new int[]{myMap.get(complement), i};
            } else {
                myMap.put(nums[i], i);
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(Arrays.toString(sol.twoSum(new int[]{2, 7, 11, 15}, 9)));  // [0, 1]
        System.out.println(Arrays.toString(sol.twoSum(new int[]{3, 2, 4}, 6)));       // [1, 2]
        System.out.println(Arrays.toString(sol.twoSum(new int[]{3, 3}, 6)));           // [0, 1]
    }
}
