package br.com.person.service;

import br.com.person.dto.DadosPessoaRequest;
import br.com.person.dto.DadosPessoaResponse;
import br.com.person.gateway.IntegrationPersonAdress;
import br.com.person.model.PessoaModel;
import br.com.person.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private IntegrationPersonAdress integrationPersonAdress;

    public void save(DadosPessoaRequest dadosPessoa) {
        pessoaRepository.save(PessoaModel
                .builder()
                .nome(dadosPessoa.getNome())
                .sobrenome(dadosPessoa.getSobrenome())
                .idade(dadosPessoa.getIdade())
                .rg(dadosPessoa.getRg())
                .cpf(dadosPessoa.getCpf())
                .cep(dadosPessoa.getCep())
                .build());
    }

    public DadosPessoaResponse buscaCpf(String cpf) {

        PessoaModel pessoa = pessoaRepository.findByCpf(cpf);

        return DadosPessoaResponse.
                builder()
                .nome(pessoa.getNome())
                .sobrenome(pessoa.getSobrenome())
                .idade(pessoa.getIdade())
                .rg(pessoa.getRg())
                .cpf(pessoa.getCpf())
                .dadosEndereco(integrationPersonAdress.getAdress(pessoa.getCep()))
                .build();
    }
}
