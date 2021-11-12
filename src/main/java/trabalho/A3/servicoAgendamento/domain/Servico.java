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
    private String cargo;
    private String empresa;
    @Enumerated(EnumType.STRING)
    private TipoLocal tipoLocal;
    @Enumerated(EnumType.STRING)
    private TipoTrabalho tipoTrabalho;
    private Double valor;

    @ManyToOne
    private Endereco endereco;

    @ManyToOne
    private Cliente cliente;

    @OneToMany
    private List<Insumo> insumos = new ArrayList<>();

    @ManyToOne
    private Agendamento agendamento;

    @ManyToOne
    private Profissional profissional;


    public Servico(){}


    public Servico(String cargo, String empresa, TipoLocal tipoLocal, TipoTrabalho tipoTrabalho, Double valor, Endereco endereco, Cliente cliente, List<Insumo> insumos, Agendamento agendamento, Profissional profissional) {
        this.cargo = cargo;
        this.empresa = empresa;
        this.tipoLocal = tipoLocal;
        this.tipoTrabalho = tipoTrabalho;
        this.valor = valor;
        this.endereco = endereco;
        this.cliente = cliente;
        this.insumos = insumos;
        this.agendamento = agendamento;
        this.profissional = profissional;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
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

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
