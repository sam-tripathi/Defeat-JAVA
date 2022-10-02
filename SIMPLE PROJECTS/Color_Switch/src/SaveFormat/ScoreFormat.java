package SaveFormat;

import java.io.Serializable;

public class ScoreFormat implements Serializable {
    private static final long serialVersionUID = 2L;
    private int score;
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public ScoreFormat(int score) {
        this.score = score;
    }

    public static void storeScore () {

    }

}
