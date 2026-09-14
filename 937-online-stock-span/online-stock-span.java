import java.util.*;
class StockSpanner {
    Stack<int[]> stack = new Stack<>(); // val , stock span
    public StockSpanner() {}
    
    public int next(int price) {
        int span = 1;
        while(!stack.isEmpty()){
            int[] curr = stack.peek();
            if(curr[0] <= price){
                span += curr[1];
                stack.pop();
            } else {
                break;
            }
        }

        stack.push(new int[]{price,span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */