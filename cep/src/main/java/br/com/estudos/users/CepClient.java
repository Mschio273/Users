package br.com.estudos.users;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CepClient {
    public static RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
