package br.com.fiap.Inclusao.repository;

import br.com.fiap.Inclusao.model.Treinamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreinamentoRepository extends JpaRepository<Treinamento, Long> {
    List<Treinamento> findByColaboradorId(Long colaboradorId);
}
