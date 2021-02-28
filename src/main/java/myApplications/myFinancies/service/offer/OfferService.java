package myApplications.myFinancies.service.offer;

import myApplications.myFinancies.controller.NameResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OfferService {

    public static final String OFFER_APP_URL = "http://localhost:8080/name";

    private RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<NameResponse> getName() {
        return restTemplate.getForEntity(OFFER_APP_URL, NameResponse.class);
    }
}
