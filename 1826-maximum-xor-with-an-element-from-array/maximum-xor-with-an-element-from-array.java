import java.util.*;
class Trie{
    class TrieNode{
        TrieNode[] childrens = new TrieNode[2];
    
        public TrieNode setBit(int val){
            if(childrens[val] != null) return childrens[val];

            return childrens[val] = new TrieNode();
        }
    }

    public TrieNode root = new TrieNode();

    public void set(int val){
        TrieNode node = root;
        
        for(int i = 30 ; i >= 0 ; i--){
            node = node.setBit((val & (1 << i)) != 0 ? 1 : 0);
        }
    }

    public int maximumXor(int val){
        TrieNode node = root;

        int ans = 0;
        for(int i = 30 ; i >= 0 && node != null ; i--){
            int curr = val & 1 << i;

            if(curr != 0){
                if(node.childrens[0] != null){
                    ans |= (1 << i);
                    node = node.childrens[0];
                } else {
                    node = node.childrens[1];
                }
            } else {
                if(node.childrens[1] != null){
                    ans |= (1 << i);
                    node = node.childrens[1];
                } else {
                    node = node.childrens[0];
                }
            }
        }

        return ans;
    }
}
class Solution {
    private class Pair{
        int[] query;
        int idx;

        public Pair(int[] query , int idx){
            this.idx = idx;
            this.query = query;
        }
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        final int n = nums.length , m = queries.length;
        Arrays.sort(nums);
        
        Pair[] pair = new Pair[m];
        for(int i = 0 ; i < m ; i++){
            pair[i] = new Pair(queries[i],i);
        }
        Arrays.sort(pair,(a,b)->a.query[1] - b.query[1]);

        int l = 0;
        int[] ans = new int[m];

        Trie trie = new Trie();

        for(Pair p : pair){
            int x = p.query[0] , limit = p.query[1] , idx = p.idx;

            while(l < n && nums[l] <= limit){

                if(l == 0 || nums[l] != nums[l-1]){
                    trie.set(nums[l]);
                }

                l++;
            }

            if(nums[0] > limit){
                ans[idx] = -1;
                continue;
            }

            ans[idx] = trie.maximumXor(x);
        }

        return ans;
    }
}