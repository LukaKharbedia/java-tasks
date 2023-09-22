import java.util.HashMap;
import java.util.Map;

public class ConstantTimeDeletionDataStructure<K, V> {
    private class Node {
        K key;
        V value;
        Node prev;
        Node next;
        
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private Map<K, Node> map;
    private Node head;
    private Node tail;
    
    public ConstantTimeDeletionDataStructure() {
        map = new HashMap<>();
        head = new Node(null, null);
        tail = new Node(null, null);
        head.next = tail;
        tail.prev = head;
    }
    
    public void put(K key, V value) {
        if (map.containsKey(key)) {
            remove(key);
        }
        
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        
        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode;
    }
    
    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }
        Node node = map.get(key);
        moveToHead(node);
        return node.value;
    }
    
    public void remove(K key) {
        if (!map.containsKey(key)) {
            return;
        }
        
        Node node = map.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        map.remove(key);
    }
    
    private void moveToHead(Node node) {
        remove(node.key);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        map.put(node.key, node);
    }
    
    public static void main(String[] args) {
        ConstantTimeDeletionDataStructure<String, Integer> dataStructure = new ConstantTimeDeletionDataStructure<>();    
        dataStructure.put("A", 1);
        dataStructure.put("B", 2);
        dataStructure.put("C", 3);
        System.out.println("Get B: " + dataStructure.get("B"));
        dataStructure.remove("B");
        System.out.println("Get B after removal: " + dataStructure.get("B"));
    }
}
