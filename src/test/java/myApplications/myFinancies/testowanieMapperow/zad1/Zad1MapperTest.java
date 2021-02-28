package myApplications.myFinancies.testowanieMapperow.zad1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class Zad1MapperTest {

    @Mock
    private Zad1AcceptedMapper zad1AcceptedMapper;

    @InjectMocks
    private Zad1Mapper zad1Mapper;

    //TODO: gdy jest @InjectMocks, wtedy nie możesz sam tworzyc obiketu ktory testeujesz. Poniewaz nadpiszesz obiekt stworzony przez Mockito
//    @BeforeEach
//    private void setUp() {
//        this.zad1Mapper = new Zad1Mapper();
//    }

    @Test
    void test2() {
        // given
        Zad1Request request = new Zad1Request();
        request.setPrice1(10);
        request.setPrice2(15);

        Mockito.when(zad1AcceptedMapper.accepted(2)).thenReturn(true);

        // when
        Zad1Response result = zad1Mapper.map(request);

        // then
        assertTrue(result.isAccepted());
    }


    @Test
    void shouldReturnNullWhenNullAsParameter() {
        // given

        // when
        Zad1Response result = zad1Mapper.map(null);

        // then
        assertNull(result);
    }

    @Test
    void test() {
        // given
        Zad1Request request = new Zad1Request();
        request.setPrice1(10);
        request.setPrice2(15);

        // when
        Zad1Response result = zad1Mapper.map(request);

        // then
        assertEquals(20, result.getPrice1());
        assertEquals(30, result.getPrice2());
    }

}