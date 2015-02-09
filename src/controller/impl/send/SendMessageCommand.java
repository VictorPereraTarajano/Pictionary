package controller.impl.send;

import controller.interfaces.Command;
import model.message.interfaces.Message;
import model.net.sender.interfaces.Sender;

public class SendMessageCommand implements Command{

    private Message message;
    private Sender<Message> sender;

    public SendMessageCommand(Message message, Sender sender) {
        this.message = message;
        this.sender = sender;
    }

    @Override
    public void execute() {
        sender.send(message);
    }

    public Message getMessage() {
        return message;
    }
}
