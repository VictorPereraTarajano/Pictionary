package model.chat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Chat implements Serializable {

    private List<ChatMessage> messages;

    public Chat() {
        messages = new ArrayList<>();
    }

    public void add(ChatMessage chatMessage) {
        messages.add(chatMessage);
    }

    public ChatMessage getLastMessage () {
        return messages.get(messages.size()-1);
    }

    public void clear() {
        messages.clear();
    }

    public boolean isEmpty() {
        return messages.isEmpty();
    }
}
