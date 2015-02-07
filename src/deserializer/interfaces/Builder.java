package deserializer.interfaces;

public interface Builder<T> {
    public T deserialize (byte [] byteArray, int byteArrayLength);
}
