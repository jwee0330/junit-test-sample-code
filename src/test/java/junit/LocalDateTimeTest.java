package junit;

import org.assertj.core.data.TemporalUnitWithinOffset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;

class LocalDateTimeTest {
    private LocalDateTime dateTimeExpected;
    private Clock clock;

    @BeforeEach
    void setUp() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.systemDefault());
        dateTimeExpected = LocalDateTime.of(2019, 12, 3, 1, 0);
        Instant nowInstant = dateTimeExpected.toInstant(zonedDateTime.getOffset());
        clock = Clock.fixed(nowInstant, ZoneId.systemDefault());
    }

    @Test
    void timeTest() {
        String expectedDateTime = "2019-12-03T01:00:00.000";
        LocalDateTime expectedParseLocalDateTime = LocalDateTime.parse(expectedDateTime);

        TemporalUnitWithinOffset temporalUnitWithinOffset = new TemporalUnitWithinOffset(1000, ChronoUnit.NANOS);
        assertThat(expectedParseLocalDateTime).isCloseTo(dateTimeExpected, temporalUnitWithinOffset);
        assertThat(expectedParseLocalDateTime).isCloseTo(expectedParseLocalDateTime, temporalUnitWithinOffset);
        assertThat(expectedParseLocalDateTime).isEqualTo(dateTimeExpected);
        assertThat(expectedParseLocalDateTime).isEqualTo(expectedParseLocalDateTime);
    }

    @Test
    public void givenFixedClock_whenNow_thenGetFixedInstant() {
        String instantExpected = "2014-12-22T10:15:30Z";
        Clock clock = Clock.fixed(Instant.parse(instantExpected), ZoneId.of("UTC"));

        Instant instant = Instant.now(clock);

        assertThat(instant.toString()).isEqualTo(instantExpected);
    }
}
