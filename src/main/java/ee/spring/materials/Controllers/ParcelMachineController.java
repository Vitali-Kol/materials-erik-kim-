package ee.spring.materials.Controllers;

import ee.spring.materials.models.ParcelMachine;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin("http://localhost:3000")
@RestController
public class ParcelMachineController {

    @GetMapping("parcel-machines")
    public ParcelMachine[] getParcelMachines() {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ParcelMachine[]> response = restTemplate
                .exchange("https://www.omniva.ee/locations.json",
                        HttpMethod.GET, null, ParcelMachine[].class);

        return response.getBody();
    }
}
