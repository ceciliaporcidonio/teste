package com.seu_pacote;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PessoaServiceTest {

    @Mock
    private PessoaRepository repository;

    @InjectMocks
    private PessoaService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void salvarPessoaDeveChamarMetodoSalvarDoRepository() {
        Pessoa pessoa = new Pessoa("Ana", "12345678900", "F");
        service.salvar(pessoa);
        verify(repository, times(1)).salvar(pessoa);
    }

    @Test
    void buscarPorCpfDeveRetornarPessoaSeEncontrada() {
        Pessoa pessoa = new Pessoa("Ana", "12345678900", "F");
        when(repository.buscarPorCpf("12345678900")).thenReturn(Optional.of(pessoa));

        Optional<Pessoa> resultado = service.buscarPorCpf("12345678900");

        assertTrue(resultado.isPresent());
        assertEquals("Ana", resultado.get().getNome());
    }

    @Test
    void excluirPessoaDeveChamarMetodoExcluirDoRepository() {
        service.excluir("12345678900");
        verify(repository, times(1)).excluir("12345678900");
    }

    @Test
    void atualizarPessoaDeveChamarMetodoAtualizarDoRepository() {
        Pessoa pessoa = new Pessoa("Ana", "12345678900", "F");
        service.atualizar(pessoa);
        verify(repository, times(1)).atualizar(pessoa);
    }
}
