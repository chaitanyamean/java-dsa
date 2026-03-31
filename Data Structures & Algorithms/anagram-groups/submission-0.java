class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> res = new HashMap<>();

        for(String s: strs) {
            char[] charaters = s.toCharArray();
            Arrays.sort(charaters);
            String sortedS = new String(charaters);

            res.putIfAbsent(sortedS, new ArrayList<>());
            res.get(sortedS).add(s);
        }

        return new ArrayList<>(res.values());
        
    }
}
