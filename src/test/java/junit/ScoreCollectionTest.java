package junit;


import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreCollectionTest {

    @Test
    void answerArithmeticMeanOfTwoNumbers() {
        // given
        ScoreCollection collection = new ScoreCollection();
        collection.add(() -> 5);
        collection.add(() -> 7);

        // when
        int actualResult = collection.arithmeticMean();

        // then
        assertThat(actualResult).isEqualTo(6);

    }

    @Test
    void getMeanOfScoreSum() {
        ScoreCollection scoreCollection = new ScoreCollection();
        scoreCollection.add(new IntegerScore(30));
        scoreCollection.add(new IntegerScore(20));
        assertThat(scoreCollection.arithmeticMean())
                .isEqualTo(25);
    }

    @Test
    void getDifferenceOfTwoDouble() {
        assertThat(2.32 * 3).isEqualTo(6.96);
    }

    @Test
    void getDifferenceOfFloatPointDecimal() {
        assertThat(2.32 * 3 - 6.96 < 0.0005).isTrue();
    }

    @Test
    void isEqualTwoDoubleCloseToOffset() {
        assertThat(2.32 * 3).isCloseTo(6.96, Offset.offset(0.0005));
    }
}
