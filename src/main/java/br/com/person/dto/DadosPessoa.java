package br.com.person.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DadosPessoa {

    @NotNull(message = "Nome é obrigatório")
    @NotEmpty(message = "Nome não pode ser vazio")
    private String nome;

    @NotNull(message = "Sobrenome é obrigatório")
    @NotEmpty(message = "Sobrenome não pode ser vazio")
    private String sobrenome;

    @NotNull(message = "Idade é obrigatório")
    @NotEmpty(message = "Idade não pode ser vazio")
    private String idade;

    @NotNull(message = "RG é obrigatório")
    @NotEmpty(message = "RG não pode ser vazio")
    private String rg;

    @NotNull(message = "CPF é obrigatório")
    @NotEmpty(message = "CPF não pode ser vazio")
    @CPF
    private String cpf;
}
