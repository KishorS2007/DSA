import java.util.*;
class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        final int n = servers.length , m = tasks.length;
        PriorityQueue<int[]> serverQ = new PriorityQueue<>(
            (a,b) -> {
                if(a[0] != b[0]) return Integer.compare(a[0],b[0]); // weight
                return Integer.compare(a[1],b[1]); // index
            }
        );

        PriorityQueue<int[]> workingQ = new PriorityQueue<>(
            (a,b) -> {
                if(a[2] != b[2]) return Integer.compare(a[2],b[2]); // completion time

                if(a[0] != b[0]) return Integer.compare(a[0],b[0]); // weight
                return Integer.compare(a[1],b[1]); // index
            }
        );

        for(int i = 0 ; i < n ; i++){
            // weight , index , completion time
            serverQ.offer(new int[]{servers[i] , i , 0});
        }

        int[] ans = new int[m];
        int t = 0;
        for(int j = 0 ; j < m ; j++){
            while(!workingQ.isEmpty() && workingQ.peek()[2] <= t){
                serverQ.offer(workingQ.poll());
            }

            if(serverQ.isEmpty()){
                t = workingQ.peek()[2];
                while(!workingQ.isEmpty() && workingQ.peek()[2] <= t){
                    serverQ.offer(workingQ.poll());
                }
            }

            int[] curr = serverQ.poll();
            ans[j] = curr[1];

            curr[2] = tasks[j] + t;

            workingQ.offer(curr);
            t = Math.max(t,j+1);
        }

        return ans;
    }
}