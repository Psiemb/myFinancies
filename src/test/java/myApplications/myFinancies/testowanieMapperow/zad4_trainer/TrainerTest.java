package myApplications.myFinancies.testowanieMapperow.zad4_trainer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class TrainerTest {

    @Mock
    private Parrot parrot;

    @Mock
    private Gwarek gwarek;

    @InjectMocks
    private Trainer trainer;

    @Test
    void shouldReternObieGadaja(){
        //given
        Mockito.when(parrot.saySomething()).thenReturn(true);
        Mockito.when(gwarek.gadaj()).thenReturn(true);

        //when
        Order order = trainer.orderForAnimal();

        //then
        assertEquals("Obie gadają", order.getWord());
    }

}