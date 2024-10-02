package com.seu_pacote;

import java.util.Optional;

public class PessoaService {

    private PessoaRepository repository;

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public void salvar(Pessoa pessoa) {
        repository.salvar(pessoa);
    }

    public Optional<Pessoa> buscarPorCpf(String cpf) {
        return repository.buscarPorCpf(cpf);
    }

    public void excluir(String cpf) {
        repository.excluir(cpf);
    }

    public void atualizar(Pessoa pessoa) {
        repository.atualizar(pessoa);
    }
}
