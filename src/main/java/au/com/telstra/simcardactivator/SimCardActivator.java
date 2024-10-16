package au.com.telstra.simcardactivator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimCardActivator {

    private static final String ACTUATOR_URL = 'http://localhost:8444/actuate';

    public static void main(String[] args) {
        SpringApplication.run(SimCardActivator.class, args);
    }

}

@PostMapping("activate")
public String activateSim(@RequestBody ActivationRequest request) {
    RestTemplate restTemplate = new RestTemplate();

    
}