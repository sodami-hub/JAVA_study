package ch10_hash.chaining;

public class ChainingHash<K, V> {

    public class Node<K, V> {

        private K key;
        private V data;
        private Node<K, V> next;

        public Node(K key, V data, Node<K, V> next) {
            this.key = key;
            this.data = data;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return data;
        }

        public int hashCode() {
            return key.hashCode();
        }
    }

    private Node<K, V>[] hashArr;
    private int size;

    public ChainingHash(int size) {
        try {
            hashArr = new Node[size];
            this.size = size;
        } catch (OutOfMemoryError e) {
            this.size = 0;
        }
    }

    public int hashValue(Object key) {
        return key.hashCode() % size;
    }

    // 키 값이 key인 요소를 검색 - 데이터 반환
    public V search(K key) {
        int index = hashValue(key);

        if (hashArr[index] == null) {
            return null;
        } else {
            Node<K, V> cur = hashArr[index];
            while (!cur.getKey().equals(key)) {
                cur = cur.next;
            }
            return cur.data;
        }
    }

    public int add(K key, V value) {
        int index = hashValue(key);
        if (hashArr[index] == null) {
            hashArr[index] = new Node<K, V>(key, value, null);

        } else {
            Node<K, V> cur = hashArr[index];
            while (cur.next != null) {
                if (cur.getKey().equals(key)) {
                    System.out.println("이미 등록된 key 입니다.");
                    return -1;
                }
                cur = cur.next;
            }
            cur.next = new Node<K, V>(key, value, null);
        }
        return 1;
    }

    public int remove(K key) {
        int index = hashValue(key);

        Node<K, V> cur = hashArr[index];
        if (cur == null) {
            System.out.println("등록되지 않은 key 입니다.");
            return -1;
        } else {
            Node<K, V> pre =cur;
            while (!cur.getKey().equals(key)) {
                pre = cur;
                cur = cur.next;
            }
            pre.next = cur.next;
        }
        return 1;
    }

    public void dump() {
        for(int i = 0; i < size; i++ ) {
            System.out.print(i+ " -> ");
            Node<K,V> cur = hashArr[i];
            while(cur != null) {
                System.out.print("{"+cur.getKey()+ " : "+cur.getValue()+"} -> ");
                cur= cur.next;
            }
            System.out.println();
        }
    }
}
