package br.com.person.controller;

import br.com.person.dto.DadosPessoa;
import br.com.person.dto.DefautResponse;
import br.com.person.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(name = "/v1/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping(value = "cadastrar")
    public ResponseEntity<DefautResponse> cadastrar(@Valid @RequestBody DadosPessoa dadosPessoa) {
        pessoaService.save(dadosPessoa);
        return new ResponseEntity<>(DefautResponse
                .builder()
                .message("Dados resgitrados com sucesso")
                .build(), HttpStatus.CREATED);
    }
}
