package com.seu_pacote;

import java.util.Optional;

public interface PessoaRepository {
    void salvar(Pessoa pessoa);
    Optional<Pessoa> buscarPorCpf(String cpf);
    void excluir(String cpf);
    void atualizar(Pessoa pessoa);
}
