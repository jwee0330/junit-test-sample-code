package junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void dependentAssertions() {
        // 코드 블럭 안에서 assertion 실패한다면 같은 블럭의 코드는 스킵된다.

        Student student = new Student("jayden", "lee");

        assertAll("properties",
                () -> {
                    String firstName = student.getFirstName();
                    assertNotNull(firstName);

                    // 위 assert 성공 할 경우에만 실행한다.
                    assertAll("first name",
                            () -> assertTrue(firstName.startsWith("j")),
                            () -> assertTrue(firstName.endsWith("n"))
                    );
                },
                () -> {
                    // 그룹으로 묶인 assertion들은 다른 그룹의 assertion 결과에 독립적으로 수행한다.
                    String lastName = student.getLastName();
                    assertNotNull(lastName);

                    // 위 assert 성공 할 경우에만 실행한다.
                    assertAll("last name",
                            () -> assertTrue(lastName.startsWith("l")),
                            () -> assertTrue(lastName.endsWith("e"))
                    );
                }
        );
    }
}
