package br.com.person.service;

import br.com.person.dto.DadosPessoa;
import br.com.person.model.PessoaModel;
import br.com.person.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public void save(DadosPessoa dadosPessoa) {
        pessoaRepository.save(PessoaModel
                .builder()
                .nome(dadosPessoa.getNome())
                .sobrenome(dadosPessoa.getSobrenome())
                .idade(dadosPessoa.getIdade())
                .rg(dadosPessoa.getRg())
                .cpf(dadosPessoa.getCpf())
                .build());
    }
}