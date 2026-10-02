class MedianFinder {
    List<Integer> nums;
    public MedianFinder() {
        nums = new ArrayList<>();
    }
    
    public void addNum(int num) {

        int l = 0 , r = nums.size() - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;

            if(nums.get(mid) <= num){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        nums.add(l,num);
    }
    
    public double findMedian() {
        int size = nums.size();

        if(size % 2 == 1){
            return nums.get(size / 2);
        }

        return (1.0 * nums.get(size / 2) + nums.get((size - 1) / 2)) / 2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */