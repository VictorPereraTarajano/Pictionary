package controller.impl.command.chat;

import controller.interfaces.Command;
import model.chat.ChatMessage;
import model.manager.ManagerLobby;

public class TypeChatCommand implements Command {

    private ChatMessage chatMessage;

    public TypeChatCommand(ChatMessage chatMessage) {
        this.chatMessage = chatMessage;
    }

    @Override
    public void execute() {
        ManagerLobby.myLobbyFrame.getChatPanel().getChatDialog().clear();
        ManagerLobby.myLobby.getChat().add(chatMessage);
        ManagerLobby.myLobbyFrame.getChatPanel().refresh(chatMessage);
    }
}
