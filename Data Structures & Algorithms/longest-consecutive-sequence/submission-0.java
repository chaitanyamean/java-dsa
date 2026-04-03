class Solution {
    public int longestConsecutive(int[] nums) {

        // Hasing
        Set<Integer> numSet = new HashSet<>();
        for(int num: nums) {
            numSet.add(num);
        }
        int longStreak= 0;
        for(int num: nums) {
            if(!numSet.contains(num - 1)) {
                int currentStreak = 1;
                int currentNum = num;

                while(numSet.contains(currentNum + 1)) {
                    currentStreak++;
                    currentNum++;
                }

                longStreak = Math.max(longStreak, currentStreak);
            }
        }
        return longStreak;
    }
}