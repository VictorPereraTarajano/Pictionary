package model.messagedata.impl.statedata.impl;

import model.data.Data;
import model.messagedata.impl.statedata.interfaces.SendStateData;
import model.player.Player;

public class SendScoringStateData extends SendStateData {

    private Player[] players;

    public SendScoringStateData(Player[] players) {
        this.players = players;
    }

    public Player[] getPlayers() {
        return players;
    }

    @Override
    public Data[] getData() {
        return new Data[0];
    }
}
