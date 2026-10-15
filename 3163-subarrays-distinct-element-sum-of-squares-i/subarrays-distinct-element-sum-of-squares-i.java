class Solution {
    public int sumCounts(List<Integer> nums) {
        int total = 0;
        for(int i = 0 ; i < nums.size() ; i++){
            Set<Integer> visited = new HashSet<>();
            for(int j = i ; j < nums.size() ; j++){
                visited.add(nums.get(j));
                int size = visited.size();
                total += size * size;
            }
        }

        return total;
    }
}