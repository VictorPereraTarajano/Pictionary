package deserializer.impl;

import deserializer.interfaces.Builder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class StateBuilder<T> implements Builder<T> {

    @Override
    public T deserialize (byte[] byteArray, int byteArrayLength) {
        try {
            ObjectInputStream iStream = new ObjectInputStream(new ByteArrayInputStream(byteArray));
            T bundleState = (T) iStream.readObject();
            iStream.close();
            return bundleState;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
