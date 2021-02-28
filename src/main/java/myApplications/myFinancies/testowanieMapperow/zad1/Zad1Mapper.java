package myApplications.myFinancies.testowanieMapperow.zad1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Zad1Mapper {

    private static final int MULTIPLIER = 2;

    @Autowired
    private Zad1AcceptedMapper zad1AcceptedMapper;

    public Zad1Response map(Zad1Request request) {
        if(Objects.isNull(request)) {
            return null;
        }

        int price2FromRequest = request.getPrice2();

        Zad1Response result = new Zad1Response();
        result.setPrice1(request.getPrice1() * MULTIPLIER);
        result.setPrice2(price2FromRequest * MULTIPLIER);
        result.setAccepted(zad1AcceptedMapper.accepted(MULTIPLIER));

        return result;
    }
}
