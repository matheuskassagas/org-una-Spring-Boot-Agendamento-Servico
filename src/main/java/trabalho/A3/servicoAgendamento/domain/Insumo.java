package trabalho.A3.servicoAgendamento.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Insumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Servico servico;

    public Insumo(){}

    public Insumo(String nome, String descricao, Servico servico) {
        this.nome = nome;
        this.descricao = descricao;
        this.servico = servico;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Insumo insumo = (Insumo) o;
        return getId().equals(insumo.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
