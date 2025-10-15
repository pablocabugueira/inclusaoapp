package br.com.fiap.Inclusao.dto;

public class RelatorioDepartamentoDTO {
    private String departamento;
    private Long quantidade;

    public RelatorioDepartamentoDTO(String departamento, Long quantidade) {
        this.departamento = departamento;
        this.quantidade = quantidade;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
}