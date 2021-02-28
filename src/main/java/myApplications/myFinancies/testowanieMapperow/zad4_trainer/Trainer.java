package myApplications.myFinancies.testowanieMapperow.zad4_trainer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public class Trainer {

    @Autowired
    private Parrot parrot;

    @Autowired
    private Gwarek gwarek;

    public Order orderForAnimal(){
        Order order = new Order();

        boolean parrotSay = parrot.saySomething();
        boolean gwarekGadaj = gwarek.gadaj();

        if(parrotSay && gwarekGadaj){
            order.setWord("Obie gadają");
        }
        else {
            order.setWord("Nie gadają obie");
        }

        return order;
    }

}
