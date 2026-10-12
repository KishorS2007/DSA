class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] bits = new int[30];
        final int MOD = (int) 1e9 + 7;

        for(int num : nums){
            for(int i = 0 ; i < 30 ; i++){
                if(((1 << i) & num) != 0) bits[i]++;
            }
        }

        long ans = 0;
        while(k-- > 0){
            int x = 0;
            for(int i = 0 ; i < 30 ; i++){
                if(bits[i] > 0){
                    x |= (1 << i);
                    bits[i]--;
                }
            }

            ans = (ans + 1l * x * x) % MOD;
        }

        return (int) ans;
    }
}