package controller.impl.sendcommand;

import controller.interfaces.Command;
import model.network.sender.interfaces.Sender;

public class SendCommand implements Command {

    private Command command;
    private Sender [] senders;

    public SendCommand(Command command, Sender[] senders) {
        this.command=command;
        this.senders=senders;
    }

    @Override
    public void execute() {
        for (Sender sender : senders) sender.send(command);
    }

    public Command getCommand() {
        return command;
    }
}
