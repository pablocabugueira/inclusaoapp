package br.com.fiap.Inclusao.service;

import br.com.fiap.Inclusao.model.Treinamento;
import br.com.fiap.Inclusao.repository.TreinamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreinamentoService {

    @Autowired
    private TreinamentoRepository repository;

    public List<Treinamento> listarTodos() {
        return repository.findAll();
    }

    public Treinamento buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Treinamento salvar(Treinamento treinamento) {
        return repository.save(treinamento);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public List<Treinamento> listarPorColaborador(Long colaboradorId) {
        return repository.findByColaboradorId(colaboradorId);
    }
}
