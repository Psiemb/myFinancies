package myApplications.myFinancies.testowanieMapperow.zad2_budowa;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class KierownikTest {

    @Mock
    private Majster majster;

    @InjectMocks
    private Kierownik kierownik;

    @Test
    void shouldReturn100WhenMajsterReturnTrue() {
        // given
        Mockito.when(majster.zbudujCosTam()).thenReturn(true);

        // when
        Faktura faktura = kierownik.fakturaZaElementBudowlany();

        // then
        assertEquals(100, faktura.getWartosc());

    }

}