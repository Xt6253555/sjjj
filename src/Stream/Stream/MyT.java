package Stream.Stream;
@FunctionalInterface
public interface MyT<T,R> {
    R getValue(T x,T y);
}
