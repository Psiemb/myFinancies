package myApplications.myFinancies.testowanieMapperow.zad1;

import org.springframework.stereotype.Component;

@Component
public class Zad1AcceptedMapper {

    public boolean accepted(int multiplier) {
        if (multiplier < 2) {
            return false;
        }
        return true;
    }
}
