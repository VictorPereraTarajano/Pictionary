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

    public static final int initCount = 90;
    private int count = initCount;
    private static Timer mySelf;

    public Timer() {
        super(1000,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mySelf.count <= 0) {
                    try {
                        new SendMessageCommand(new SendTurnStateMessage(new SendTurnStateData(0)), ManagerConnection.TCPBroadcast(ManagerLobby.myLobby.getScoring().getPlayers())).execute();
                        finalize();
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                } else {
                    new SendMessageCommand(new SendTimerStateMessage(new SendTimerStateData(--mySelf.count)), ManagerConnection.TCPBroadcast(ManagerLobby.myLobby.getScoring().getPlayers())).execute();
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
