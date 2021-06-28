package br.com.person.repository;

import br.com.person.model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {

    PessoaModel findByCpf(String cpf);
}
