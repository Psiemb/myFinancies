package myApplications.myFinancies.testowanieMapperow.zad3_school;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class DirectorTest {

    @Mock
    private Teacher teacher;

    @InjectMocks
    private Director director;

    @Test
    void shouldReturnSuperWhenTeacherReturnTrue() {
        // given
        Mockito.when(teacher.sign()).thenReturn(true);

        // when
        Certyficate certyficate = director.promotionCertyfikate();

        // then
        assertEquals("Super", certyficate.getSignature());

    }
    @Test
    void shouldReturnNicWhenTeacherReturnTrue() {
        // given
        Mockito.when(teacher.sign()).thenReturn(false);

        // when
        Certyficate certyficate = director.promotionCertyfikate();

        // then
        assertEquals("Nic", certyficate.getSignature());

    }
}