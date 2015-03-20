package model.timer;

import controller.impl.command.game.turn.StartTurnCommand;
import controller.impl.command.timer.UpdateTimerCommand;
import controller.impl.sendcommand.SendCommand;
import model.manager.ManagerConnection;
import model.manager.ManagerLobby;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class Timer extends javax.swing.Timer implements Serializable {

    public static final int initCount = 50;
    private int count = initCount;

    public Timer() {
        super(1000,new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                if (ManagerLobby.myLobby.getTimer().getCount() <= 0) {
                    new SendCommand(new StartTurnCommand(ManagerLobby.myLobby.getGame().nextTurn()), ManagerConnection.TCPBroadcastAll()).execute();
                } else
                    new SendCommand(new UpdateTimerCommand(ManagerLobby.myLobby.getTimer().getCount() - 1), ManagerConnection.TCPBroadcastAll()).execute();
            }
        });
    }

    public void setCount(int count) {
        this.count=count;
    }

    public int getCount () {
        return this.count;
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void stop () {
        super.stop();
    }
}
