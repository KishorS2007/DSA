class Trie{
    class TrieNode{
        private TrieNode[] childrens = new TrieNode[26];
        private boolean isEndOfWord;

        public void put(char c){
            if(childrens[c-'a'] != null) return;
            childrens[c-'a'] = new TrieNode();
        }

        public TrieNode get(char c){
            return childrens[c-'a'];
        }

        public void markEnd(){
            isEndOfWord = true;
        }

        public boolean isEnd(){
            return isEndOfWord;
        }
    }

    TrieNode root = new TrieNode();

    public void addWord(String s){
        TrieNode node = root;
        for(char c : s.toCharArray()){
            node.put(c);
            node = node.get(c);
        }

        node.markEnd();
    }

    public boolean searchWord(String s,int idx , Boolean[] dp){
        if(idx == s.length()) return true;
        if(dp[idx] != null) return dp[idx];

        TrieNode node = root;
        for(int i = idx ; i < s.length() ; i++){
            char c = s.charAt(i);
            
            node = node.get(c);
            if(node == null) break;

            if(node.isEnd()){
                if(searchWord(s,i+1 , dp)) return dp[idx] = true;
            }
        }

        return dp[idx] = false;
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        final int n = s.length();

        for(var word : wordDict) trie.addWord(word);

        
        return trie.searchWord(s,0 , new Boolean[s.length()]);
    }
}