package br.com.fiap.Inclusao.repository;

import br.com.fiap.Inclusao.model.Colaborador;
import br.com.fiap.Inclusao.dto.RelatorioDepartamentoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
    List<Colaborador> findByDepartamento(String departamento);

    @Query("SELECT new br.com.fiap.Inclusao.dto.RelatorioDepartamentoDTO(c.departamento, COUNT(c)) FROM Colaborador c GROUP BY c.departamento")
    List<RelatorioDepartamentoDTO> countColaboradoresPorDepartamento();
}
