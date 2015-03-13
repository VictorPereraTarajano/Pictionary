package controller.impl.sendcommand.statemessagedata.impl;

import controller.impl.sendcommand.statemessagedata.interfaces.SendStateData;
import model.scoring.Scoring;

public class SendScoringStateData extends SendStateData {

    private Scoring scoring;

    public SendScoringStateData(Scoring scoring) {
        super();
        this.scoring = scoring;
    }

    public Scoring getScoring() {
        return scoring;
    }
}
