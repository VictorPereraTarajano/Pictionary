package model.scoring;

public class Score {

    private int score;

    public Score(int score) {
        this.score = score;
    }

    public Score () {
        this.score=0;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
