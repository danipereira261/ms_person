package br.com.person.gateway;

import br.com.person.dto.DadosEndereco;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IntegrationPersonAdress {

    @SneakyThrows
    public DadosEndereco getAdress(String cep) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://localhost:8080/v1/cep/listar-enderecos/" + cep;
            System.out.println(url);

            ResponseEntity<DadosEndereco> restIntegration = restTemplate.getForEntity(url, DadosEndereco.class);

            return restIntegration.getBody();
        } catch (Exception e) {
            throw new Exception("Falha de comunicação ao buscar o endereço");
        }
    }
}
