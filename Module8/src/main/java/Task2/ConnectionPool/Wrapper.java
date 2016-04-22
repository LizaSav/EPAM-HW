package Task2.ConnectionPool;

@FunctionalInterface
public interface Wrapper<T> {
    T toSrc();
}