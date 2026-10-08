class Trie {
    class TrieNode{
        TrieNode[] childrens = new TrieNode[26];
        boolean isEndOfWord;
    }

    TrieNode root = new TrieNode();

    public Trie() {}
    
    public void insert(String word) {
        TrieNode node = root;

        for(char i : word.toCharArray()){
            int pos = i - 'a';
            
            if(node.childrens[pos] == null){
                node.childrens[pos] = new TrieNode();
            }

            node = node.childrens[pos];
        }

        node.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;

        for(char i : word.toCharArray()){
            int pos = i - 'a';
                        
            if(node.childrens[pos] == null) return false;

            node = node.childrens[pos];
        }

        return node.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;

        for(char i : prefix.toCharArray()){
            int pos = i - 'a';
                        
            if(node.childrens[pos] == null) return false;

            node = node.childrens[pos];
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