package model.timer;

import controller.impl.command.timer.UpdateTimerCommand;
import controller.impl.sendcommand.SendMessageCommand;
import model.manager.ManagerConnection;
import model.manager.ManagerLobby;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class Timer extends javax.swing.Timer implements Serializable {

    public static final int initCount = 99;
    private int count = initCount;

    public Timer() {
        super(1000,new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                if (ManagerLobby.myLobby.getTimer().getCount() <= 0) {
                    ManagerLobby.myLobby.getTimer().stop();
                    /*if (ManagerLobby.myLobby.getGame().getPointer() < ManagerGame.NUM_MAX_TURNS)
                        //new SendMessageCommand(new SendTurnStateMessage(new SendTurnStateData(ManagerLobby.myLobby.getGame().nextTurn())), ManagerConnection.TCPBroadcast()).execute();
                    else
                        System.out.println("Show scoring");
                        //Muestro puntuaciones*/
                } else {
                    new SendMessageCommand(new UpdateTimerCommand(ManagerLobby.myLobby.getTimer().getCount() - 1), ManagerConnection.TCPBroadcastAll()).execute();
                }
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
        ManagerLobby.myLobby.getTimer().setCount(Timer.initCount);
        super.start();
    }

    @Override
    public void stop () {
        super.stop();
    }
}
