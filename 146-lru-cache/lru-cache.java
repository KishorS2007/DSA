class LL{
    private class Node{
        int key , val;
        Node prev , next;

        public Node(int key , int val){
            this.key = key;
            this.val = val;
        }
    }

    Node head , tail;
    Map<Integer,Node> map = new HashMap<>();
    int length , capacity;

    public LL(int capacity){
        this.capacity = capacity;
    }

    public void put(int key,int value){
        Node node = map.get(key);

        // case 1
        if(node == null && head == null && tail == null){
            head = tail = new Node(key,value);
            map.put(key,head);
            length++;
            return;
        } 

        if(node == null){
            node = new Node(key,value);
            
            if(length == capacity){
                Node removable = tail;
                tail = tail.prev;
                map.remove(removable.key);

                if(tail == null){
                    head = tail = node;
                    map.put(key,node);
                    return;
                }

                tail.next = null;
                length--;
            }

            node.next = head;
            head.prev = node;
            head = node;
            map.put(key,node);
            length++;
        
        } else {
            node.val = value;

            if(head == node){
                return;
            }

            Node prev = node.prev;
            prev.next = node.next;

            if(node.next != null){
                node.next.prev = prev;
            } else {
                tail = prev;
            }

            node.next = head;
            node.prev = null;
            head.prev = node;
            head = node;
        }
    }

    public int get(int key){
        Node node = map.get(key);
        if(node == null) return -1;

        if(head == node){
            return node.val;
        }

        Node prev = node.prev;
        prev.next = node.next;

        if(node.next != null){
            node.next.prev = prev;
        } else {
            tail = prev;
        }

        node.next = head;
        node.prev = null;
        head.prev = node;
        head = node;

        return node.val;
    }
}

class LRUCache {
    
    LL list;

    public LRUCache(int capacity) {
        list = new LL(capacity);
    }
    
    public int get(int key) {
        return list.get(key);
    }
    
    public void put(int key, int value) {
        list.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */