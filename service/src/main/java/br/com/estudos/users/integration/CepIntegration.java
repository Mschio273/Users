package br.com.estudos.users.integration;

import br.com.estudos.users.CepClient;
import br.com.estudos.users.model.Address;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CepIntegration {

    public Address findByCep(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        return CepClient.getRestTemplate().getForObject(url, Address.class);
    }
}
