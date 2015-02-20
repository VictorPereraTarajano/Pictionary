package model.timer;

import controller.impl.sendcommand.SendMessageCommand;
import model.manager.ManagerConnection;
import model.manager.ManagerLobby;
import model.statemessage.impl.SendTimerStateMessage;
import model.statemessage.impl.SendTurnStateMessage;
import model.statemessagedata.impl.SendTimerStateData;
import model.statemessagedata.impl.SendTurnStateData;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class Timer extends javax.swing.Timer implements Serializable {

    public static final int initCount = 20;
    private int count = initCount;
    private static Timer mySelf;

    public Timer() {
        super(1000,new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                if (mySelf.count <= 0) {
                    new SendMessageCommand(new SendTurnStateMessage(new SendTurnStateData(ManagerLobby.myLobby.getGame().nextTurn())), ManagerConnection.TCPBroadcast()).execute();
                } else {
                    mySelf.count--;
                    new SendMessageCommand(new SendTimerStateMessage(new SendTimerStateData(ManagerLobby.myLobby.getTimer())), ManagerConnection.UDPBroadcast()).execute();
                }
            }
        });
        mySelf=this;
    }

    public void setCount(int count) {
        this.count=count;
    }

    public int getCount () {
        return this.count;
    }

    @Override
    public void start() {
        count=initCount;
        super.start();
    }
}
