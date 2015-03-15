package controller.impl.command.chat;

import controller.interfaces.Command;
import model.chat.ChatMessage;

import static model.manager.ManagerLobby.myLobby;
import static model.manager.ManagerLobby.myLobbyFrame;

public class TypeChatCommand implements Command {

    private ChatMessage chatMessage;

    public TypeChatCommand(ChatMessage chatMessage) {
        this.chatMessage = chatMessage;
    }

    @Override
    public void execute() {
        myLobbyFrame.getChatPanel().getChatDialog().clear();
        myLobby.getChat().add(chatMessage);
        myLobbyFrame.getChatPanel().refresh(chatMessage);
    }
}
