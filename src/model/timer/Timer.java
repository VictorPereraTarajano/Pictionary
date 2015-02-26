package model.timer;

import controller.impl.sendcommand.SendMessageCommand;
import model.manager.ManagerConnection;
import model.manager.ManagerGame;
import model.manager.ManagerLobby;
import model.statemessage.impl.SendTimerStateMessage;
import model.statemessage.impl.SendTurnStateMessage;
import model.statemessagedata.impl.SendTimerStateData;
import model.statemessagedata.impl.SendTurnStateData;

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
                    ((Timer) e.getSource()).stop();
                    if (ManagerLobby.myLobby.getGame().getPointer() < ManagerGame.NUM_MAX_TURNS)
                        new SendMessageCommand(new SendTurnStateMessage(new SendTurnStateData(ManagerLobby.myLobby.getGame().nextTurn())), ManagerConnection.TCPBroadcast()).execute();
                    else
                        System.out.println("Show scoring");
                        //Muestro puntuaciones
                } else {
                    ManagerLobby.myLobby.getTimer().setCount(ManagerLobby.myLobby.getTimer().getCount() - 1);
                    new SendMessageCommand(new SendTimerStateMessage(new SendTimerStateData(ManagerLobby.myLobby.getTimer())), ManagerConnection.UDPBroadcast()).execute();
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
}
