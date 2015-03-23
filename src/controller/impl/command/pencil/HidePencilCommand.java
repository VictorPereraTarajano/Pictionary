package controller.impl.command.pencil;

import controller.interfaces.Command;

import static model.manager.ManagerLobby.myLobby;
import static model.manager.ManagerLobby.myLobbyFrame;

public class HidePencilCommand implements Command {

    @Override
    public void execute() {
        //if (!ManagerLobby.myLobbyFrame.getCanvasPanel().getCanvasDisplay().isEditable()) return;
        myLobby.getCanvas().getPencil().setVisible(false);
        myLobbyFrame.getCanvasPanel().getCanvasDisplay().setLastPoint(null);
        myLobby.getCanvas().clear();
        myLobbyFrame.getCanvasPanel().refresh();
    }
}
