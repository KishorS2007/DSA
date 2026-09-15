class DLLNode{
    int val , key ,  freq = 1;
    DLLNode prev , next;

    public DLLNode(int key , int val){
        this.key = key;
        this.val = val;
    }
}

class DLL{
    DLLNode head;
    DLLNode tail;
    int size = 0;

    public DLL(){
        head = new DLLNode(-1 , -1);
        tail = new DLLNode(-1 , -1);
        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(DLLNode node){
        DLLNode next = head.next;
        head.next = node;
        node.prev = head;

        node.next = next;
        next.prev = node;

        size++;
    }

    public void remove(DLLNode node){
        DLLNode prevNode = node.prev;
        prevNode.next = node.next;
        node.next.prev = prevNode;

        node.next = null;
        node.prev = null;

        size--;
    }
}
class LFUCache {
    int minFrequency = 1;
    Map<Integer,DLLNode> keyNode = new HashMap<>();
    Map<Integer,DLL> cache = new HashMap<>();
    int capacity , currCapacity = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        // invalid key 
        DLLNode node = keyNode.get(key);
        if(node == null) return -1;

        // valid key
        // remove from old freq cache
        int freq = node.freq;
        cache.putIfAbsent(freq,new DLL());
        DLL list = cache.get(freq);

        list.remove(node);
        if(list.size == 0 && freq == minFrequency){
            minFrequency++;
        }

        // add to new freq cache
        freq = ++node.freq;
        cache.putIfAbsent(freq,new DLL());
        DLL newList = cache.get(freq);
        newList.addFirst(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        DLLNode node = keyNode.get(key);
        
        // new key
        if(node == null){
            node = new DLLNode(key , value);
            keyNode.put(key,node);


            // least recently used minFreq
            if(currCapacity == capacity){
                DLL evict = cache.get(minFrequency);
                keyNode.remove(evict.tail.prev.key);
                evict.remove(evict.tail.prev);
                currCapacity--;
            }

            minFrequency = 1;
            
            cache.putIfAbsent(1,new DLL());
            DLL list = cache.get(1);
            list.addFirst(node);
            currCapacity++;

            return;
        }

        // key already present
        int freq = node.freq;
        node.val = value;

        cache.putIfAbsent(freq,new DLL());
        DLL list = cache.get(freq);
        list.remove(node);

        if(list.size == 0 && minFrequency == freq){
            minFrequency++;
        }

        freq = ++node.freq;
        cache.putIfAbsent(freq,new DLL());
        DLL newList = cache.get(freq);
        newList.addFirst(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */