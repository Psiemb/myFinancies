package myApplications.myFinancies.testowanieMapperow.zad2_budowa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Kierownik {

    @Autowired
    private Majster majster;

    public Faktura fakturaZaElementBudowlany() {
        Faktura faktura = new Faktura();

        boolean czyZbudowane = this.majster.zbudujCosTam();

        if(czyZbudowane) {
            faktura.setWartosc(100);
        }
        else {
            faktura.setWartosc(0);
        }

        return faktura;
    }
}
