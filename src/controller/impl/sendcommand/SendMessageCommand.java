package controller.impl.sendcommand;

import controller.interfaces.Command;
import model.message.interfaces.Message;
import model.network.sender.interfaces.Sender;

public class SendMessageCommand implements Command {

    private Message message;
    private Sender [] senders;

    public SendMessageCommand(Message message, Sender sender) {
        this.message = message;
        this.senders = new Sender[]{sender};
    }

    public SendMessageCommand(Message message, Sender [] senders) {
        this.message=message;
        this.senders=senders;
    }

    @Override
    public void execute() {
        for (Sender sender : senders) sender.send(message);
    }

    public Message getMessage() {
        return message;
    }
}
