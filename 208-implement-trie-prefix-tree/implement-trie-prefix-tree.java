class Trie {
    class TrieNode{
        private TrieNode[] childrens = new TrieNode[26];
        private boolean isEndOfWord = false;

        public boolean contains(char c){
            return childrens[c-'a'] != null;
        }

        public boolean isEnd(){
            return isEndOfWord;
        }

        public void setEnd(boolean val){
            isEndOfWord = val;
        }

        public void put(char c){
            if(contains(c)) return;
            childrens[c-'a'] = new TrieNode();
        }

        public TrieNode get(char c){
            return childrens[c-'a'];
        }
    }

    TrieNode root = new TrieNode();

    public Trie() {}
    
    public void insert(String word) {
        TrieNode node = root;
        for(char i : word.toCharArray()){
            node.put(i);
            node = node.get(i);
        }

        node.setEnd(true);
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for(char i : word.toCharArray()){
            if(!node.contains(i)) return false;
            node = node.get(i);
        }

        return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char i : prefix.toCharArray()){
            if(!node.contains(i)) return false;
            node = node.get(i);
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */