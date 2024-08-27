package ch13.Example03;

public class Container<T,K> {

    private T key;
    private K value;


    public void set(T key, K value) {
        this.value = value;
        this.key = key;
    }

    public K getValue() {
        return value;
    }

    public T getKey() {
        return key;
    }
}

