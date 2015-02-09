package model.deserializer.impl;

import model.message.interfaces.Message;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserializer {
    public Message deserialize(byte [] receivedData, int lengthOfReceivedData) {
        try {
            ObjectInputStream iStream = new ObjectInputStream(new ByteArrayInputStream(receivedData));
            Message messageCommand = (Message) iStream.readObject();
            iStream.close();
            return messageCommand;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
