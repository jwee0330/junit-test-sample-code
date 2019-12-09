package junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertAllTest {

    @Test
    void groupedAssertions() {
        Student student = new Student("jayden", "lee");

        assertAll(
                "student",
                () -> assertEquals("jayden", student.getFirstName()),
                () -> assertEquals("lee", student.getLastName())
        );
    }
}
