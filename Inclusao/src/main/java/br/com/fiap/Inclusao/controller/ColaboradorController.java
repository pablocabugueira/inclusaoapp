package br.com.fiap.Inclusao.controller;

import br.com.fiap.Inclusao.dto.RelatorioDepartamentoDTO;
import br.com.fiap.Inclusao.model.Colaborador;
import br.com.fiap.Inclusao.service.ColaboradorService;
import br.com.fiap.Inclusao.exception.ColaboradorNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorService service;

    @GetMapping
    public List<Colaborador> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Colaborador> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(
                service.buscarPorId(id).orElseThrow(() -> new ColaboradorNotFoundException(id)));
    }

    @PostMapping
    public ResponseEntity<Colaborador> cadastrar(@Valid @RequestBody Colaborador colaborador) {
        return ResponseEntity.ok(service.salvar(colaborador));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Colaborador> atualizar(@PathVariable Long id, @Valid @RequestBody Colaborador atualizado) {
        service.buscarPorId(id).orElseThrow(() -> new ColaboradorNotFoundException(id));
        atualizado.setId(id);
        return ResponseEntity.ok(service.salvar(atualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.buscarPorId(id).orElseThrow(() -> new ColaboradorNotFoundException(id));
        try {
            service.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Não é possível deletar: colaborador está vinculado a outros registros.");
        }
    }


    @GetMapping("/relatorio/departamentos")
    public ResponseEntity<List<RelatorioDepartamentoDTO>> relatorioPorDepartamento() {
        return ResponseEntity.ok(service.relatorioPorDepartamento());
    }
}
