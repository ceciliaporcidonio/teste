package com.seu_pacote;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PessoaRepositoryMemoria implements PessoaRepository {

    private Map<String, Pessoa> bancoDeDados = new HashMap<>();

    @Override
    public void salvar(Pessoa pessoa) {
        bancoDeDados.put(pessoa.getCpf(), pessoa);
    }

    @Override
    public Optional<Pessoa> buscarPorCpf(String cpf) {
        return Optional.ofNullable(bancoDeDados.get(cpf));
    }

    @Override
    public void excluir(String cpf) {
        bancoDeDados.remove(cpf);
    }

    @Override
    public void atualizar(Pessoa pessoa) {
        bancoDeDados.put(pessoa.getCpf(), pessoa);
    }
}
