package uz.pdp.spring_boot_lessons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class BeltLogRes implements Serializable {

    private Long id;

    private String endpoint;

    private String request;

    private String response;

    private String beltReqId;


    public BeltLogRes() {
        this.endpoint = "http://localhost:8080";
        this.request = "GET " + this.endpoint + " HTTP/1.1";
        this.response = "HTTP/1.1 200 OK";
        this.beltReqId = "";
    }
}
