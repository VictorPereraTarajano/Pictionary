package model.timer;

import controller.impl.sendcommand.SendMessageCommand;
import model.manager.ManagerConnection;
import model.manager.ManagerLobby;
import model.message.impl.state.impl.SendTimerStateMessage;
import model.messagedata.impl.statedata.impl.SendTimerStateData;

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
                new SendMessageCommand(new SendTimerStateMessage(new SendTimerStateData(--mySelf.count)), ManagerConnection.TCPBroadcast(ManagerLobby.myLobby.getScoring().getPlayers())).execute();
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
