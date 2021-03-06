package model.timer;

import controller.impl.command.timer.UpdateTimerCommand;
import controller.impl.command.turn.StopTurnCommand;
import controller.impl.command.word.UpdateWordDisplayCommand;
import controller.impl.sendcommand.SendCommand;
import model.manager.ManagerConnection;
import model.manager.ManagerLobby;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class Timer extends javax.swing.Timer implements Serializable {

    public static final int INIT_COUNT = 99;
    private int count = INIT_COUNT;

    public Timer() {
        super(1000,new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                if (ManagerLobby.myLobby.getTimer().getCount() <= 0) {
                    new StopTurnCommand("").execute();
                } else {
                    if (checkDecodeWord(ManagerLobby.myLobby.getTimer().count))
                        new SendCommand(new UpdateWordDisplayCommand(), ManagerConnection.TCPBroadcast(ManagerLobby.myLobby.getGame().currentTurn().getNonPainterPlayers())).execute();
                new SendCommand(new UpdateTimerCommand(ManagerLobby.myLobby.getTimer().getCount() - 1), ManagerConnection.TCPBroadcastAll()).execute();
                }
            }
        });
    }

    private static boolean checkDecodeWord (int time) {
        return Math.abs(time-INIT_COUNT)%((INIT_COUNT / (ManagerLobby.myLobby.getGame().currentTurn().getWord().length() / 2)) + 10) ==0;
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
