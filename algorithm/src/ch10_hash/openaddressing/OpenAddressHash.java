package ch10_hash.openaddressing;

public class OpenAddressHash<K, V> {

    enum Status {
        EMPTY, OCCUPIED, DELETED
    }

    public class Bucket<K, V> {
        private K key;
        private V value;
        private Status status;

        Bucket() {
            this.status = Status.EMPTY;
        }

        void Set(K key, V value, Status s) {
            this.key = key;
            this.value = value;
            this.status =s;
        }

        public V getValue() {
            return value;
        }
        public K getKey() {
            return key;
        }
        public void setStatus(Status s) {
            this.status=s;
        }
    }

    private Bucket<K,V>[] hash;
    private int size;

    OpenAddressHash(int size) {
        try{
            hash = new Bucket[size];
            for(int i=0; i<size ; i++) {
                hash[i] = new Bucket<K,V>();
            }
            this.size = size;
        } catch(OutOfMemoryError e){
            this.size=0;
        }
    }

    private int hashValue(Object key) {
        return key.hashCode()%size;
    }
    private int reHashValue(int hash) {
        return (hash+1)%size;
    }

    // key 가 k인 버킷을 검사.
    private Bucket<K,V> searchNode(K key) {
        int index = hashValue(key);
        Bucket<K,V> p = hash[index];

        for(int i =0; i<size; i++ ) {
            if(p.status == Status.OCCUPIED && p.getKey().equals(key)) {
                return p;
            }
            index = reHashValue(index);
            p = hash[index];
        }
        return null;
    }

    // 키값인 key인 요소의 데이터를 반환
    public V search(K key) {
        Bucket<K,V> p = searchNode(key);
        if(p == null) {
            return null;
        } else {
            return p.value;
        }
    }

    public int add(K key, V value) {
        if(search(key) != null) {
            System.out.println("key 중복");
            return -1;
        }
        int index = hashValue(key);
        for(int i = 0; i<size ; i++) {
            if(hash[index].status == Status.EMPTY || hash[index].status == Status.DELETED) {
                hash[index].Set(key,value,Status.OCCUPIED);
                return 1;
            } else {
                index = reHashValue(index);
            }
        }
        System.out.println("공간이 없음");
        return -1;
    }

    public int remove(K key) {
        Bucket<K,V> p = searchNode(key);
        if(p==null) {
            System.out.println("없는 값이다.");
            return -1;
        }
        p.setStatus(Status.DELETED);
        return 1;
    }

    public void dump() {
        for(int i =0; i<size;i++) {
            if(hash[i].status == Status.DELETED || hash[i].status== Status.EMPTY) {
                System.out.println(i+" : " + "status : " + hash[i].status);
            } else {
                System.out.println(i+" : " + "{"+hash[i].getKey()+","+hash[i].getValue()+"}" + "  status : " + hash[i].status);
            }
        }
    }

}
