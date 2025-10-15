package br.com.fiap.Inclusao.controller;

import br.com.fiap.Inclusao.model.Treinamento;
import br.com.fiap.Inclusao.service.TreinamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/treinamentos")
public class TreinamentoController {

    @Autowired
    private TreinamentoService service;

    @GetMapping
    public List<Treinamento> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Treinamento> buscarPorId(@PathVariable Long id) {
        Treinamento treinamento = service.buscarPorId(id);
        if (treinamento == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(treinamento);
    }

    @PostMapping
    public ResponseEntity<Treinamento> cadastrar(@RequestBody Treinamento treinamento) {
        return ResponseEntity.ok(service.salvar(treinamento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Treinamento> atualizar(@PathVariable Long id, @RequestBody Treinamento atualizado) {
        Treinamento existente = service.buscarPorId(id);
        if (existente == null) return ResponseEntity.notFound().build();
        atualizado.setId(id);
        return ResponseEntity.ok(service.salvar(atualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (service.buscarPorId(id) == null) return ResponseEntity.notFound().build();
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/colaborador/{colaboradorId}")
    public ResponseEntity<List<Treinamento>> listarPorColaborador(@PathVariable Long colaboradorId) {
        return ResponseEntity.ok(service.listarPorColaborador(colaboradorId));
    }
}
