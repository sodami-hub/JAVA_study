package ch13.Example02;

public class Container<T> {
    private T value;

    public void set(T name) {
        this.value = name;
    }
    public T get() {
        return value;
    }
}
