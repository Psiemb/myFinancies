package myApplications.myFinancies.controller;

import myApplications.myFinancies.service.offer.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@RestController
public class OfferController {
//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private OfferService offerService;

    @GetMapping("/offer2")
    public MuOfferResponse myOffer() {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<OfferResponse> responseFromOfferApplication =
                restTemplate.getForEntity("http://localhost:8080/offer", OfferResponse.class);

//        ResponseEntity<OfferResponse> exchange = this.restTemplate.exchange("localhost:8080", HttpMethod.GET, null, OfferResponse.class);

        OfferResponse body = responseFromOfferApplication.getBody();
        HttpHeaders headers = responseFromOfferApplication.getHeaders();
        HttpStatus statusCode = responseFromOfferApplication.getStatusCode();

        int average = Objects.requireNonNull(responseFromOfferApplication.getBody()).getAverage();
        String month = Objects.requireNonNull(responseFromOfferApplication.getBody()).getMonth();

        String noweImie = "Pan ";

        MuOfferResponse muOfferResponse = new MuOfferResponse();
        muOfferResponse.setMonth(month);
        muOfferResponse.setAverage(average - 20000);
        muOfferResponse.setName(noweImie + muOfferResponse.getName());
//        OfferResponse offerResponse = new OfferResponse();

        return muOfferResponse;

    }

    @GetMapping("/surname")
    public NameAndSurnameResponse myOfferName() {
        NameAndSurnameResponse nameAndSurnameResponse = new NameAndSurnameResponse();

        ResponseEntity<NameResponse> responseFromOfferApplicationName = offerService.getName();

        if(HttpStatus.OK.equals(responseFromOfferApplicationName.getStatusCode())) {
            String name = Objects.requireNonNull(responseFromOfferApplicationName.getBody()).getName();
            String fullName = name + " Krzysztof";

            nameAndSurnameResponse.setName(fullName);
        }

        return nameAndSurnameResponse;
    }
}
