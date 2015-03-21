package view.persistence.interfaces;

public interface Loader<T> {
    public T load (String filename);
}
