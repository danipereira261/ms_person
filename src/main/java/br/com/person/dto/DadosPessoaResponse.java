package br.com.person.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DadosPessoaResponse {

    private String nome;
    private String sobrenome;
    private String idade;
    private String rg;
    private String cpf;
    private DadosEndereco dadosEndereco;
}
