import java.util.*;
class NumberContainers {
    Map<Integer,Integer> indexToNumber = new HashMap<>();
    Map<Integer,TreeSet<Integer>> numberToIndex = new HashMap<>();
    public NumberContainers() {}
    
    public void change(int index, int number) {
        int num = indexToNumber.getOrDefault(index,-1);
        if(num != -1){
            numberToIndex.getOrDefault(num,new TreeSet<>()).remove(index);
        }

        indexToNumber.put(index,number);
        numberToIndex.putIfAbsent(number,new TreeSet<>());
        numberToIndex.get(number).add(index);
    }
    
    public int find(final int number) {
        TreeSet<Integer> indices = numberToIndex.get(number);
        if(indices == null || indices.isEmpty()) return -1;

        return indices.first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */