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
        for(int i = 30 ; i >= 0; i--){
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
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();

        for(int num : nums){
            trie.set(num);
        }

        int max = 0;
        for(int num : nums) max = Math.max(max , trie.maximumXor(num));
    
        return max;
    }
}