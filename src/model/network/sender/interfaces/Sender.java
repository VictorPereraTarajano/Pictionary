package model.network.sender.interfaces;

public interface Sender<T> {
    public void send (T objectToSend);
}