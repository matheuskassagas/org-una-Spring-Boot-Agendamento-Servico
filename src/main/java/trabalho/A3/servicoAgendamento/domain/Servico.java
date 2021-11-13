package trabalho.A3.servicoAgendamento.domain;

import trabalho.A3.servicoAgendamento.domain.enums.TipoLocal;
import trabalho.A3.servicoAgendamento.domain.enums.TipoTrabalho;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private TipoLocal tipoLocal;
    @Enumerated(EnumType.STRING)
    private TipoTrabalho tipoTrabalho;
    private Double valor;

    @ManyToOne
    private Endereco endereco;

    @OneToMany
    private List<Insumo> insumos = new ArrayList<>();

    @ManyToOne
    private Profissional profissional;


    public Servico(){}


    public Servico(String nome, TipoLocal tipoLocal, TipoTrabalho tipoTrabalho, Double valor, Endereco endereco, List<Insumo> insumos, Profissional profissional) {
        this.nome = nome;
        this.tipoLocal = tipoLocal;
        this.tipoTrabalho = tipoTrabalho;
        this.valor = valor;
        this.endereco = endereco;
        this.insumos = insumos;
        this.profissional = profissional;
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

    public TipoLocal getTipoLocal() {
        return tipoLocal;
    }

    public void setTipoLocal(TipoLocal tipoLocal) {
        this.tipoLocal = tipoLocal;
    }

    public TipoTrabalho getTipoTrabalho() {
        return tipoTrabalho;
    }

    public void setTipoTrabalho(TipoTrabalho tipoTrabalho) {
        this.tipoTrabalho = tipoTrabalho;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Insumo> getInsumos() {
        return insumos;
    }

    public void setInsumos(List<Insumo> insumos) {
        this.insumos = insumos;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Servico servico = (Servico) o;
        return getId().equals(servico.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
