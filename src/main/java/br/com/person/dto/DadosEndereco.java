package br.com.person.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DadosEndereco {

    private String cep;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
}
