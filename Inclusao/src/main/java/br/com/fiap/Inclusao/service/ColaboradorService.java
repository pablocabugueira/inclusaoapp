package br.com.fiap.Inclusao.service;

import br.com.fiap.Inclusao.dto.RelatorioDepartamentoDTO;
import br.com.fiap.Inclusao.model.Colaborador;
import br.com.fiap.Inclusao.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository repository;

    public List<Colaborador> listarTodos() {
        return repository.findAll();
    }

    public Optional<Colaborador> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Colaborador salvar(Colaborador colaborador) {
        return repository.save(colaborador);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public List<RelatorioDepartamentoDTO> relatorioPorDepartamento() {
        return repository.countColaboradoresPorDepartamento();
    }
}
