package br.com.person.controller;

import br.com.person.dto.DadosPessoaRequest;
import br.com.person.dto.DadosPessoaResponse;
import br.com.person.dto.DefautResponse;
import br.com.person.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<DefautResponse> cadastrar(@Valid @RequestBody DadosPessoaRequest dadosPessoaRequest ) {
        pessoaService.save(dadosPessoaRequest);
        return new ResponseEntity<>(DefautResponse
                .builder()
                .message("Dados resgitrados com sucesso")
                .build(), HttpStatus.CREATED);
    }

    @GetMapping(value = "/listar-pessoas/{cpf}")
    public ResponseEntity<DadosPessoaResponse> listarPessoa(@PathVariable String cpf) {
        return new ResponseEntity<>(pessoaService.buscaCpf(cpf), HttpStatus.OK);
    }
}
