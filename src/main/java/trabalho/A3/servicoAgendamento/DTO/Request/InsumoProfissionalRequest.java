package trabalho.A3.servicoAgendamento.DTO.Request;

import javax.validation.constraints.NotBlank;

public class InsumoProfissionalRequest {

    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;

    public InsumoProfissionalRequest() {
    }

    public InsumoProfissionalRequest(@NotBlank String nome, @NotBlank String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
