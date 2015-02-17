package model.chat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Chat implements Serializable {

    private final int MAX_SIZE_BUFFER=1;
    private List<ChatMessage> messages;

    public Chat() {
        messages = new ArrayList<>();
    }

    public void add(ChatMessage chatMessage) {
        if (messages.size() >= MAX_SIZE_BUFFER) clear();
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
