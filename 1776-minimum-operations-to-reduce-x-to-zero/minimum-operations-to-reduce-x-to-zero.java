class Solution {
    public int minOperations(int[] nums, int x) {
        final int n = nums.length;
        
        long[] prefix = new long[n+1];
        long[] suffix = new long[n+1];

        for(int i = 0 ; i  < n ; i++){
            prefix[i+1] = prefix[i] + nums[i];
        }

        for(int i = 1 ; i < n ; i++){
            suffix[i] = suffix[i-1] + nums[n-i];
        }

        int ans = n + 1; // impossible
        for(int i = 0 ; i <= n ; i++){
            if(prefix[i] > x) break;

            int nextIdx = find(suffix , x - prefix[i]);
            ans = Math.min(ans , nextIdx + i);
        }

        return ans > n ? -1 : ans;
    }

    private static int find(long[] arr , long target){
        int l = 0 , r = arr.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] >= target) r = mid-1;
            else l = mid+1;
        }

        return arr.length + 1;
    }
}