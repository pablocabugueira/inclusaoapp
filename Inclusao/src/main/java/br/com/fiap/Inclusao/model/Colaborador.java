package br.com.fiap.Inclusao.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Gênero é obrigatório")
    private String genero;

    @NotBlank(message = "Etnia é obrigatória")
    private String etnia;

    @NotNull(message = "Campo PCD é obrigatório")
    private Boolean pcd;

    @NotBlank(message = "Departamento é obrigatório")
    private String departamento;

    @NotNull(message = "Data de admissão é obrigatória")
    private LocalDate dataAdmissao;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public String getEtnia() { return etnia; }
    public void setEtnia(String etnia) { this.etnia = etnia; }

    public Boolean getPcd() { return pcd; }
    public void setPcd(Boolean pcd) { this.pcd = pcd; }

    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }

    public LocalDate getDataAdmissao() { return dataAdmissao; }
    public void setDataAdmissao(LocalDate dataAdmissao) { this.dataAdmissao = dataAdmissao; }
}