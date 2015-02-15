package model.messagedata.impl.statedata.impl;

import model.messagedata.impl.statedata.interfaces.SendStateData;
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
