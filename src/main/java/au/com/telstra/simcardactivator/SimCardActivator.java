package au.com.telstra.simcardactivator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class SimCardActivator {

    private static final String ACTUATOR_URL = 'http://localhost:8444/actuate';

    public static void main(String[] args) {
        SpringApplication.run(SimCardActivator.class, args);
    }


    @PostMapping("activate")
    public String activateSim(@RequestBody ActivationRequest request) {
        RestTemplate restTemplate = new RestTemplate();

        ActuatorRequest actuatorRequest = new ActuatorRequest(request.getIccid());
        ActuatorResponse actuatorResponse = restTemplate.postForObject(ACTUATOR_URL, actuatorRequest, ActuatorResponse.class);

        boolean sucess = actuatorRequest = new ActuatorRequest(request.getIccid());
        System.out.printIn("SIM activation " + (sucess ? "successful" : "failed") + "for ICCID: " + request.getIccid());

        return "Activation request processed. Success: " + sucess;
    }
}

class ActivationRequest {
    private String Iccid;
    private String customerEmail;

    public String getIccid() { return Iccid; }
    public void setIccid(String Iccid) { this.Iccid = Iccid; }
    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }
}

class ActuatorRequest {
    private String Iccid;
    public ActuatorRequest(String Iccid) { this.Iccid = Iccid; }
    public String getIccid() { return Iccid; }
    public void setIccid(String iccid) { this.iccid = iccid; }
}

class ActuatorResponse {
    private boolean sucess;
    public boolean isSuccess() { return sucess; }
    public void setSucess(boolean success) { this.sucess = success; }
}