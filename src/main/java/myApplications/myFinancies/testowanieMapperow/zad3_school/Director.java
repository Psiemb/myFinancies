package myApplications.myFinancies.testowanieMapperow.zad3_school;

import org.springframework.stereotype.Component;

@Component
public class Director {

    private Teacher teacher;

    public Certyficate promotionCertyfikate(){

        Certyficate certyficate = new Certyficate();

        boolean signCertyficate = this.teacher.sign();

        if (signCertyficate){
            certyficate.setSignature("Super");
        }
        else certyficate.setSignature("Nic");

        return certyficate;
    }
}
