package junit;

import java.util.ArrayList;
import java.util.List;

public class ScoreCollection {
    private List<Score> scores = new ArrayList<>();

    public void add(Score score) {
        scores.add(score);
    }

    public int arithmeticMean() {
        int total = scores.stream().mapToInt(Score::getSum).sum();
        return total / scores.size();
    }

}
